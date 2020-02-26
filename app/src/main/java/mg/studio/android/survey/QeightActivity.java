package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eight);


        rg=findViewById(R.id.rg);
        bt=findViewById(R.id.btd1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb=findViewById(rg.getCheckedRadioButtonId());
                if(rb!=null) {
                    bt.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    bt.setEnabled(true);
                }

            }
        });
    }

    private RadioGroup rg;
    private RadioButton rb;
    private Button bt;
    public void click(View view){

            String Q8 = rb.getText().toString();


            Intent intent = new Intent(this, QnineActivity.class);
            /////re
            Intent preintent = getIntent();
            String Q1 = preintent.getStringExtra("Q1");
            String Q2 = preintent.getStringExtra("Q2");
            String Q3 = preintent.getStringExtra("Q3");
            String Q4 = preintent.getStringExtra("Q4");
            String Q5 = preintent.getStringExtra("Q5");
            String Q6 = preintent.getStringExtra("Q6");
            String Q7 = preintent.getStringExtra("Q7");
            String TAG = "chose:";
            Log.d(TAG, Q1 + ";" + Q2 + ";" + Q3 + ";" + Q4 + ";" + Q5 + ";" + Q6 + ";" + Q7 + ";" + Q8);


            intent.putExtra("Q1", Q1);
            intent.putExtra("Q2", Q2);
            intent.putExtra("Q3", Q3);
            intent.putExtra("Q4", Q4);
            intent.putExtra("Q5", Q5);
            intent.putExtra("Q6", Q6);
            intent.putExtra("Q7", Q7);
            intent.putExtra("Q8", Q8);
            startActivity(intent);

    }
}
