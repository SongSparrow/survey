package com.example.survey;

import java.util.ArrayList;

public class MultipleResponse implements Response {
    private ArrayList<String> responses = new ArrayList<>();
    @Override
    public Boolean isResponse() {
        return responses.size() != 0;
    }

    @Override
    public void setResponse(String response) {
        if (responses.contains(response)) {
            responses.remove(response);
        } else {
            responses.add(response);
        }
    }

    @Override
    public String getResponse() {
        StringBuilder builder = new StringBuilder();
        for (String r : responses) {
            builder.append(r).append("\n");
        }
        return builder.toString().trim();
    }
}
