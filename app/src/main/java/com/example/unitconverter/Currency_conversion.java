package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Currency_conversion extends AppCompatActivity {

    String input_currency = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curreny_conversion);

        final Vibrator vibe = (Vibrator) Currency_conversion.this.getSystemService(Context.VIBRATOR_SERVICE);

        Spinner currency_spinner = findViewById(R.id.currency_spinner);
        EditText currency_edtText = findViewById(R.id.currency_editText);
        Button RESET_button = findViewById(R.id.RESET_button);
        Button back_button =  findViewById(R.id.back_button);
        TextView value_txtView = findViewById(R.id.value_textView);

        String[] currency_types = {"None", "USD", "CAD", "AUD", "GBP", "EUR"};

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, currency_types);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency_spinner.setAdapter(adapter1);

        RequestQueue queue = Volley.newRequestQueue(this);

        String USD = "https://free.currconv.com/api/v7/convert?q=USD_INR&compact=ultra&apiKey=bbf194afb268a4a99d85";
        String CAD = "https://free.currconv.com/api/v7/convert?q=CAD_INR&compact=ultra&apiKey=bbf194afb268a4a99d85";
        String AUD = "https://free.currconv.com/api/v7/convert?q=AUD_INR&compact=ultra&apiKey=bbf194afb268a4a99d85";
        String GBP = "https://free.currconv.com/api/v7/convert?q=GBP_INR&compact=ultra&apiKey=bbf194afb268a4a99d85";
        String EUR = "https://free.currconv.com/api/v7/convert?q=EUR_INR&compact=ultra&apiKey=bbf194afb268a4a99d85";

        currency_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                input_currency = "0"+currency_edtText.getText().toString();
                Double num = Double.valueOf(input_currency);
                if(i == 1){
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, USD, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String val = response.getString("USD_INR");
                                double val_num = (Double.valueOf(val))*100.0;
                                double val_num_round = (Math.round((val_num)))/100.0;
                                double answer = val_num_round * num;
                                value_txtView.setText(String.valueOf(answer));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("error", "error has occurred USD");
                        }
                    });
                    queue.add(jsonObjectRequest);
                }
                if(i == 2){
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, CAD, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String val = response.getString("CAD_INR");
                                double val_num = (Double.valueOf(val))*100.0;
                                double val_num_round = (Math.round((val_num)))/100.0;
                                double answer = val_num_round * num;
                                value_txtView.setText(String.valueOf(answer));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("error", "error has occurred USD");
                        }
                    });
                    queue.add(jsonObjectRequest);
                }
                if(i == 3){
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, AUD, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String val = response.getString("AUD_INR");
                                double val_num = (Double.valueOf(val))*100.0;
                                double val_num_round = (Math.round((val_num)))/100.0;
                                double answer = val_num_round * num;
                                value_txtView.setText(String.valueOf(answer));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("error", "error has occurred USD");
                        }
                    });
                    queue.add(jsonObjectRequest);
                }
                if(i == 4){
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, GBP, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String val = response.getString("GBP_INR");
                                double val_num = (Double.valueOf(val))*100.0;
                                double val_num_round = (Math.round((val_num)))/100.0;
                                double answer = val_num_round * num;
                                value_txtView.setText(String.valueOf(answer));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("error", "error has occurred USD");
                        }
                    });
                    queue.add(jsonObjectRequest);
                }
                if(i == 5){
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, EUR, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String val = response.getString("EUR_INR");
                                double val_num = (Double.valueOf(val))*100.0;
                                double val_num_round = (Math.round((val_num)))/100.0;
                                double answer = val_num_round * num;
                                value_txtView.setText(String.valueOf(answer));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("error", "error has occurred USD");
                        }
                    });
                    queue.add(jsonObjectRequest);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //useless block, but do not delete
            }
        });

        RESET_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vibe.vibrate(80);

                currency_edtText.setText("0");
                currency_spinner.setSelection(0);
                value_txtView.setText("Answer");
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.vibrate(100);
                Intent intent = new Intent(Currency_conversion.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}