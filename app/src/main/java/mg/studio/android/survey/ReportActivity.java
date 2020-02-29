package mg.studio.android.survey;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class ReportActivity extends AppCompatActivity {


    private TextView tv;
    private JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);


        Intent preintent = getIntent();
        json = new JSONObject();
        Bundle bundle = preintent.getExtras();
        for (String key : bundle.keySet()) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    json.put(key, JSONObject.wrap(bundle.get(key)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String Q1 = preintent.getStringExtra("Q1");
        String Q2 = preintent.getStringExtra("Q2");
        String Q3 = preintent.getStringExtra("Q3");
        String Q4 = preintent.getStringExtra("Q4");
        String Q5 = preintent.getStringExtra("Q5");
        String Q6 = preintent.getStringExtra("Q6");
        String Q7 = preintent.getStringExtra("Q7");
        String Q8 = preintent.getStringExtra("Q8");
        String Q9 = preintent.getStringExtra("Q9");
        String Q10 = preintent.getStringExtra("Q10");
        String Q11 = preintent.getStringExtra("Q11");
        String Q12 = preintent.getStringExtra("Q12");

        //Q1
        tv = findViewById(R.id.txt3);
        tv.setText("-" + Q1);
        //Q2
        tv = findViewById(R.id.txt5);
        tv.setText("-" + Q2);
        //Q3
        tv = findViewById(R.id.txt7);
        tv.setText("-" + Q3);
        //Q4
        tv = findViewById(R.id.txt9);
        tv.setText("-" + Q4);
        //Q5
        tv = findViewById(R.id.txt11);
        tv.setText("-" + Q5);
        //Q6
        tv = findViewById(R.id.txt13);
        tv.setText("-" + Q6);
        //Q7
        tv = findViewById(R.id.txt15);
        tv.setText("-" + Q7);
        //Q8
        tv = findViewById(R.id.txt17);
        tv.setText("-" + Q8);
        //Q9
        tv = findViewById(R.id.txt19);
        tv.setText("-" + Q9);
        //Q10
        tv = findViewById(R.id.txt21);
        tv.setText("-" + Q10);
        //Q11
        tv = findViewById(R.id.txt23);
        tv.setText("-" + Q11);
        //Q12
        tv = findViewById(R.id.txt25);
        tv.setText("-" + Q12);







    }


    public void click(View view) {
        Intent intent = new Intent(this, Finish_surveyActivity.class);
        startActivity(intent);
    }

    public void save(View view) {
        Toast.makeText(this, "保存文件", Toast.LENGTH_LONG).show();
        String res = json.toString();
        Log.d("res:", res);


        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm");
        String date =sDateFormat.format(new java.util.Date());


        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            this.getExternalFilesDir(null);
            String filename=getExternalFilesDir(null).toString()+"/savedata_";
            filename+=date+".json";
            File saveData = new File(filename);
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

        File saveDatain=new File(this.getFilesDir(),"saveData_"+date+".json");
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