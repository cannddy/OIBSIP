package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output;
    Spinner fromUnit, toUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.et_input);
        output = findViewById(R.id.tv_result);
        fromUnit = findViewById(R.id.sp_from_unit);
        toUnit = findViewById(R.id.sp_to_unit);
    }

    public void convert(View view) {
        String from = fromUnit.getSelectedItem().toString();
        String to = toUnit.getSelectedItem().toString();
        double inputValue = Double.parseDouble(input.getText().toString());
        double result = 0;

        switch (from) {
            case "Centimeters":
                switch (to) {
                    case "Meters":
                        result = inputValue / 100;
                        break;
                    case "Inches":
                        result = inputValue / 2.54;
                        break;
                }
                break;
            case "Meters":
                switch (to) {
                    case "Centimeters":
                        result = inputValue * 100;
                        break;
                    case "Inches":
                        result = inputValue * 39.37;
                        break;
                }
                break;
            case "Inches":
                switch (to) {
                    case "Centimeters":
                        result = inputValue * 2.54;
                        break;
                    case "Meters":
                        result = inputValue / 39.37;
                        break;
                }
                break;
            case "Grams":
                switch (to) {
                    case "Kilograms":
                        result = inputValue / 1000;
                        break;
                    case "Pounds":
                        result = inputValue / 453.592;
                        break;
                }
                break;
            case "Kilograms":
                switch (to) {
                    case "Grams":
                        result = inputValue * 1000;
                        break;
                    case "Pounds":
                        result = inputValue * 2.205;
                        break;
                }
                break;
            case "Pounds":
                switch (to) {
                    case "Grams":
                        result = inputValue * 453.592;
                        break;
                    case "Kilograms":
                        result = inputValue / 2.205;
                        break;
                }
                break;
        }

        output.setText(String.format("%.2f %s",result,to));
    }
}
