package com.example.javacalculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView workingView;
    String inputValue = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCalculator();
    }

    private void createCalculator() {
        workingView = (TextView) findViewById(R.id.workAreaTextView);
    }

    private void setInputValue(String value) {
        inputValue = inputValue + value;
        workingView.setText(inputValue);
    }

    public void handleClear(View view) {
        if (Objects.requireNonNull(inputValue).length() > 0) {
            inputValue = inputValue.substring(0, inputValue.length() - 1);
            workingView.setText(inputValue);
        }
    }
    public void handleClearAll(View view) {
        inputValue = "";
        workingView.setText(inputValue);
    }

    private void getResult() {

    }

    public void handleAdd(View view) {
        setInputValue("+");
    }

    public void handleMinus(View view) {
        setInputValue("-");
    }

    public void handleDivide(View view) {
        setInputValue("/");
    }

    public void handleMultiply(View view) {
        setInputValue("*");
    }

    public void handleOne(View view) {
        setInputValue("1");
    }

    public void handleTwo(View view) {
        setInputValue("2");
    }

    public void handleThree(View view) {
        setInputValue("3");
    }

    public void handleFour(View view) {
        setInputValue("4");
    }

    public void handleFive(View view) {
        setInputValue("5");
    }

    public void handleSix(View view) {
        setInputValue("6");
    }

    public void handleSeven(View view) {
        setInputValue("7");
    }

    public void handleEight(View view) {
        setInputValue("8");
    }

    public void handleNine(View view) {
        setInputValue("9");
    }

    public void handleZero(View view) {
        setInputValue("0");
    }
}