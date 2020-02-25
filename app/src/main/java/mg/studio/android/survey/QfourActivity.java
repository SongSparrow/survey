package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class QfourActivity extends AppCompatActivity {

    private String Q4="";
    private CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);
    }

    public void click(View view){
       cb=findViewById(R.id.rbtd1);
       if(cb.isChecked()){
           Q4=Q4+cb.getText()+" / ";
       }
        cb=findViewById(R.id.rbtd2);
        if(cb.isChecked()){
            Q4=Q4+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd3);
        if(cb.isChecked()){
            Q4=Q4+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd4);
        if(cb.isChecked()){
            Q4=Q4+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd5);
        if(cb.isChecked()){
            Q4=Q4+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd6);
        if(cb.isChecked()){
            Q4=Q4+cb.getText()+" / ";
        }
        cb=findViewById(R.id.rbtd7);
        if(cb.isChecked()){
            Q4=Q4+cb.getText()+" / ";
        }

        if(Q4!="") {

            Intent intent = new Intent(this, QfiveActivity.class);
            /////re
            Intent preintent = getIntent();
            String Q1 = preintent.getStringExtra("Q1");
            String Q2 = preintent.getStringExtra("Q2");
            String Q3 = preintent.getStringExtra("Q3");
            String TAG = "chose:";
            Log.d(TAG, Q1 + ";" + Q2 + ";" + Q3 + ";" + Q4);


            intent.putExtra("Q1", Q1);
            intent.putExtra("Q2", Q2);
            intent.putExtra("Q3", Q3);
            intent.putExtra("Q4", Q4);
            startActivity(intent);
        }
    }
}
