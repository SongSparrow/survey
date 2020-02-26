package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class QfourActivity extends AppCompatActivity {

    private String Q4="";
    private CheckBox cb;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;
    private CheckBox cb7;
    private Button bt;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);
        bt=findViewById(R.id.btd1);
        cb1=findViewById(R.id.rbtd1);
        cb2=findViewById(R.id.rbtd2);
        cb3=findViewById(R.id.rbtd3);
        cb4=findViewById(R.id.rbtd4);
        cb5=findViewById(R.id.rbtd5);
        cb6=findViewById(R.id.rbtd6);
        cb7=findViewById(R.id.rbtd7);

        cb1.setOnCheckedChangeListener(listener);
        cb2.setOnCheckedChangeListener(listener);
        cb3.setOnCheckedChangeListener(listener);
        cb4.setOnCheckedChangeListener(listener);
        cb5.setOnCheckedChangeListener(listener);
        cb6.setOnCheckedChangeListener(listener);
        cb7.setOnCheckedChangeListener(listener);

    }

    private CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){

            switch (buttonView.getId()){
                case R.id.rbtd1:
                    test(isChecked);
                    break;
                case R.id.rbtd2:
                    test(isChecked);
                    break;
                case R.id.rbtd3:
                    test(isChecked);
                    break;
                case R.id.rbtd4:
                    test(isChecked);
                    break;
                case R.id.rbtd5:
                    test(isChecked);
                    break;
                case R.id.rbtd6:
                    test(isChecked);
                    break;
                case R.id.rbtd7:
                    test(isChecked);
                    break;
                    default:
                        break;


            }



        }

        public void test(boolean isChecked){
            if(isChecked){
                count++;
            }else{
                count--;
            }
            if(count>0){
                bt.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                bt.setEnabled(true);
            }else{
                bt.setBackgroundColor(getResources().getColor(R.color.colorH));
                bt.setEnabled(false);
            }
        }
    };

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
