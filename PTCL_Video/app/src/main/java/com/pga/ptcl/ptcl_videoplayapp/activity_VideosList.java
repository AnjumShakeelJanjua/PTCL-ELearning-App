package com.pga.ptcl.ptcl_videoplayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class activity_VideosList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.videoslist);

        String[] elements = {"First", "Second", "Third", "Fourth", "Fifth", "C#", "JavaScript", "Me Buu", "Kill You!", "The End Folks!"};

        RecyclerView programmingList = findViewById(R.id.ProgrammingList);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        programmingList.setAdapter(new ProgrammingAdapter(elements));
    }
}
