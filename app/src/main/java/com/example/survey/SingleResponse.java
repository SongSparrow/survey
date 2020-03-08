package com.example.survey;

public class SingleResponse implements Response {
    private String response="";
    @Override
    public Boolean isResponse() {
        return response!="";
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
