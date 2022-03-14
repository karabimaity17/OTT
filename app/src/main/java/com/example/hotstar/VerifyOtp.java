package com.example.hotstar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class VerifyOtp extends AppCompatActivity {
    TextView resend,verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        resend= findViewById(R.id.resend);
        verify= findViewById(R.id.verify);

        final SpannableStringBuilder sb = new SpannableStringBuilder("Didn't get OTP? Resend OTP");

        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(bss, 16, 26, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

//                startActivity(new Intent(VerifyOtp.this,LoginActivity.class));
//                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                finish();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor(VerifyOtp.this,R.color.white));
                // ds.setUnderlineText(true);
            }
        };
        sb.setSpan(clickableSpan1, 16, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        resend.setText(sb);
        resend.setMovementMethod(LinkMovementMethod.getInstance());

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerifyOtp.this,ChooseLanguage.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            startActivity(new Intent(VerifyOtp.this, RegisterActivity.class));
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        startActivity(new Intent(VerifyOtp.this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
        finish();

    }
}