package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        final Intent i = new Intent(splashActivity.this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            ImageView icon = findViewById(R.id.icon);
            @Override
            public void run() {
                startActivity(i);
                finish();
            }
        },10000);
    }
}