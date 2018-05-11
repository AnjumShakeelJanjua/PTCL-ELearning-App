package com.pga.ptcl.ptcl_videoplayapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final List<String> videoNames = new ArrayList<>();
    VideoView vv;
    MediaController mediaController;

    int currentVideoIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        vv = findViewById(R.id.SampleVideoView);
        Field[] fields = R.raw.class.getFields();

        for (Field field : fields) {
            videoNames.add(field.getName());
        }

        mediaController = new MediaController(this);
        videoplay(vv);
    }

    //Method for Playing the first video and setting the media controller
    public void videoplay(View v) {
        Intent intent = getIntent();

        String fileName = intent.getStringExtra("VideoName");
        currentVideoIndex = intent.getIntExtra("AdapterId", 1);

        String file = "android.resource://" + getPackageName() + "/raw/" + fileName;

        //Casting the View v to VideoView vid to access VideoView specific methods
        VideoView vid = (VideoView) v;

        vid.setVideoURI(Uri.parse(file));
        vid.setMediaController(mediaController);
        mediaController.setAnchorView(v);

        vid.start();

        ShowMediaControllerControls();
    }

    //Method responsible for next and previous controls
    public void ShowMediaControllerControls() {
        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentVideoIndex < videoNames.size())
                    currentVideoIndex++;
                Uri fileThis = Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoNames.get(currentVideoIndex));
                vv.setVideoURI(fileThis);
                vv.start();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentVideoIndex < videoNames.size())
                    currentVideoIndex--;
                Uri fileThis = Uri.parse("android.resource://" + getPackageName() + "/raw/" + videoNames.get(currentVideoIndex));
                vv.setVideoURI(fileThis);
                vv.start();
            }
        });
    }
}
