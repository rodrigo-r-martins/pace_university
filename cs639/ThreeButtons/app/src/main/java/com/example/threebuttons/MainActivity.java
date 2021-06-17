package com.example.threebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button zeroBtn;
    private Button countBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView)findViewById(R.id.show_count);
        zeroBtn = findViewById(R.id.button_zero);
        countBtn = findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            zeroBtn.setBackgroundColor(Color.RED);
            if (mCount % 2 == 1) {
                countBtn.setBackgroundColor(Color.GREEN);
            } else {
                countBtn.setBackgroundColor(Color.BLUE);
            }
        }
    }

    public void zeroCounter(View view) {
        mShowCount.setText("0");
        mCount = 0;
        zeroBtn.setBackgroundColor(Color.GRAY);
        countBtn.setBackgroundColor(Color.BLACK);
    }
}