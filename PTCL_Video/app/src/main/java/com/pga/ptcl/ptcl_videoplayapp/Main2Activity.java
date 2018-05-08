package com.pga.ptcl.ptcl_videoplayapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {
    Button playBtn;
    VideoView v;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ptcllogo);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.argb(255,0,0,1)));

        setContentView(R.layout.activity_main2);

        mediaController = new MediaController(this);
        videoplay(v);
    }

    public void videoplay(View v) {
        String fileName = "ptclvideo";

        String file = "android.resource://" + getPackageName() + "/raw/" + fileName;
        VideoView videoView = findViewById(R.id.SampleVideoView2);

        videoView.setVideoURI(Uri.parse(file));
        videoView.setMediaController(mediaController);

        mediaController.setAnchorView(videoView);

        videoView.start();
    }
}
