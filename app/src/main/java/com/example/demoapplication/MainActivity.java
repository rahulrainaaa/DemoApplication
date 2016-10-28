package com.example.demoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.editText1);
        text2 = (TextView) findViewById(R.id.editText2);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rows = text1.getText().toString();
                String columns = text2.getText().toString();

                Constants.rows = Integer.parseInt("0" + rows.trim());
                Constants.columns = Integer.parseInt("0" + columns.trim());

                Toast.makeText(MainActivity.this, "Generating Table.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ListActivity.class));

            }
        });

    }


}
