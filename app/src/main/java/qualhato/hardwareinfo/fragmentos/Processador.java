package qualhato.hardwareinfo.fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.hardware.ObterProcessador;

public class Processador extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_processador, container, false);

        TextView txtEstatistica = (TextView) view.findViewById(R.id.txtEstatistica);

        txtEstatistica.setText(ObterProcessador.mostrarEstatistica());


        return view;
    }

}