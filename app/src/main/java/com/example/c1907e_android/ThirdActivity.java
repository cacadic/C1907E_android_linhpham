package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundle = getIntent().getExtras();
        int activity = bundle.getInt("activity");

        TextView txtThird = findViewById(R.id.txtThird);
        txtThird.append(activity + "");

        Button btnBackFromThird = findViewById(R.id.btnBackFromThird);

        btnBackFromThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                bundle.putInt("activity", activity - 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}