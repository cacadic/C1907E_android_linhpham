package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c1907e_android.Models.UserWithImage;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        String[] students = {"Lĩnh Phạm", "Công Công", "Lượng Lượng", "Hinh Hinh", "Tùng Tùng", "Tân Tân"};
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<UserWithImage> userWithImageList = new ArrayList<>();
        userWithImageList.add(new UserWithImage("Lĩnh Phạm", "https://i.picsum.photos/id/77/200/200.jpg?hmac=RaFJkrixMn3dR7INSPWcmjC7HCxmggmF5mTlMpyEHsQ"));
        userWithImageList.add(new UserWithImage("Công Công", "https://i.picsum.photos/id/1074/200/200.jpg?hmac=o1fm0jR_nE4yW-N80QpSF9JfnnRYhRraqaTaTbCGe1c"));
        userWithImageList.add(new UserWithImage("Lượng Lượng", "https://image.thanhnien.vn/1024/uploaded/thanhlongn/2021_07_17/ngoctrinh_gejd.jpg"));
        userWithImageList.add(new UserWithImage("Tân Tân", "https://i.picsum.photos/id/110/200/200.jpg?hmac=aekmsQTsPRt4hCd1khMC5QVihAaBeTigUCpcDBzhXlY"));
        userWithImageList.add(new UserWithImage("Tùng Tùng", "https://i.picsum.photos/id/186/200/200.jpg?hmac=bNtKzMZT8HFzZq8mbTSWaQvmkX8T7TE47fspKMfxVl8"));

        RecyclerDataAdapter recyclerDataAdapter = new RecyclerDataAdapter(this, userWithImageList);

        recyclerView.setAdapter(recyclerDataAdapter);
    }
}