package com.example.tp3_cbhering_di;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

public class PresentationVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_video);

        VideoView video = (VideoView) findViewById(R.id.videoLogo);
        Uri uriPath = Uri.parse("android.resource://".concat(getPackageName()).concat("/raw/") + R.raw.logovideo);
        video.setVideoURI(uriPath);
        video.requestFocus();
        video.start();

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), Presentation.class));
                finish();
            }
        }, 9000);
    }
}