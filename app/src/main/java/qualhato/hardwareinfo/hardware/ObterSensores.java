package qualhato.hardwareinfo.hardware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

import java.util.List;


public class ObterSensores {
    private SensorManager mSensorManager;

    public void obterSensores(Context context, TextView textView) {

        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
            textView.setText("Tem Sensor de Magnetismo");
        } else {
            textView.setText("Não Tem Sensor de Magnetismo");
        }
    }
}

