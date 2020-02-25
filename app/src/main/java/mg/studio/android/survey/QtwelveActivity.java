package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QtwelveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_twelve);
    }
    private RadioGroup rg;
    private RadioButton rb;
    public void click(View view){
        rg=findViewById(R.id.rg);
        rb=findViewById(rg.getCheckedRadioButtonId());
        if(rb!=null) {
            String Q12 = rb.getText().toString();


            Intent intent = new Intent(this, ShowActivity.class);
            /////re
            Intent preintent = getIntent();
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
            String TAG = "chose:";
            Log.d(TAG, Q8 + ";" + Q9 + ";" + Q10 + ";" + Q11 + ";" + Q12);


            intent.putExtra("Q1", Q1);
            intent.putExtra("Q2", Q2);
            intent.putExtra("Q3", Q3);
            intent.putExtra("Q4", Q4);
            intent.putExtra("Q5", Q5);
            intent.putExtra("Q6", Q6);
            intent.putExtra("Q7", Q7);
            intent.putExtra("Q8", Q8);
            intent.putExtra("Q9", Q9);
            intent.putExtra("Q10", Q10);
            intent.putExtra("Q11", Q11);
            intent.putExtra("Q12", Q12);
            startActivity(intent);
        }
    }
}
