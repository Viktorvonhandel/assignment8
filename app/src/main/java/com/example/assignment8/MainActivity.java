package com.example.assignment8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editFirstNumber, editSecondNumber;
    Button plusButton, minusButton, multiplyButton, divideButton;
    TextView textSeeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirstNumber = findViewById(R.id.editFirstNumber);
        editSecondNumber = findViewById(R.id.editSecondNumber);
        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        textSeeResult = findViewById(R.id.textSeeResult);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operation) {
        try {
            int num1 = Integer.parseInt(editFirstNumber.getText().toString());
            int num2 = Integer.parseInt(editSecondNumber.getText().toString());
            int result = 0;

            switch (operation) {
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
                        textSeeResult.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            textSeeResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            textSeeResult.setText("Invalid input");
        }
    }
}
