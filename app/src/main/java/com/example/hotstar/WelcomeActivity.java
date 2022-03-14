package com.example.hotstar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
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
import android.webkit.WebView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView login,sign_up,fb_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login= findViewById(R.id.login);
        sign_up= findViewById(R.id.sign_up);
        fb_login= findViewById(R.id.fb_login);
        final SpannableStringBuilder sb = new SpannableStringBuilder("Already have Account? Login");

        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(bss, 22, 27, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor(WelcomeActivity.this,R.color.white));
                // ds.setUnderlineText(true);
            }
        };
        sb.setSpan(clickableSpan1, 22, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        login.setText(sb);
        login.setMovementMethod(LinkMovementMethod.getInstance());

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,RegisterActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        fb_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }
}