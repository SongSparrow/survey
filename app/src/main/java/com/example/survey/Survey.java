package com.example.survey;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Survey类：
 * 处理json String为Survey对象。
 */
public class Survey implements Serializable {
    //Survey问卷 ID，保存为结果可使用
    private int id;
    //问题数量
    private int length;
    //问题数组
    private Question[] questions;

    public Question[] getQuestions(){
        return questions;
    }
    public int getLen(){
        return length;
    }
    //jsonString to Survey
    public Survey (String jsonString) throws JSONException {
        //从jsonString获取survey的json对象
        JSONObject json =new JSONObject(jsonString).getJSONObject("survey");
        //获取问题数组
        JSONArray questionArray =json.getJSONArray("questions");
        length=json.getInt("len");
        questions=new Question[length];
        for(int i=0;i<length;i++){
            questions[i]=getQuestion(questionArray.getJSONObject(i));
        }
    }
    //实例化问题
    public Question getQuestion(JSONObject json) throws JSONException {
        String type = json.getString("type");
        if (type.equals("single") ) {
            String question = json.getString("question");
            JSONArray optionsArray = json.getJSONArray("options");
            String[] options = new String[optionsArray.length()];
            for (int i = 0; i < options.length; i++) {
                options[i] = optionsArray.getJSONObject(i).getString(String.valueOf((i+1)));
            }
            return new SingleQuestion(question, options);
        } else if (type.equals("multiple")) {

            String question = json.getString("question");
            JSONArray optionsArray = json.getJSONArray("options");
            String[] options = new String[optionsArray.length()];
            for (int i = 0; i < optionsArray.length(); i++) {
                options[i] = optionsArray.getJSONObject(i).getString(String.valueOf((i + 1)));
            }
            return new MultipleQuestion(question, options);
        } else if (type.equals("text")) {
            return new TextQuestion(json.getString("question"));
        } else {
            return null;
        }
    }
}
