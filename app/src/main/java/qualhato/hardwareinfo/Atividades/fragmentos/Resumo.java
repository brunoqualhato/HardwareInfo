package qualhato.hardwareinfo.Atividades.fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import qualhato.hardwareinfo.Atividades.hardware.ObterHardware;
import qualhato.hardwareinfo.R;


public class Resumo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ObterHardware obterHardware = new ObterHardware();
        View view = inflater.inflate(R.layout.fragment_resumo, container, false);


        ListView listaTela = (ListView) view.findViewById(R.id.listaResumo);
        ArrayList<String> lista = new ArrayList<>();


        lista.add(obterHardware.quantidadeDeProcessadores());
        lista.add(obterHardware.capacidadeRam() + " bytes de ram");
        lista.add(obterHardware.memoriaAvaliada() + "bytes de memoria ram avaliada");
        lista.add(obterHardware.memoriaRamLivre() + "bytes de memoria ram livre");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1, lista);

        listaTela.setAdapter(arrayAdapter);

        //retorna o fragmento criado
        return view;
    }

}
