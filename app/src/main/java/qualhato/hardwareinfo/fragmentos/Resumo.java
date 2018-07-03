package qualhato.hardwareinfo.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.atividades.MainActivity;
import qualhato.hardwareinfo.hardware.ObterBateria;
import qualhato.hardwareinfo.hardware.ObterHardwarePadrao;
import qualhato.hardwareinfo.util.ConverteValores;

import static android.content.Context.WIFI_SERVICE;


public class Resumo extends Fragment {
    TextView tv_brand_name;
    TextView tv_model_number;
    TextView tv_manufacturer;
    TextView tv_board;
    TextView tv_hardware;
    TextView tv_serial_no;
    TextView tv_android_id;
    TextView tv_screen_resolution;
    TextView tv_boot_loader;
    TextView tv_user;
    TextView tv_host;
    TextView tv_model;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resumo, container, false);

        tv_brand_name = (TextView) view.findViewById(R.id.tv_brand_name);
        tv_model_number = (TextView) view.findViewById(R.id.tv_model_number);
        tv_manufacturer = (TextView) view.findViewById(R.id.tv_manufacturer);
        tv_board = (TextView) view.findViewById(R.id.tv_board);
        tv_hardware = (TextView) view.findViewById(R.id.tv_hardware);
        tv_serial_no = (TextView) view.findViewById(R.id.tv_serial_no);
        tv_android_id = (TextView) view.findViewById(R.id.tv_android_id);
        tv_screen_resolution = (TextView) view.findViewById(R.id.tv_screen_resolution);
        tv_boot_loader = (TextView) view.findViewById(R.id.tv_boot_loader);
        tv_user = (TextView) view.findViewById(R.id.tv_user);
        tv_host = (TextView) view.findViewById(R.id.tv_host);
        tv_model = (TextView) view.findViewById(R.id.tv_model);


        ObterHardwarePadrao obterHardwarePadrao = new ObterHardwarePadrao();


        tv_brand_name.setText(obterHardwarePadrao.marca());
        tv_model_number.setText(obterHardwarePadrao.modelo());
        tv_manufacturer.setText(obterHardwarePadrao.fabricacao());
        tv_board.setText(obterHardwarePadrao.board());
        tv_hardware.setText(obterHardwarePadrao.hardware());
        tv_serial_no.setText(obterHardwarePadrao.serial());
        tv_android_id.setText(obterHardwarePadrao.id());
        tv_screen_resolution.setText(obterHardwarePadrao.resolucao(getActivity()));
        tv_boot_loader.setText(obterHardwarePadrao.bootloader());
        tv_user.setText(obterHardwarePadrao.usuario());
        tv_host.setText(obterHardwarePadrao.host());
        tv_model.setText(obterHardwarePadrao.modelo());


        //retorna o fragmento criado
        return view;
    }

}
