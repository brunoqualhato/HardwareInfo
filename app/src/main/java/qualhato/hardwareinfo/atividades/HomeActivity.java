package qualhato.hardwareinfo.atividades;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.fragmentos.Processador;
import qualhato.hardwareinfo.fragmentos.Resumo;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_resumo:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.resumo, new Resumo())
                            .commit();
                    return true;
                case R.id.navigation_processador:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.resumo, new Processador())
                            .commit();
                    return true;
                case R.id.navigation_sensores:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.resumo, new Resumo())
                .commit();
    }


}
