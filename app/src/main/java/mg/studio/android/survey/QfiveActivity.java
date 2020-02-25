package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class QfiveActivity extends AppCompatActivity {
    private String Q5="";
    private CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);
    }
    public void click(View view){
        cb=findViewById(R.id.rbtd1);
        if(cb.isChecked()){
            Q5=Q5+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd2);
        if(cb.isChecked()){
            Q5=Q5+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd3);
        if(cb.isChecked()){
            Q5=Q5+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd4);
        if(cb.isChecked()){
            Q5=Q5+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd5);
        if(cb.isChecked()){
            Q5=Q5+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd6);
        if(cb.isChecked()){
            Q5=Q5+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd7);
        if(cb.isChecked()){
            Q5=Q5+cb.getText()+" / ";
        }

        if(Q5!="") {

            Intent intent = new Intent(this, QsixActivity.class);
            /////re
            Intent preintent = getIntent();
            String Q1 = preintent.getStringExtra("Q1");
            String Q2 = preintent.getStringExtra("Q2");
            String Q3 = preintent.getStringExtra("Q3");
            String Q4 = preintent.getStringExtra("Q4");
            String TAG = "chose:";
            Log.d(TAG, Q1 + ";" + Q2 + ";" + Q3 + ";" + Q4 + ";" + Q5);


            intent.putExtra("Q1", Q1);
            intent.putExtra("Q2", Q2);
            intent.putExtra("Q3", Q3);
            intent.putExtra("Q4", Q4);
            intent.putExtra("Q5", Q5);
            startActivity(intent);
        }
    }
}
