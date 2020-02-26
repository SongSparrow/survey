package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        bt=findViewById(R.id.btn);
        cb=findViewById(R.id.rbtn1);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if(isChecked){
                    bt.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    bt.setEnabled(true);
                }else{
                    // sub.setBackgroundResource(R.drawable.a);
                    bt.setBackgroundColor(getResources().getColor(R.color.colorH));
                    bt.setEnabled(false);
                }
            }
        });
    }
    //TO Question_one
    public void click(View view){

        //if user agree to requests.
        if(cb.isChecked()==true){
            Intent intent = new Intent(this,QoneActivity.class);
            startActivity(intent);
        }
    }
}
