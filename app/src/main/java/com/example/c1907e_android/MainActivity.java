package com.example.c1907e_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        int activity = 1;
        Bundle bundle = new Bundle();
        bundle.putStringArray("info", new String[]{"Linh Pham", "29", "FPT", "Blue Bottle"});
        bundle.putInt("activity", 1);

        TextView txtFirst = findViewById(R.id.txtFirst);
        txtFirst.append(bundle.getInt("activity") + "");

        Button btnNext = findViewById(R.id.btnNextFromFirst);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                bundle.putInt("activity", activity + 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Button btnOpenLink = findViewById(R.id.btnOpenLink);

        btnOpenLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kenh14.vn"));
                startActivity(intent);
            }
        });


    }
}
