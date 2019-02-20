package com.example.arafat.quizcompletion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private static final String TAG = "MainActivity";
    private int check = 0, result = 0;
    private String[] statement = {"Dhaka is the capital of Bangladesh.", "Kabul is the capital of Armenia.", "Beijing is the capital of china.",
            "Mumbai is the capital of India.", "Jordan is the capital of Amman.", "Want to see your score?6"};
    private TextView question;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button trueButton, falseButton;
        trueButton = findViewById(R.id.true_btn);
        falseButton = findViewById(R.id.false_btn);
        question = findViewById(R.id.question);
        progressBar = findViewById(R.id.progress_horizontal);
        progressBar.setProgress(0);
        progressBar.setMax(5);


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == 5) {
                    question.setText("Your score is: " + String.valueOf(result));
                    trueButton.setVisibility(view.GONE);
                    falseButton.setVisibility(view.GONE);
                    progressBar.setVisibility(view.GONE);
                } else
                    checkTrueAnswer();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == 5) {
                    question.setText("Your score is: " + String.valueOf(result));
                } else
                    checkFalseAnswer();
            }
        });

    }

    private void checkTrueAnswer() {
        if (check == 0 || check == 2)
            result++;
        check++;
        progressBar.setProgress(check);
        question.setText(statement[check]);
    }

    private void checkFalseAnswer() {
        if (check == 1 || check == 3 || check == 4)
            result++;
        check++;
        progressBar.setProgress(check);
        question.setText(statement[check]);
    }
}
