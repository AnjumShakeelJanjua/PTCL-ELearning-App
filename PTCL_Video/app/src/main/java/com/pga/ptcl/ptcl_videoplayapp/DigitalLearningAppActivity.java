package com.pga.ptcl.ptcl_videoplayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DigitalLearningAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.digitallearningapp);

        CharSequence text = "IT'S EMPTY RIGHT NOW!";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(getApplicationContext(), text, duration);

        Button btn3 = findViewById(R.id.imgBtn3);
        Button btn4 = findViewById(R.id.imgBtn4);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), activity_VideosList.class);

                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });

    }
}
