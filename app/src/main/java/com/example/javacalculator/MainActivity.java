package com.example.javacalculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView workingView;
    String screenValue = "";
    String inputValue = "";
    String operator = "";
    double numberOne;
    double numberTwo;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCalculator();
    }

    private void createCalculator() {
        workingView = (TextView) findViewById(R.id.workAreaTextView);
    }

    private boolean hasOperator (String value) {
        return Objects.equals(value, "+") || Objects.equals(value, "-") || Objects.equals(value, "/") || Objects.equals(value, "*");
    }

    private void setInputValue(String value) {

        if (hasOperator(value)) {
            inputValue = inputValue + "s" + value + "s";
        } else {
            inputValue = inputValue + value;
        }
    }

    private void setScreenValue(String value) {
        setInputValue(value);
        screenValue = screenValue + value;
        workingView.setText(screenValue);
    }

    public void handleClear(View view) {
        if (Objects.requireNonNull(screenValue).length() > 0) {
            screenValue = screenValue.substring(0, screenValue.length() - 1);
            workingView.setText(screenValue);

            if (String.valueOf(inputValue.charAt(inputValue.length() - 1)).equals("s")) {
                inputValue = inputValue.substring(0, inputValue.length() - 2);
            } else {
                inputValue = inputValue.substring(0, inputValue.length() - 1);
            }
        }
    }
    public void handleClearAll(View view) {
        screenValue = "";
        inputValue = "";
        workingView.setText(screenValue);
    }

    public void handleResult(View view) {
        getResult(inputValue.split("s"));
        screenValue = String.valueOf(result);
        workingView.setText(screenValue);
    }

    private void getResult(String[] operation){
        int iterator = 0;
        result = Double.parseDouble(operation[iterator]);

        while (iterator < operation.length - 1){
            int val1 = iterator + 1;
            int val2 = iterator + 2;

            numberOne = result;
            operator = operation[val1];
            numberTwo = Double.parseDouble(operation[val2]);
            getOperation();
            iterator = iterator + 2;
        }
    }

    @SuppressLint("SetTextI18n")
    private void getOperation() {

        switch (operator){
            case "+": {
                result = numberOne + numberTwo;
                break;
            }
            case "-": {
                result = numberOne - numberTwo;
                break;
            }
            case "*": {
                result = numberOne * numberTwo;
                break;
            }
            case "/": {
                if (numberTwo == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                    inputValue = "";
                    screenValue = "";
                } else {
                    result = numberOne / numberTwo;
                }
            }
            default:
                break;
        }
    }

    public void handleAdd(View view) {
        setScreenValue("+");
    }

    public void handleMinus(View view) {
        setScreenValue("-");
    }

    public void handleDivide(View view) {
        setScreenValue("/");
    }

    public void handleMultiply(View view) {
        setScreenValue("*");
    }

    public void handleOne(View view) {
        setScreenValue("1");
    }

    public void handleTwo(View view) {
        setScreenValue("2");
    }

    public void handleThree(View view) {
        setScreenValue("3");
    }

    public void handleFour(View view) {
        setScreenValue("4");
    }

    public void handleFive(View view) {
        setScreenValue("5");
    }

    public void handleSix(View view) {
        setScreenValue("6");
    }

    public void handleSeven(View view) {
        setScreenValue("7");
    }

    public void handleEight(View view) {
        setScreenValue("8");
    }

    public void handleNine(View view) {
        setScreenValue("9");
    }

    public void handleZero(View view) {
        setScreenValue("0");
    }
}