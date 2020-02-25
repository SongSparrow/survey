package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class QsixActivity extends AppCompatActivity {
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);
    }
    public void click(View view){
        et=findViewById(R.id.et1);
        if(et.length()!=0) {
        String Q6=et.getText().toString();

            Intent intent = new Intent(this, QsevenActivity.class);
            /////re
            Intent preintent = getIntent();
            String Q1 = preintent.getStringExtra("Q1");
            String Q2 = preintent.getStringExtra("Q2");
            String Q3 = preintent.getStringExtra("Q3");
            String Q4 = preintent.getStringExtra("Q4");
            String Q5 = preintent.getStringExtra("Q5");
            String TAG = "chose:";
            Log.d(TAG, Q1 + ";" + Q2 + ";" + Q3 + ";" + Q4 + ";" + Q5 + ";" + Q6);


            intent.putExtra("Q1", Q1);
            intent.putExtra("Q2", Q2);
            intent.putExtra("Q3", Q3);
            intent.putExtra("Q4", Q4);
            intent.putExtra("Q5", Q5);
            intent.putExtra("Q6", Q6);
            startActivity(intent);
        }
    }
}
