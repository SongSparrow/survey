package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {
    private JSONObject json;
    private Survey survey;
    private ArrayList<Response> responses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        responses = (ArrayList<Response>) getIntent().getSerializableExtra("responses");
        survey = (Survey) getIntent().getSerializableExtra("survey");
        setLayout();
    }

    //设置layout
    private void setLayout() {
        json = new JSONObject();
        for (int i = 0; i < survey.getLen(); i++) {
            String question = survey.getQuestions()[i].getQuestion();
            String response = responses.get(i).getResponse();
            setQuestion(question);
            setResponse(response);
            try {
                json.put(question, responses.get(i).getResponse());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void setQuestion(String question) {
        LinearLayout rl = findViewById(R.id.ll);
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 4);
        tv.setLayoutParams(lp);
        tv.setText(question);
        tv.setTextSize(20);
        tv.setTextColor(getResources().getColor(R.color.base));
        rl.addView(tv);
    }

    private void setResponse(String response) {
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 24);
        tv.setLayoutParams(lp);
        tv.setText(response);
        LinearLayout rl = findViewById(R.id.ll);
        rl.addView(tv);
    }

    public void click(View view) {
        Intent intent = new Intent(this, FinishActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void save(View view) {
        Toast.makeText(this, "保存文件", Toast.LENGTH_LONG).show();
        String res = json.toString();
        Log.d("res:", res);
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm");
        String date = sDateFormat.format(new java.util.Date());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            this.getExternalFilesDir(null);
            String filename = "results.json";
            File saveData = new File(this.getExternalFilesDir(null), filename);
            //sd card
            try {
                saveData.createNewFile();
            } catch (IOException e) {
                Log.d("res:", "000");
                e.printStackTrace();
            }
            try {
                Log.d("res:外部", saveData.toString());
                FileOutputStream f = new FileOutputStream(saveData);
                f.write(res.getBytes());
                f.flush();
                f.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        File saveDatain = new File(this.getFilesDir(), "results.json");
        //内部存储
        try {
            Log.d("res:", "111");
            saveDatain.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Log.d("res:内部", saveDatain.toString());
            FileOutputStream f = new FileOutputStream(saveDatain);
            f.write(res.getBytes());
            f.flush();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
