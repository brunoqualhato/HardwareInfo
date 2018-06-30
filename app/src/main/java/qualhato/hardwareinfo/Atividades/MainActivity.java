package qualhato.hardwareinfo.Atividades;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import qualhato.hardwareinfo.Atividades.fragmentos.Resumo;
import qualhato.hardwareinfo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button resumo = (Button) findViewById(R.id.btnResumo);


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
