package mg.studio.android.survey;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class PswdService extends Service {
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mLayoutParams;
    private View mView;
    private Handler handler;
    public PswdService() {
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        setInitialPassword();
        return super.onStartCommand(intent, flags, startId);
    }

    private void setInitialPassword() {
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mLayoutParams = new WindowManager.LayoutParams();
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.O) {
            mLayoutParams.type=WindowManager.LayoutParams.TYPE_PHONE;
        }else{
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
        mLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        mLayoutParams.x = 0;
        mLayoutParams.y = 0;
        mView = LayoutInflater.from(this).inflate(R.layout.set_pswd, null);
        mView.setFocusableInTouchMode(true);
        mView.findViewById(R.id.set_unlock_pswd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pswd = ((EditText)mView.findViewById(R.id.fill_pswd)).getText().toString();
                String cpswd = ((EditText)mView.findViewById(R.id.cf_pswd)).getText().toString();
                TextView pswdTitle = mView.findViewById(R.id.pswd_title);
                if(pswd.length()==0){
                    pswdTitle.setText(R.string.empty_pswd);
                    pswdTitle.setTextColor(getColor(R.color.red));
                    return;
                }else if(cpswd.length()==0){
                    pswdTitle.setText(R.string.empty_cf_pswd);
                    pswdTitle.setTextColor(getColor(R.color.red));
                    return;
                }else if (!pswd.equals(cpswd)){
                    pswdTitle.setText(R.string.cf_fail);
                    pswdTitle.setTextColor(getColor(R.color.red));
                    return;
                }
                SharedPreferences sp = getSharedPreferences("pswd",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("spswd",pswd);
                editor.commit();
                // stop service
                onDestroy();
            }
        });
        mWindowManager.addView(mView,mLayoutParams);
    }

    // stop service
    @Override
    public void onDestroy() {
        super.onDestroy();
        mWindowManager.removeView(mView);
    }
}
