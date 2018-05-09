package com.pga.ptcl.ptcl_videoplayapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button playBtn;
    VideoView v;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mediaController = new MediaController(this);
        videoplay(v);
    }

    public void videoplay(View v) {
        Intent intent = getIntent();

        String fileName = intent.getStringExtra("FileNameBtn");

        String file = "android.resource://" + getPackageName() + "/raw/" + fileName;
        VideoView videoView = findViewById(R.id.SampleVideoView);

        videoView.setVideoURI(Uri.parse(file));
        videoView.setMediaController(mediaController);

        mediaController.setAnchorView(videoView);

        videoView.start();
    }

}
