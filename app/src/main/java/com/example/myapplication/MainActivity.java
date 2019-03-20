package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Question[] questions = {
            new Question(R.string.question_1, true),
            new Question(R.string.question_2, false),
    };
    private TextView title;
    private int currentQuestionIndex = 0;

    // 从第一道题开始设置题目
    private void updateQuestion () {
        if (currentQuestionIndex < questions.length) {
            title.setText(questions[currentQuestionIndex].getQuestionDesc());
        } else {
            Toast.makeText(MainActivity.this, R.string.last_toast, Toast.LENGTH_SHORT).show();
        }
    }

    // 检查当前用户点击的是否是正确的
    private void checkCurrentCorrect (boolean anwser) {
        Question curQuestion = questions[currentQuestionIndex];
        boolean curQAnswer = curQuestion.isAnswer();

        if (curQAnswer == anwser){
            Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        title = (TextView) findViewById(R.id.title_view);

        // 业务逻辑开始
        // 1. 绑定事件
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.checkCurrentCorrect(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.checkCurrentCorrect(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex++;
                MainActivity.this.updateQuestion();
            }
        });

        this.updateQuestion();
    }
}
