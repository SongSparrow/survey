package com.example.survey;

import android.util.Log;

public class TextResponse implements Response {
    private String response="";
    @Override
    public Boolean isResponse() {
        return response.equals("")!=true;
    }


    @Override
    public void setResponse(String response) {
        this.response=response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}
