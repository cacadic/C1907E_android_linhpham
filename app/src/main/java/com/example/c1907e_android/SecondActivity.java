package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URI;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        String[] info = bundle.getStringArray("info");
        int activity = bundle.getInt("activity");

        TextView txtSecond = findViewById(R.id.txtSecond);
        txtSecond.append(activity + "");

        TextView txtUserName = findViewById(R.id.txtUserName);
        txtUserName.append(info[0]);

        TextView txtAge = findViewById(R.id.txtAge);
        txtAge.append(info[1]);

        TextView txtSchool = findViewById(R.id.txtSchool);
        txtSchool.append(info[2]);

        TextView txtCompany = findViewById(R.id.txtCompany);
        txtCompany.append(info[3]);

        Button btnBack = findViewById(R.id.btnBackFromSecond);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnOpenLink2 = findViewById(R.id.btnOpenLink2);
        btnOpenLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(intent);
            }
        });

        Button btnNextFromSecond = findViewById(R.id.btnNextFromSecond);
        btnNextFromSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                bundle.putInt("activity", activity + 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}