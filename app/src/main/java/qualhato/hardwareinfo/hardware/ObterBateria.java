package qualhato.hardwareinfo.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import qualhato.hardwareinfo.R;

public class ObterBateria {

    private Context mContext;

    private TextView mTextViewInfo;
    private TextView mTextViewPercentage;
    private ProgressBar mProgressBar;

    private int mProgressStatus = 0;

    public String obterBateria(Context context){
        String resultado = "";

        // Get the application context
        mContext = context.getApplicationContext();

        IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        mContext.registerReceiver(mBroadcastReceiver,iFilter);
//
//
//        mTextViewInfo = (TextView) findViewById(R.id.tv_info);
//        mTextViewPercentage = (TextView) findViewById(R.id.tv_percentage);
//        mProgressBar = (ProgressBar) findViewById(R.id.pb);


        return resultado;
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
            mTextViewInfo.setText("Battery Scale : " + scale);



            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            // Display the battery level in TextView
            mTextViewInfo.setText(mTextViewInfo.getText() + "\nBattery Level : " + level);

            // Calculate the battery charged percentage
            float percentage = level/ (float) scale;
            // Update the progress bar to display current battery charged percentage
            mProgressStatus = (int)((percentage)*100);

            // Show the battery charged percentage text inside progress bar
            mTextViewPercentage.setText("" + mProgressStatus + "%");

            // Show the battery charged percentage in TextView
            mTextViewInfo.setText(mTextViewInfo.getText() +
                    "\nPercentage : "+ mProgressStatus + "%");

            // Display the battery charged percentage in progress bar
            mProgressBar.setProgress(mProgressStatus);
        }
    };

}
