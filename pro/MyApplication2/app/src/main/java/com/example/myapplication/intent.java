package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class intent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Button b1;
        Button b2;
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://classroom.google.com/c/NDMyMzM2Nzk3NTYx/p/NDMzNTY2MzcyMDk3/details"));
                startActivity(intent);
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.lamloum.net/taj/calclastratio.php"));
                startActivity(intent1);
            }
        });
    }
}