package com.example.hotstar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout relaltive;
    TextView sign_up,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        relaltive= findViewById(R.id.relaltive);
        sign_up= findViewById(R.id.sign_up);
        login= findViewById(R.id.login);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        relaltive.startAnimation(animation);
        final SpannableStringBuilder sb = new SpannableStringBuilder("Don't have Account? Sign Up");

        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(bss, 20, 27, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor(LoginActivity.this,R.color.white));
               // ds.setUnderlineText(true);
            }
        };
        sb.setSpan(clickableSpan1, 20, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sign_up.setText(sb);
        sign_up.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }
}