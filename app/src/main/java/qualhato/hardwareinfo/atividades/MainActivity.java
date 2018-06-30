package qualhato.hardwareinfo.atividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.fragmentos.Resumo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resumo = (Button) findViewById(R.id.btnResumo);
        Button hardware = (Button) findViewById(R.id.btnHardware);

        hardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HardwareActivity.class);
                startActivity(i);
            }
        });

        resumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new Resumo())
                        .commit();
            }
        });


    }
}
