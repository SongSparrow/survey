package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        Intent preintent = getIntent();
        String Q1=preintent.getStringExtra("Q1");
        String Q2=preintent.getStringExtra("Q2");
        String Q3=preintent.getStringExtra("Q3");
        String Q4=preintent.getStringExtra("Q4");
        String Q5=preintent.getStringExtra("Q5");
        String Q6=preintent.getStringExtra("Q6");
        String Q7=preintent.getStringExtra("Q7");
        String Q8=preintent.getStringExtra("Q8");
        String Q9=preintent.getStringExtra("Q9");
        String Q10=preintent.getStringExtra("Q10");
        String Q11=preintent.getStringExtra("Q11");
        String Q12=preintent.getStringExtra("Q12");

        //Q1
        tv =findViewById(R.id.txt3);
        tv.setText("-"+Q1);
        //Q2
        tv =findViewById(R.id.txt5);
        tv.setText("-"+Q2);
        //Q3
        tv =findViewById(R.id.txt7);
        tv.setText("-"+Q3);
        //Q4
        tv =findViewById(R.id.txt9);
        tv.setText("-"+Q4);
        //Q5
        tv =findViewById(R.id.txt11);
        tv.setText("-"+Q5);
        //Q6
        tv =findViewById(R.id.txt13);
        tv.setText("-"+Q6);
        //Q7
        tv =findViewById(R.id.txt15);
        tv.setText("-"+Q7);
        //Q8
        tv =findViewById(R.id.txt17);
        tv.setText("-"+Q8);
        //Q9
        tv =findViewById(R.id.txt19);
        tv.setText("-"+Q9);
        //Q10
        tv =findViewById(R.id.txt21);
        tv.setText("-"+Q10);
        //Q11
        tv =findViewById(R.id.txt23);
        tv.setText("-"+Q11);
        //Q12
        tv =findViewById(R.id.txt25);
        tv.setText("-"+Q12);




    }
    public void click(View view){
            Intent intent = new Intent(this,Finish_surveyActivity.class);
            startActivity(intent);

    }
}
