package qualhato.hardwareinfo.atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.hardware.ObterHardwarePadrao;
import qualhato.hardwareinfo.hardware.ObterProcessador;
import qualhato.hardwareinfo.hardware.ObterSensores;

public class HardwareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        ObterSensores obterSensores = new ObterSensores();

        final TextView usoProcessador = (TextView) findViewById(R.id.ttvProcessador);

        obterSensores.obterSensores(this, usoProcessador);
    }


}
