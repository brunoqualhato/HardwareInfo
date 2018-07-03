package qualhato.hardwareinfo.fragmentos;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.hardware.ObterHardwarePadrao;
import qualhato.hardwareinfo.hardware.ObterProcessador;
import qualhato.hardwareinfo.util.ConverteValores;


public class Memoria extends Fragment {
    ObterHardwarePadrao obterHardwarePadrao = new ObterHardwarePadrao();
    DonutProgress donutRAMUsage;
    DonutProgress donutInternalStorage;
    DonutProgress donutExternalStorage;
    TextView memoriaTotal;
    TextView memoriaUsada;
    TextView memoriaLivre;

    Timer timer;
    Runnable runOnUiThread;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memoria, container, false);
        memoriaTotal = (TextView) view.findViewById(R.id.tv_memoria_total);
        memoriaUsada = (TextView) view.findViewById(R.id.tv_memoria_usada);
        memoriaLivre = (TextView) view.findViewById(R.id.tv_memoria_livre);


        donutRAMUsage = view.findViewById(R.id.donut_ram_usada);
        donutInternalStorage = view.findViewById(R.id.donut_internal_storage);
        donutExternalStorage = view.findViewById(R.id.donut_external_storage);

        runThread();
        return view;
    }

    private void runThread() {

        new Thread() {
            public void run() {
                int i = 0;
                while (i++ < 1000) {
                    try {
                        if (getActivity() == null)
                            return;
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                memoriaUsada.setText(ConverteValores.pegaTamanho(obterHardwarePadrao.totalDeMemoriaRam(getContext())));
                                memoriaTotal.setText(ConverteValores.pegaTamanho(obterHardwarePadrao.ramUsada(getContext())));
                                memoriaLivre.setText(ConverteValores.pegaTamanho(obterHardwarePadrao.memoriaRamLivre(getContext())));


                                float ram = ObterHardwarePadrao.calculatePercentage(obterHardwarePadrao.totalDeMemoriaRam(getContext()), obterHardwarePadrao.ramUsada(getContext()));

                                donutRAMUsage.setProgress(ram);

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


