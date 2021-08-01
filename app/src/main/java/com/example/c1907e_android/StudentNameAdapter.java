package com.example.c1907e_android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.c1907e_android.Models.Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentNameAdapter extends BaseAdapter {
    private List<Student> studentList;
    private Activity activity;

    public StudentNameAdapter(List<Student> studentList, Activity activity) {
        this.studentList = studentList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        convertView = inflater.inflate(R.layout.layout_list_view_item, null);

        TextView txtTen = convertView.findViewById(R.id.txtLVTen);
        TextView txtNgaySinh = convertView.findViewById(R.id.txtLVNgaySinh);
        TextView txtLop = convertView.findViewById(R.id.txtLVLop);

        txtTen.append(studentList.get(position).getName());
        txtLop.append(studentList.get(position).getLearningClass());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        txtNgaySinh.append(simpleDateFormat.format(studentList.get(position).getBirthday()));

        return convertView;
    }
}
