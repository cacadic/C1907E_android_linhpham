package com.example.c1907e_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class SimpleCalculator extends AppCompatActivity {

    EditText edtFirstNumber, edtSecondNumber;
    TextView txtPhepTinh, txtKetQua;
    Button btnCong, btnTru, btnNhan, btnChia, btnBang;
    String phepTinh = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

        edtFirstNumber = findViewById(R.id.edtFirstNumberSimple);
        edtSecondNumber = findViewById(R.id.edtSecondNumberSimple);
        txtPhepTinh = findViewById(R.id.txtPhepTinhSimple);
        txtKetQua = findViewById(R.id.txtKetQuaSimple);
        btnCong = findViewById(R.id.btnCongSimple);
        btnTru = findViewById(R.id.btnTruSimple);
        btnNhan = findViewById(R.id.btnNhanSimple);
        btnChia = findViewById(R.id.btnChiaSimple);
        btnBang = findViewById(R.id.btnBangSimple);

        if(savedInstanceState != null){
            txtKetQua.setText(savedInstanceState.getString("kq"));
        }

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phepTinh = "+";
                txtPhepTinh.setText(phepTinh);
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phepTinh = "-";
                txtPhepTinh.setText(phepTinh);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phepTinh = "*";
                txtPhepTinh.setText("x");
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phepTinh = "/";
                txtPhepTinh.setText(phepTinh);
            }
        });

        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtFirstNumber.getText().toString().length() == 0 || edtSecondNumber.getText().toString().length() == 0){
                    txtKetQua.setText("Please input 2 number");
                } else {
                    int firstNumber = Integer.parseInt(edtFirstNumber.getText().toString());
                    int secondNumber = Integer.parseInt(edtSecondNumber.getText().toString());
                    int kq = 0;

                    switch (phepTinh) {
                        case  "-":
                            kq = firstNumber - secondNumber;
                            break;
                        case "*":
                            kq = firstNumber * secondNumber;
                            break;
                        case "/":
                            if(secondNumber != 0){
                                float kq2 = (float) firstNumber/ (float) secondNumber;
                                txtKetQua.setText(kq2 + "");
                            } else {
                                txtKetQua.setText("Second number must not be 0");
                            }
                            return;
                        default:
                            kq = firstNumber + secondNumber;
                            break;
                    }

                    txtKetQua.setText(kq + "");
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull @NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("kq", txtKetQua.getText().toString());
    }
}