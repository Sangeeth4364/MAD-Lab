package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Num1, Num2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditText and TextView
        Num1 = findViewById(R.id.Num1);
        Num2 = findViewById(R.id.Num2);
        textView = findViewById(R.id.textView);
    }

    public void Add(View view) {
        performCalculation('+');
    }

    public void Subtract(View view) {
        performCalculation('-');
    }

    public void Multiply(View view) {
        performCalculation('*');
    }

    public void Divide(View view) {
        performCalculation('/');
    }

    private void performCalculation(char operator) {
        // Get input values from EditText fields
        String num1Str = Num1.getText().toString();
        String num2Str = Num2.getText().toString();

        // Check if EditText fields are empty
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert input strings to numbers
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        double result = 0;

        // Perform calculation based on operator
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            default:
                break;
        }

        // Display the result in textView
        textView.setText("Result: " + result);
    }
}

