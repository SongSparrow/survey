package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Survey survey;
    private int count;
    private ArrayList<Response> responses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        count = -1;
        //请求权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 1);
        //读取文件
        String json = "";
        FileInputStream fis = null;
        File file = new File(this.getFilesDir() + "/2.json");
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] buffer = new byte[0];
            try {
                buffer = new byte[fis.available()];
                Log.d("991558885555:", "00010  " + fis.available());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            json = new String(buffer);
            if (json.equals("")) Log.d("991558885555:", "0000");
        }
        //处理得到Survey对象
        try {
            survey = new Survey(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 页面跳转和设置layout
     * @param view
     */
    public void click(View view) {
        if (count == -1) {
            CheckBox checkBox = findViewById(R.id.checkBox);
            if (checkBox.isChecked() == false) return;
        } else {
            //设置问卷layout
            if (count < 0 && count >= survey.getLen()) return;
            String type = survey.getQuestions()[count].getType();
            Response response = getResponse(type);
            if (!response.isResponse()) return;
            responses.add(response);
        }
        count++;
        if (count >= survey.getLen()) {
            //跳转到report
            Intent intent = new Intent(this, ReportActivity.class);
            intent.putExtra("survey", survey);
            intent.putExtra("responses", responses);
            startActivity(intent);
            this.finish();
            return;
        }
        setLayout();
    }
//设置layout
    private void setLayout() {
        String type = survey.getQuestions()[count].getType();
        if (type.equals("Single")) {
            SingleQuestion question = (SingleQuestion) survey.getQuestions()[count];
            setContentView(R.layout.single_question);
            TextView tv = findViewById(R.id.txt1);
            tv.setText("Question " + String.valueOf((count + 1)) + " :");
            tv = findViewById(R.id.txt2);
            tv.setText(question.getQuestion());
            ViewGroup optGroup = findViewById(R.id.rg);
            String[] options = question.getOptions();
            for (String opt : options) {
                RadioButton optBtn = new RadioButton(this);
                optBtn.setText(opt);
                optGroup.addView(optBtn);
            }
        } else if (type.equals("Multiple")) {
            MultipleQuestion question = (MultipleQuestion) survey.getQuestions()[count];
            setContentView(R.layout.multiple_question);
            TextView tv = findViewById(R.id.txt1);
            tv.setText("Question " + String.valueOf((count + 1)) + " :");
            tv = findViewById(R.id.txt2);
            tv.setText(question.getQuestion());
            ViewGroup optGroup = findViewById(R.id.ll);
            String[] options = question.getOptions();
            for (String opt : options) {
                CheckBox optBtn = new CheckBox(this);
                optBtn.setText(opt);
                optGroup.addView(optBtn);
            }
        } else if (type.equals("Text")) {
            TextQuestion question = (TextQuestion) survey.getQuestions()[count];
            setContentView(R.layout.text_question);
            TextView tv = findViewById(R.id.txt1);
            tv.setText("Question " + String.valueOf((count + 1)) + " :");
            tv = findViewById(R.id.txt2);
            tv.setText(question.getQuestion());
        }
    }

    /**
     * 获取Response
     */
    private Response getResponse(String type) {
        if (type.equals("Single")) {
            SingleResponse response = new SingleResponse();
            ViewGroup opts = findViewById(R.id.rg);
            for (int i = 0; i < opts.getChildCount(); i++) {
                RadioButton optBtn = (RadioButton) opts.getChildAt(i);
                if (optBtn.isChecked()) {
                    response.setResponse(optBtn.getText().toString());
                    break;
                }
            }
            return response;
        } else if (type.equals("Multiple")) {
            MultipleResponse response = new MultipleResponse();
            ViewGroup checks = findViewById(R.id.ll);
            for (int i = 0; i < checks.getChildCount(); i++) {
                CheckBox check = (CheckBox) checks.getChildAt(i);
                if (check.isChecked()) {
                    response.setResponse(check.getText().toString());
                }
            }
            return response;
        } else if (type.equals("Text")) {
            TextResponse response = new TextResponse();
            EditText et = findViewById(R.id.et1);
            response.setResponse(et.getText().toString().trim());
            return response;
        } else {
            return null;
        }
    }
}
