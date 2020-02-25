package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QoneActivity extends AppCompatActivity {
    private RadioGroup rg;
    private RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);
    }

    public void click(View view){
        rg=findViewById(R.id.rg);
        rb=findViewById(rg.getCheckedRadioButtonId());
        if(rb!=null) {
            String Q1 = rb.getText().toString();
            String TAG = "chose:";
            Log.d(TAG, Q1);
            Intent intent = new Intent(this, QtwoActivity.class);
            intent.putExtra("Q1", Q1);
            startActivity(intent);
        }
    }
}
