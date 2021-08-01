package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.c1907e_android.Models.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.lvAct);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Lĩnh Phạm", "1", new Date(1992,01,15)));
        studentList.add(new Student("Tân Tân", "2", new Date(1996,02,25)));
        studentList.add(new Student("Huy Huy", "3", new Date(1993,03,4)));
        studentList.add(new Student("Thanh Thanh", "4", new Date(1995,06,1)));
        studentList.add(new Student("Tùng Tùng", "5", new Date(1999,01,1)));
        studentList.add(new Student("Quang Quang", "6", new Date(1994,11,22)));

        StudentNameAdapter studentNameAdapter = new StudentNameAdapter(studentList, this);

        listView.setAdapter(studentNameAdapter);
    }
}