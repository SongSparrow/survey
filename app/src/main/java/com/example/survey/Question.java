package com.example.survey;

import java.io.Serializable;

public interface Question extends Serializable {
    //get type;
    public String getType();
    //get question;
    public String getQuestion();


}
