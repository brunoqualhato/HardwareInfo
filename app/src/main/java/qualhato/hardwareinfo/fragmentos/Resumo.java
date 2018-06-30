package qualhato.hardwareinfo.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.hardware.ObterHardwarePadrao;


public class Resumo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ObterHardwarePadrao obterHardwarePadrao = new ObterHardwarePadrao();
        View view = inflater.inflate(R.layout.fragment_resumo, container, false);


        ListView listaTela = (ListView) view.findViewById(R.id.listaResumo);
        ArrayList<String> lista = new ArrayList<>();
        lista.add(obterHardwarePadrao.quantidadeDeProcessadores());
        lista.add("bytes de memoria ram: " + obterHardwarePadrao.capacidadeRam());
        lista.add("bytes de memoria ram avaliada: " + obterHardwarePadrao.memoriaAvaliada());
        lista.add("bytes de memoria ram livre: " + obterHardwarePadrao.memoriaRamLivre());
        lista.add("Board: " + obterHardwarePadrao.board());
        lista.add("Fabricação: " + obterHardwarePadrao.fabricacao());
        lista.add("Host: " + obterHardwarePadrao.host());
        lista.add("ID: " + obterHardwarePadrao.id());
        lista.add("Android: " + obterHardwarePadrao.versaoAndroid());
        lista.add("Marca: " + obterHardwarePadrao.marca());
        lista.add("Modelo: " + obterHardwarePadrao.modelo());
        lista.add("Serial: " + obterHardwarePadrao.serial());
        lista.add("Tipo: " + obterHardwarePadrao.tipo());
        lista.add("Versão do Sistema:" + obterHardwarePadrao.versaoDoSistema());
        lista.add("Usuario: " + obterHardwarePadrao.usuario());
        lista.add("SDK: " + obterHardwarePadrao.versaoSDK());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1, lista);

        listaTela.setAdapter(arrayAdapter);

        //retorna o fragmento criado
        return view;
    }

}
