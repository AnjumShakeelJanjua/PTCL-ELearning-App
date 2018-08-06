package com.pga.ptcl.ptcl_videoplayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class activity_VideosList extends AppCompatActivity {

    String[] elements;
    private int[] listImages = {R.drawable.video1pic, R.drawable.video2pic, R.drawable.video3pic, R.drawable.video4pic, R.drawable.video5pic, R.drawable.video6pic, R.drawable.video7pic, R.drawable.video8pic};

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoslist);

        layoutManager = new LinearLayoutManager(this);
        elements = getResources().getStringArray(R.array.videoTitles);

        recyclerView = findViewById(R.id.ProgrammingList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ProgrammingAdapter(elements, listImages, this));

    }
}

