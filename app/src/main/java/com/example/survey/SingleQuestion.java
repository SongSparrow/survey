package com.example.survey;

public class SingleQuestion implements Question {
    private String question;
    private String[] options;
    public SingleQuestion(String question,String[] options){
        this.question=question;
        this.options=options;
    }
    public String getType(){
        return "Single";
    }

    @Override
    public String getQuestion() {
        return question;
    }
    public String[] getOptions() {
        return options.clone();
    }
}
