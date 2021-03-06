package qualhato.hardwareinfo.hardware;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import static android.content.Context.WIFI_SERVICE;

public class ObterHardwarePadrao {


    public String obterWifi(Context context){

        WifiManager wifiMgr = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        String ipAddress = Formatter.formatIpAddress(ip);

       return "Wifi: " + ipAddress;
    }

    public String quantidadeDeProcessadores() {


        return Runtime.getRuntime().availableProcessors() + "";
    }

    public String memoriaRamLivre() {


        return String.valueOf(Runtime.getRuntime().freeMemory());
    }

    public long capacidadeRam() {

        long memoriaMaxima = Runtime.getRuntime().maxMemory();

        return memoriaMaxima;


    }

    public String memoriaAvaliada() {


        return String.valueOf(Runtime.getRuntime().totalMemory()) + "";
    }

    public void armazenamento() {
        File[] diretorios = File.listRoots();

        for (File root : diretorios) {
            System.out.println("Sistema de arquivos root: " + root.getAbsolutePath());
            System.out.println("Espaço total(bytes): " + root.getTotalSpace());
            System.out.println("Espaço livre (bytes): " + root.getFreeSpace());
            System.out.println("Espaço usado (bytes): " + root.getUsableSpace());
        }

    }

    public String serial() {
        return Build.SERIAL;
    }

    public String modelo() {
        return Build.MODEL;
    }

    public String id() {
        return Build.ID;
    }

    public String fabricacao() {
        return Build.MANUFACTURER;
    }

    public String marca() {
        return Build.BRAND;
    }

    public String tipo() {
        return Build.TYPE;
    }

    public String usuario() {
        return Build.USER;
    }

    public int versaoDoSistema() {
        return Build.VERSION_CODES.BASE;
    }

    public String versaoSDK() {
        return Build.VERSION.CODENAME;
    }

    public String board() {
        return Build.BOARD;
    }

    public String host() {
        return Build.HOST;
    }

    public String versaoAndroid() {
        return Build.VERSION.RELEASE;
    }



}
