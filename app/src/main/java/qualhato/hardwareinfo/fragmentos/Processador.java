package qualhato.hardwareinfo.fragmentos;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.TimerTask;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.hardware.ObterProcessador;

public class Processador extends Fragment {

    TextView txtEstatistica;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_processador, container, false);

        txtEstatistica = (TextView) view.findViewById(R.id.txtEstatistica);

        runThread();
        return view;
    }

    private void runThread() {

        new Thread() {
            public void run() {
                int i  = 0;
                while (i++ < 1000) {
                    try {
                        if(getActivity() == null)
                            return;
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                txtEstatistica = (TextView) getActivity().findViewById(R.id.txtEstatistica);
                                txtEstatistica.setText(ObterProcessador.mostrarEstatistica());

                            }
                        });
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}