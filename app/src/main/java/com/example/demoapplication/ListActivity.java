package com.example.demoapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends FragmentActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    LayoutInflater inflater;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        linearLayout = (LinearLayout) findViewById(R.id.linearlayout1);
        inflater = getLayoutInflater();

        for (int rows = 0; rows < Constants.rows; rows++) {
            ll = (LinearLayout)inflater.inflate(R.layout.layout, null);
            for (int cols = 0; cols < Constants.columns; cols++) {
                TextView textView = new TextView(this);
                textView.setText("" + rows + "," + cols + "");
                textView.setWidth(200);
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_rect_outline));
                } else {
                    textView.setBackground(getResources().getDrawable(R.drawable.shape_rect_outline));
                }
                textView.setPadding(10, 30, 0, 20);
                textView.setGravity(Gravity.CENTER);
                ll.addView(textView);
            }
            ll.setTag("Selected Row: " + rows);
            ll.setOnClickListener(this);
            linearLayout.addView(ll);
        }

    }

    @Override
    public void onClick(View v) {
        String str = (String)v.getTag();
        Toast.makeText(this, "" + str, Toast.LENGTH_SHORT).show();
    }
}
