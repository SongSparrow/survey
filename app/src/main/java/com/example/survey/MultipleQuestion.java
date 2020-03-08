package com.example.survey;

public class MultipleQuestion implements Question {
    private String question;
    private String[] options;
    public MultipleQuestion(String question,String[] options){
        this.question=question;
        this.options=options;
    }
    public String getType(){
        return "Multiple";
    }

    @Override
    public String getQuestion() {
        return question;
    }
    public String[] getOptions() {
        return options.clone();
    }
}
