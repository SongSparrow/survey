package com.example.survey;

public class TextQuestion implements Question {
    private String question;
    public TextQuestion(String question){
        this.question=question;
    }
    public String getType(){
        return "Text";
    }
    public String getQuestion(){
        return question;
    }
}
