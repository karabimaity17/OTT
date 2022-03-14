package com.example.hotstar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Single_Page extends AppCompatActivity {

    VideoView videoView;
    MediaController media;
    ImageButton home;
    ImageView wishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_single__page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        videoView=findViewById(R.id.video);
        home=findViewById(R.id.home);
        wishlist=findViewById(R.id.img);



        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //Toast.makeText(Single_Page.this, "click", Toast.LENGTH_SHORT).show();
                home.setVisibility(View.VISIBLE);
                wishlist.setVisibility(View.VISIBLE);
                return false;
            }
        });

        /*videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                home.setVisibility(View.VISIBLE);
            }
        });*/


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Single_Page.this,MainActivity.class));
                finish();
            }
        });

        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Single_Page.this,Favourite_List.class));
                finish();
            }
        });

/*
        String videopath="android.resource://com.example.welcome2.video/"+R.raw.video;
*/
/*
        String videopath="rtsp://r3---sn-npoe7ned.googlevideo.com/Cj0LENy73wIaNAkxtGVX_ga_GhMYDSANFC2W4UpcMOCoAUIASARglsSLntX2joFcigELQ1pHWWZMSU53b0kM/DC3D1A622E0DE50EBF5C476257DEA650F519CBC4.0AC46ED74C5A9C009B8B0086EFF2F2C602C9F4AA/yt6/1/video.3gp";
*/
        String videopath="https://nolafoodboutique.com/hotel/dashboard/upload_pic/hotel_img/postcreditscene.mp4";
        Uri uri=Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(media);
        //media.setAnchorView(videoView);
        videoView.requestFocus();
        videoView.start();
    }
}
