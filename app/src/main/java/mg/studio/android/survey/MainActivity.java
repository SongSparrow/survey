package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

    }
    //TO Question_one
    public void click(View view){
        cb=findViewById(R.id.rbtn1);
        //if user agree to requests.
        if(cb.isChecked()==true){
            Intent intent = new Intent(this,QoneActivity.class);
            startActivity(intent);
        }
    }
}
