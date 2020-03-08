package com.example.survey;

import java.io.Serializable;

public interface Response extends Serializable {
    public Boolean isResponse();
    public void setResponse(String response);
    public String getResponse();
}
