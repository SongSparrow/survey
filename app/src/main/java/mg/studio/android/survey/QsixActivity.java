package mg.studio.android.survey;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class QsixActivity extends AppCompatActivity {
    private EditText et;
    private Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);
        et=findViewById(R.id.et1);
        sub=findViewById(R.id.btd1);
        et.addTextChangedListener(
                new TextWatcher(){
                    @Override
                    public  void beforeTextChanged(CharSequence s,int start,int count,int after){}

                    @Override
                    public void onTextChanged(CharSequence s,int start,int count,int after){
                        if(et.length()!=0){
                           // sub.setBackgroundResource(R.drawable.b);
                            sub.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                            sub.setEnabled(true);
                        }else{
                           // sub.setBackgroundResource(R.drawable.a);
                            sub.setBackgroundColor(getResources().getColor(R.color.colorH));
                            sub.setEnabled(false);
                        }
                    }
                    @Override
                    public void afterTextChanged(Editable s){}
                }
        );

    }
    public void click(View view){

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
