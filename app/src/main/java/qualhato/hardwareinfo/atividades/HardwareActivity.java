package qualhato.hardwareinfo.atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.RandomAccessFile;

public class HardwareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);

        TextView usoProcessador = (TextView) findViewById(R.id.ttvProcessador);
    }

    public void UsoDoProcessador() {

        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();
            while (load != null) {
                usoProcessador.setText("CPU", "Uso CPU: " + load);
                load = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
