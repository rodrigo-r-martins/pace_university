package com.example.eurotodollarconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etEuros;
    private TextView tvResult;
    private final double EURO_DOLLAR_RATE = 1.13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEuros = findViewById(R.id.etEuros);
        tvResult = findViewById(R.id.tvResult);
    }

    public void convertEuro(View view) {
        String euroAmount = etEuros.getText().toString();

        if (euroAmount.isEmpty()) {
            // If euros field is empty show error
            Log.d("MAIN_ACTIVITY", "Input field is empty");
            etEuros.setError("Please enter the euros amount");
        } else {
            double euros = Double.parseDouble(etEuros.getText().toString());
            double dollars = euros * EURO_DOLLAR_RATE;
            Log.d("MAIN_ACTIVITY", "Result = " + dollars);
            tvResult.setText(new StringBuilder().append("$")
                                                .append(dollars).toString());
        }
    }
}