package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.math.BigDecimal;

public class Calculator extends AppCompatActivity implements View.OnClickListener {
    TextView txtKetQua;
    MaterialButton btnC, btnAmDuong, btnPhamTram, btnChia, btn7,
            btn8, btn9, btnNhan, btn4, btn5, btn6, btnTru, btn1, btn2, btn3,
            btnCong, btn0, btnPhay, btnBang;

    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;
    private final static int IS_OPEN_PARENTHESIS = 2;
    private final static int IS_CLOSE_PARENTHESIS = 3;
    private final static int IS_DOT = 4;

    private boolean dotUsed = false;
    private int openParenthesis = 0;
    private String lastExpression = "";
    private String firstExpression = "";
    private String phepTinh = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtKetQua = findViewById(R.id.txtKetQuaCalculator);
        btnC = findViewById(R.id.btnCCalculator);
        btnAmDuong = findViewById(R.id.btnAmDuongCalculator);
        btnPhamTram = findViewById(R.id.btnPhanTramCalculator);
        btnChia = findViewById(R.id.btnChiaCalculator);
        btn7 = findViewById(R.id.btn7Calculator);
        btn8 = findViewById(R.id.btn8Calculator);
        btn9 = findViewById(R.id.btn9Calculator);
        btnNhan = findViewById(R.id.btnNhanCalculator);
        btn4 = findViewById(R.id.btn4Calculator);
        btn5 = findViewById(R.id.btn5Calculator);
        btn6 = findViewById(R.id.btn6Calculator);
        btnTru = findViewById(R.id.btnTruCalculator);
        btn1 = findViewById(R.id.btn1Calculator);
        btn2 = findViewById(R.id.btn2Calculator);
        btn3 = findViewById(R.id.btn3Calculator);
        btnCong = findViewById(R.id.btnCongCalculator);
        btn0 = findViewById(R.id.btn0Calculator);
        btnPhay = findViewById(R.id.btnPhayCalculator);
        btnBang = findViewById(R.id.btnBangCalculator);

        btnC.setOnClickListener(this);
        btnAmDuong.setOnClickListener(this);
        btnPhamTram.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPhay.setOnClickListener(this);
        btnBang.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCCalculator:
                txtKetQua.setText("");
                openParenthesis = 0;
                dotUsed = false;
                break;
            case R.id.btn0Calculator:
                addNumber("0");
                break;
            case R.id.btn1Calculator:
                addNumber("1");
                break;
            case R.id.btn2Calculator:
                addNumber("2");
                break;
            case R.id.btn3Calculator:
                addNumber("3");
                break;
            case R.id.btn4Calculator:
                addNumber("4");
                break;
            case R.id.btn5Calculator:
                addNumber("5");
                break;
            case R.id.btn6Calculator:
                addNumber("6");
                break;
            case R.id.btn7Calculator:
                addNumber("7");
                break;
            case R.id.btn8Calculator:
                addNumber("8");
                break;
            case R.id.btn9Calculator:
                addNumber("9");
                break;
            case R.id.btnCongCalculator:
                phepTinh = "+";
                addOperand("+");
                break;
            case R.id.btnTruCalculator:
                phepTinh = "-";
                addOperand("-");
                break;
            case R.id.btnNhanCalculator:
                phepTinh = "*";
                addOperand("x");
                break;
            case R.id.btnChiaCalculator:
                phepTinh = "/";
                addOperand("/");
                break;
            case R.id.btnBangCalculator:
                calculate();
                break;
        }
    }

    private boolean addNumber(String number) {
        boolean done = false;
        int operationLength = txtKetQua.getText().length();
        if (operationLength > 0) {
            String lastCharacter = txtKetQua.getText().charAt(operationLength - 1) + "";
            int lastCharacterState = defineLastCharacter(lastCharacter);

            if (operationLength == 1 && lastCharacterState == IS_NUMBER && lastCharacter.equals("0")) {
                txtKetQua.setText(number);
                done = true;
            } else if (lastCharacterState == IS_OPEN_PARENTHESIS) {
                txtKetQua.setText(txtKetQua.getText() + number);
                done = true;
            } else if (lastCharacterState == IS_CLOSE_PARENTHESIS || lastCharacter.equals("%")) {
                txtKetQua.setText(txtKetQua.getText() + "x" + number);
                done = true;
            } else if (lastCharacterState == IS_NUMBER || lastCharacterState == IS_OPERAND || lastCharacterState == IS_DOT) {
                txtKetQua.setText(txtKetQua.getText() + number);
                done = true;
            }
        } else {
            txtKetQua.setText(txtKetQua.getText() + number);
            done = true;
        }
        return done;
    }

    private int defineLastCharacter(String lastCharacter) {
        try {
            Integer.parseInt(lastCharacter);
            return IS_NUMBER;
        } catch (NumberFormatException e) {
        }

        if ((lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("x") || lastCharacter.equals("/") || lastCharacter.equals("%")))
            return IS_OPERAND;

        if (lastCharacter.equals("("))
            return IS_OPEN_PARENTHESIS;

        if (lastCharacter.equals(")"))
            return IS_CLOSE_PARENTHESIS;

        if (lastCharacter.equals("."))
            return IS_DOT;

        return -1;
    }

//    private boolean addDot() {
//        boolean done = false;
//
//        if (txtKetQua.getText().length() == 0) {
//            txtKetQua.setText("0.");
//            dotUsed = true;
//            done = true;
//        } else if (dotUsed == true) {
//        } else if (defineLastCharacter(txtKetQua.getText().charAt(txtKetQua.getText().length() - 1) + "") == IS_OPERAND) {
//            txtKetQua.setText(txtKetQua.getText() + "0.");
//            done = true;
//            dotUsed = true;
//        } else if (defineLastCharacter(txtKetQua.getText().charAt(txtKetQua.getText().length() - 1) + "") == IS_NUMBER) {
//            txtKetQua.setText(txtKetQua.getText() + ".");
//            done = true;
//            dotUsed = true;
//        }
//        return done;
//    }

    private boolean addOperand(String operand) {
        boolean done = false;
        int operationLength = txtKetQua.getText().length();
        if (operationLength > 0) {
            firstExpression = txtKetQua.getText().toString();
            txtKetQua.append(operand);
            dotUsed = false;
            lastExpression = "0";
            done = true;
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Format. Operand Without any numbers?", Toast.LENGTH_LONG).show();
        }
        return done;
    }

    private void calculate() {
        saveLastExpression(txtKetQua.getText().toString());
        int kq = 0;
        switch (phepTinh) {
            case "+":
                kq = Integer.parseInt(firstExpression) + Integer.parseInt(lastExpression);
                break;
            case "-":
                kq = Integer.parseInt(firstExpression) - Integer.parseInt(lastExpression);
                break;
            case "*":
                kq = Integer.parseInt(firstExpression) * Integer.parseInt(lastExpression);
                break;
            case "/":
                if (!lastExpression.equals("0")) {
                    float kq2 = (float) Integer.parseInt(firstExpression) / (float) Integer.parseInt(lastExpression);
                    txtKetQua.setText(kq2 + "");
                    firstExpression = "";
                    lastExpression = "";
                }
                return;

        }
        txtKetQua.setText(kq + "");
        firstExpression = "";
        lastExpression = "";
    }

    private void saveLastExpression(String input) {
        String lastOfExpression = input.charAt(input.length() - 1) + "";
        if (input.length() > 1) {
            if (defineLastCharacter(lastOfExpression + "") == IS_NUMBER) {
                lastExpression = txtKetQua.getText().toString().substring(firstExpression.length() + 1, txtKetQua.getText().length());
            }
        }
    }
}