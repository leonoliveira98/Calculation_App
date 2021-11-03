package com.example.calculationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        buttonClick();
    }

    private void findViews() {

        // Ir buscar os Id's do XML e mete-los em variáveis
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);

    }

    private void buttonClick(){
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesText = inchesEditText.getText().toString();
                if(inchesText.isEmpty()){
                    Toast.makeText(MainActivity.this, "Insert a valid value.", Toast.LENGTH_SHORT).show();

                } else {
                    String meters = convertToMeters();
                    displayResult(meters);
                }


            }
        });
    }

    private String convertToMeters(){

        String inchesText = inchesEditText.getText().toString();

        int inches = Integer.parseInt(inchesText);

        return String.valueOf(inches / 39.37);

    }

    private void displayResult(String meters){
        Double metersD = Double.parseDouble(meters);

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String metersResult = myDecimalFormatter.format(metersD);

        resultText.setText("In meters it is: " + metersResult);

    }

}