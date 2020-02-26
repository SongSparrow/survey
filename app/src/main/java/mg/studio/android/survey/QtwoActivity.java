package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QtwoActivity extends AppCompatActivity {
    private RadioGroup rg;
    private RadioButton rb;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);

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

    public void click(View view){

            String Q2 = rb.getText().toString();
            String TAG = "chose:";

            Intent intent = new Intent(this, QthreeActivity.class);

            /////re
            Intent preintent = getIntent();
            String Q1 = preintent.getStringExtra("Q1");

            Log.d(TAG, Q1 + ";" + Q2);


            intent.putExtra("Q1", Q1);
            intent.putExtra("Q2", Q2);

            startActivity(intent);

    }
}
