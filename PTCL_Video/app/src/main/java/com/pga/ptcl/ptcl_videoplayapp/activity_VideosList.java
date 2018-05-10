package com.pga.ptcl.ptcl_videoplayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class activity_VideosList extends AppCompatActivity {

    String[] elements = {"First", "Second", "Third", "Fourth", "Fifth", "C#", "JavaScript"};
    private int[] listImages = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7};

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoslist);

        layoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.ProgrammingList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ProgrammingAdapter(elements, listImages,this));

    }
}

