package com.arshshaikh.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MAIN_ACTIVITY";
    private TextView tvCalcScreen;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAddition, btnSubtraction, btnMultiplication, btnDivision, btnEquals;
    private Button btnDecimalPoint, btnPower, btnClearAll, btnBackSpace, btnPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnZero.setOnClickListener(view -> tvCalcScreen.append("0"));
        btnOne.setOnClickListener(view -> tvCalcScreen.append("1"));
        btnTwo.setOnClickListener(view -> tvCalcScreen.append("2"));
        btnThree.setOnClickListener(view -> tvCalcScreen.append("3"));
        btnFour.setOnClickListener(view -> tvCalcScreen.append("4"));
        btnFive.setOnClickListener(view -> tvCalcScreen.append("5"));
        btnSix.setOnClickListener(view -> tvCalcScreen.append("6"));
        btnSeven.setOnClickListener(view -> tvCalcScreen.append("7"));
        btnEight.setOnClickListener(view -> tvCalcScreen.append("8"));
        btnNine.setOnClickListener(view -> tvCalcScreen.append("9"));
        btnDecimalPoint.setOnClickListener(view -> tvCalcScreen.append("."));
        btnAddition.setOnClickListener(view -> {
            calc();
            checkOperator('+');
        });
        btnSubtraction.setOnClickListener(view -> {
            calc();
            checkOperator('-');
        });
        btnMultiplication.setOnClickListener(view -> {
            calc();
            checkOperator('*');
        });
        btnDivision.setOnClickListener(view -> {
            calc();
            checkOperator('/');
        });
        btnPower.setOnClickListener(view -> {
            calc();
            checkOperator('^');
        });
        btnPercentage.setOnClickListener(view -> {
            calc();
            checkOperator('%');
        });
        btnBackSpace.setOnClickListener(view -> {
            String value = tvCalcScreen.getText().toString();
            if (value.length() > 0) {
                tvCalcScreen.setText(value.substring(0, value.length() - 1));
            }
        });
        btnClearAll.setOnClickListener(view -> tvCalcScreen.setText(""));
        btnEquals.setOnClickListener(view -> calc());
    }

    private void checkOperator(char op) {
        String value = tvCalcScreen.getText().toString();
        int len = value.length();
        if (len == 0) {
            if (op == '-') tvCalcScreen.append("" + op);
            return;
        }

        char lastChar = value.charAt(len - 1);
        if (isOperator(lastChar)) {
            if (lastChar == op) return;
            else tvCalcScreen.append("" + op);

        } else tvCalcScreen.append("" + op);


    }

    private boolean isOperator(char op) {
        if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%' || op == '^') return true;
        return false;
    }

    private void calc() {
        String res = "";
        String ip = tvCalcScreen.getText().toString();
        if (ip.split("\\*").length == 2) {
            String[] nums = ip.split("\\*");


            try {
                double product = Double.parseDouble(nums[0]) * Double.parseDouble(nums[1]);
                res += product;
            } catch (Exception e) {
                Log.e(TAG, "calc: " + e);
            }
        } else if (ip.split("/").length == 2) {
            String[] nums = ip.split("/");

            try {
                double division = Double.parseDouble(nums[0]) / Double.parseDouble(nums[1]);
                res += division;
            } catch (Exception e) {
                Log.e(TAG, "calc: " + e);
            }
        } else if (ip.split("\\^").length == 2) {
            String[] nums = ip.split("\\^");

            try {
                double power = Math.pow(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
                res += power;
            } catch (Exception e) {
                Log.e(TAG, "calc: " + e);
            }
        } else if (ip.split("\\+").length == 2) {
            String[] nums = ip.split("\\+");

            try {
                double addition = Double.parseDouble(nums[0]) + Double.parseDouble(nums[1]);
                res += addition;
            } catch (Exception e) {
                Log.e(TAG, "calc: " + e);
            }
        } else if (ip.split("-").length > 1) {
            String[] nums = ip.split("-");
            if (nums[0].equals("") && nums.length == 2) nums[0] = 0 + "";

            try {
                double subtraction = 0;
                if (nums.length == 2)
                    subtraction = Double.parseDouble(nums[0]) - Double.parseDouble(nums[1]);
                else if (nums.length == 3)
                    subtraction = -Double.parseDouble(nums[1]) - Double.parseDouble(nums[2]);
                res += subtraction;
            } catch (Exception e) {
                Log.e(TAG, "calc: " + e);
            }
        } else if (ip.split("%").length == 2) {
            String[] nums = ip.split("%");

            try {
                double percentage = Double.parseDouble(nums[0]) * Double.parseDouble(nums[1]) / 100;
                res += percentage;
            } catch (Exception e) {
                Log.e(TAG, "calc: " + e);
            }
        }

        String[] check = res.split("\\.");
        if (check.length > 1 && check[1].equals("0")) {
            res = check[0];
        }

        if (res.equals("")) return;
        tvCalcScreen.setText(res);
    }

    private void init() {
        // TextViews
        tvCalcScreen = findViewById(R.id.tvCalcScreen);

        // Buttons
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnAddition = findViewById(R.id.btnAddition);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnDivision = findViewById(R.id.btnDivision);
        btnEquals = findViewById(R.id.btnEquals);
        btnDecimalPoint = findViewById(R.id.btnDecimalPoint);
        btnPower = findViewById(R.id.btnPower);
        btnClearAll = findViewById(R.id.btnClearAll);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnPercentage = findViewById(R.id.btnPercentage);
    }
}