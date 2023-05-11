package com.example.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;

public class MainActivity extends AppCompatActivity {

    TextView timeView;
    Button startButton, pauseButton, resetButton;
    long startTime = 0L, timeInMilliseconds = 0L, timeSwapBuff = 0L, updateTime = 0L;

    Runnable updateTimeRunnable = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updateTime = timeSwapBuff + timeInMilliseconds;
            int seconds = (int) (updateTime / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            int milliseconds = (int) (updateTime % 1000);
            timeView.setText("" + minutes + ":" + String.format("%02d", seconds) + ":" + String.format("%03d", milliseconds));
            handler.postDelayed(this, 0);
        }
    };

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeView = findViewById(R.id.tv_stopwatch);
        startButton = findViewById(R.id.btn_start);
        pauseButton = findViewById(R.id.btn_pause);
        resetButton = findViewById(R.id.btn_reset);

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(updateTimeRunnable, 0);
                resetButton.setEnabled(false);
                startButton.setEnabled(false);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                timeSwapBuff += timeInMilliseconds;
                handler.removeCallbacks(updateTimeRunnable);
                resetButton.setEnabled(true);
                startButton.setEnabled(true);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startTime = 0L;
                timeInMilliseconds = 0L;
                timeSwapBuff = 0L;
                updateTime = 0L;
                timeView.setText("0:00:000");
                resetButton.setEnabled(false);

            }
        });
    }
}
