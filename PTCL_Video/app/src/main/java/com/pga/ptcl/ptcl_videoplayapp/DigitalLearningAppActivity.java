package com.pga.ptcl.ptcl_videoplayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class DigitalLearningAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.digitallearningapp);

        ImageButton btn3 = findViewById(R.id.imgBtn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), activity_VideosList.class);

                startActivity(intent);
            }
        });

    }
}
