package com.example.c1907e_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SavedInstanceState extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtConfirmPassword;
    Button btnRegister;
    TextView txtComparePassword;
    String kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_instance_state);

        edtUsername = findViewById(R.id.edtUsernameSaveInst);
        edtPassword = findViewById(R.id.edtPasswordSaveInst);
        edtConfirmPassword = findViewById(R.id.edtConfirmPasswordSaveInst);
        btnRegister = findViewById(R.id.btnRegisterSaveInst);
        txtComparePassword = findViewById(R.id.txtComparePasswordSaveInst);

        if(savedInstanceState != null){
            kq = savedInstanceState.getString("kq");
            txtComparePassword.setText(kq);
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())) {
                    kq = "Password is match";
                } else {
                    kq = "Password is mismatch";
                }

                txtComparePassword.setText(kq);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull @org.jetbrains.annotations.NotNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("kq", kq);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}