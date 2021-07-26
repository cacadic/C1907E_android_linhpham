package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.e("Trạng Thái", "onCreate");

        Button btnNextFromLife = findViewById(R.id.btnNextFromLife);

        btnNextFromLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e("Trạng Thái", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("Trạng Thái", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e("Trạng Thái", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e("Trạng Thái", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e("Trạng Thái", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e("Trạng Thái", "onRestart");
    }
}