package com.example.myapplication;

public class Question {
    private int questionDesc;
    private boolean answer;

    public Question(int questionDesc, boolean answer) {
        this.questionDesc = questionDesc;
        this.answer = answer;
    }

    public int getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(int questionDesc) {
        this.questionDesc = questionDesc;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
