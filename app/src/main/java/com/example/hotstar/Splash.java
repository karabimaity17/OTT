package com.example.hotstar;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class Splash extends AppCompatActivity {

    ImageView imageView;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView= findViewById(R.id.imageView);
        text= findViewById(R.id.text);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        text.startAnimation(animation);
        Glide.with(Splash.this)
                .load(R.drawable.play)
                .into(imageView);
        Thread timer = new Thread(){

            @Override
            public void run() {

                try {
                    sleep(2500);
                    startActivity(new Intent(Splash.this,WelcomeActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    super.run();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        timer.start();
    }



    /*@Override
    public void initSplash(ConfigSplash configSplash) {
        //ActionBar actionBar=getSupportActionBar();
       // actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        configSplash.setBackgroundColor(R.color.colorPrimary);
        configSplash.setAnimCircularRevealDuration(2000);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);
        configSplash.setLogoSplash(R.drawable.play);
        configSplash.setAnimLogoSplashDuration(3000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);




        configSplash.setTitleSplash("Video Player");
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(Splash.this, MainActivity.class));
        finish();
    }*/

}
