package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String unit1 = ""; //this is defined as a global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner unitSelector_spinner = findViewById(R.id.unitSelector_spinner);
        Spinner unit1_spinner = findViewById(R.id.unit1_spinner);
        Spinner unit2_spinner = findViewById(R.id.unit2_spinner);
        EditText unit1_edtText = findViewById(R.id.unit1_editText);
        TextView answers_txtView = findViewById(R.id.answer_textView);
        Button reset_button = findViewById(R.id.reset_button);

        String[] units = {"None", "Celsius", "Fahrenheit", "Kelvin"};
        String[] types = {"Temperature", "Currency"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSelector_spinner.setAdapter(adapter);

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, units);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit1_spinner.setAdapter(adapter1);

        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, units);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit2_spinner.setAdapter(adapter2);

        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);

        unit1_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            unit1 = unit1_spinner.getItemAtPosition(i).toString();
            convertMethod(unit1); //this function is used to send the selected item of spinner 1 to spinner 2
            }

            private void convertMethod(String unit1) {

                unit2_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            String unit2 = unit2_spinner.getItemAtPosition(i).toString();
                            String num = "0"+unit1_edtText.getText().toString(); // String zero added to each edit_text number to prevent app from crashing when user gives null input
                            double number = Double.valueOf(num); //.toString functions not usable


                            if(unit1.equalsIgnoreCase("Celsius") && unit2.equalsIgnoreCase("Celsius")){
                                answers_txtView.setText(num);
                            }
                            if(unit1.equalsIgnoreCase("Celsius") && unit2.equalsIgnoreCase("Fahrenheit")){
                            double answer = (number * 1.8) + 32.0;
                            answers_txtView.setText(String.valueOf(answer));
                            }
                            if(unit1.equalsIgnoreCase("Celsius") && unit2.equalsIgnoreCase("Kelvin")){
                            double answer = (number +273.0);
                            answers_txtView.setText(String.valueOf(answer));
                            }

                            if(unit1.equalsIgnoreCase("Fahrenheit") && unit2.equalsIgnoreCase("Celsius")){
                            double answer = (number - 32.0)*0.56;
                            answers_txtView.setText(String.valueOf(answer));
                            }
                            if(unit1.equalsIgnoreCase("Fahrenheit") && unit2.equalsIgnoreCase("Fahrenheit")){
                            answers_txtView.setText(num);
                            }
                            if(unit1.equalsIgnoreCase("Fahrenheit") && unit2.equalsIgnoreCase("Kelvin")){
                            double answer = ((number - 32.0)*0.56) + 273.0;
                            answers_txtView.setText(String.valueOf(answer));
                            }

                            if(unit1.equalsIgnoreCase("Kelvin") && unit2.equalsIgnoreCase("Celsius")){
                            double answer = (number - 273);
                            answers_txtView.setText(String.valueOf(answer));
                            }
                            if(unit1.equalsIgnoreCase("Kelvin") && unit2.equalsIgnoreCase("Fahrenheit")){
                            double answer = ((number - 273)*1.8)+32;
                            answers_txtView.setText(String.valueOf(answer));
                            }
                            if(unit1.equalsIgnoreCase("Kelvin") && unit2.equalsIgnoreCase("Kelvin")){
                            answers_txtView.setText(num);
                            }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        //useless block, but do not delete
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //useless block, but do not delete
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.vibrate(80);

                unit1_edtText.setText("0");
                answers_txtView.setText("Answer");
                unit1_spinner.setSelection(0);
                unit2_spinner.setSelection(0);
                unitSelector_spinner.setSelection(0);
            }
        });

        unitSelector_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if(i == 1){
                   Intent intent = new Intent(MainActivity.this, Currency_conversion.class);
                   startActivity(intent);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //useless block, but do not delete
            }
        });

    }


}