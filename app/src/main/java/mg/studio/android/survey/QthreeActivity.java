package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QthreeActivity extends AppCompatActivity {
    private RadioGroup rg;
    private RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_three);
    }


    public void click(View view){
        rg=findViewById(R.id.rg);
        rb=findViewById(rg.getCheckedRadioButtonId());
        if(rb!=null) {
            String Q3 = rb.getText().toString();
            String TAG = "chose:";

            Intent intent = new Intent(this, QfourActivity.class);

            /////re
            Intent preintent = getIntent();
            String Q1 = preintent.getStringExtra("Q1");
            String Q2 = preintent.getStringExtra("Q2");

            Log.d(TAG, Q1 + ";" + Q2 + ";" + Q3);


            intent.putExtra("Q1", Q1);
            intent.putExtra("Q2", Q2);
            intent.putExtra("Q3", Q3);
            startActivity(intent);
        }
    }
}
