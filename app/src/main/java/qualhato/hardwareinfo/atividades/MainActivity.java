package qualhato.hardwareinfo.atividades;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.SIM;
import qualhato.hardwareinfo.fragmentos.APPS;
import qualhato.hardwareinfo.fragmentos.Bateria;
import qualhato.hardwareinfo.fragmentos.Bluetooth;
import qualhato.hardwareinfo.fragmentos.CPU;
import qualhato.hardwareinfo.fragmentos.Camera;
import qualhato.hardwareinfo.fragmentos.DetalhesSensores;
import qualhato.hardwareinfo.fragmentos.Extras;
import qualhato.hardwareinfo.fragmentos.Internet;
import qualhato.hardwareinfo.fragmentos.Memoria;
import qualhato.hardwareinfo.fragmentos.Processador;
import qualhato.hardwareinfo.fragmentos.Resumo;
import qualhato.hardwareinfo.fragmentos.SistemaOperacional;
import qualhato.hardwareinfo.fragmentos.Sobre;
import qualhato.hardwareinfo.fragmentos.Tela;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sua ação", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.conteiner, new Resumo())
                .commit();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_dispositivo) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Resumo())
                    .commit();

        } else if (id == R.id.nav_os) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new SistemaOperacional())
                    .commit();

        } else if (id == R.id.nav_sensor) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new DetalhesSensores())
                    .commit();
        } else if (id == R.id.nav_cpu) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new CPU())
                    .commit();
        } else if (id == R.id.nav_batteria) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Bateria())
                    .commit();
        } else if (id == R.id.nav_network) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Internet())
                    .commit();
        } else if (id == R.id.nav_sim) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new SIM())
                    .commit();
        } else if (id == R.id.nav_camera) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Camera())
                    .commit();
        } else if (id == R.id.nav_memoria) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Memoria())
                    .commit();
        } else if (id == R.id.nav_bluetooth) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Bluetooth())
                    .commit();
        } else if (id == R.id.nav_tela) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Tela())
                    .commit();
        } else if (id == R.id.nav_extra) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Extras())
                    .commit();
        } else if (id == R.id.nav_system_apps) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new APPS())
                    .commit();
        } else if (id == R.id.nav_about_us) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.conteiner, new Sobre())
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
