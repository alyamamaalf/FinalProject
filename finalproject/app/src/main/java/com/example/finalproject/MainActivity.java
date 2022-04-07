package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  {
    private TextInputEditText userNameEdt, pwdEdt;
    private Button getStarted;
    private TextView Register;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R. Layout.activity_login);
        getStarted= findviewById (R.id.getStarted);
         = findViewById(R.id.id);
        LoginBtn = findviewById(R.id.);
        LoadingPB = findviewById(R.id.);
        Register = findViewById(R.id.Register);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }





        }




