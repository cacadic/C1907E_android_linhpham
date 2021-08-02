package com.example.c1907e_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.c1907e_android.Models.UserGitHub;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecyclerGitHubUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_git_hub_user);

        final RecyclerView rvUserGitHub = findViewById(R.id.rvGitHubUser);

        LinearLayoutManager layoutManager = new LinearLayoutManager(RecyclerGitHubUserActivity.this, LinearLayoutManager.VERTICAL, false);
        rvUserGitHub.setLayoutManager(layoutManager);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/users")
                .build();

        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, UserGitHub.class);
        final JsonAdapter<List<UserGitHub>> jsonAdapter = moshi.adapter(type);

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("kiemtra", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String bodyRes = Objects.requireNonNull(response.body()).string();
                final List<UserGitHub> userGitHubList = jsonAdapter.fromJson(bodyRes);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        rvUserGitHub.setAdapter(new RecycleGitHubUserAdapter(userGitHubList, RecyclerGitHubUserActivity.this));
                    }
                });

            }
        });
    }
}