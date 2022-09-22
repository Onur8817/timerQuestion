package com.onurkarahan.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView timeText, scoreText;
    TextView numberText;
    EditText number;
    CountDownTimer countDownTimer, countDownTimer2;
    Boolean check = false;
    int x;
    Integer score = 0;
    int oneTouch = 0;
    Boolean checkButton  = true;
    int error = 0;
    boolean stopTime;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreText = findViewById(R.id.scoreText);
        button = findViewById(R.id.button);
        timeText = findViewById(R.id.timeText);
        numberText = findViewById(R.id.numberText);
        number = findViewById(R.id.number);

        randomTimer();


    }

    public void calculate(View view) {


        if (number.getText().toString().matches("")) {

        } else {
            if (Integer.parseInt(number.getText().toString()) == x) {
                oneTouch++;
                if (oneTouch == 1) {

                    score++;
                    stopTime = true;
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//
//                        }
//                    });
                    //Burada random timer ve game timer durdurulmalı ve random timer tekrar açılmalı
                    /*
                      check = false;
                    oneTouch = 0;
                    numberText.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    Ve bunlar eklenmeli
                     */
                    button.setVisibility(View.INVISIBLE);


                }


                scoreText.setText("Score: " + score);
            } else {
                error++;
                if (score > 0) {
                    if (error == 3) {
                        scoreText.setText("Score: " + (score - 1));
                        error = 0;
                    }
                }

            }
        }
    }

    public void randomTimer() {
        x = random.nextInt(899999) + 100000;
        numberText.setText("Number: " + x);
        countDownTimer2 = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                numberText.setVisibility(View.INVISIBLE);
                check = true;
                gameTimer();
            }
        }.start();

    }

    public void gameTimer() {
        if (check = true) {
            countDownTimer = new CountDownTimer(11000, 1000) {
                @Override
                public void onTick(long l) {
                    timeText.setText("Time :" + l / 1000);


                }

                @Override
                public void onFinish() {
                    check = false;
                    oneTouch = 0;
                    numberText.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    if (score < 5) {
                        randomTimer();
                    } else if (score == 5) {

                        //Burada hata var
                        Intent intent = getIntent();
                        startActivity(intent);
                    }

                }
            }.start();
        }

    }

}