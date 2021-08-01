package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckIPActivity extends AppCompatActivity {
    TextView txtIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ipactivity);

        txtIP = findViewById(R.id.txtIPCuaToi);

        new AsyncCheckIP(CheckIPActivity.this, txtIP).execute();

    }
}