package qualhato.hardwareinfo.Atividades.hardware;

import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ObterHardware {

    public String quantidadeDeProcessadores() {


        return Runtime.getRuntime().availableProcessors() + " Processadores";
    }

    public String memoriaRamLivre() {


        return String.valueOf(Runtime.getRuntime().freeMemory()) + "(MB)";
    }

    public long capacidadeRam() {

        long memoriaMaxima = Runtime.getRuntime().maxMemory();

        return memoriaMaxima;


    }

    public String memoriaAvaliada() {


        return String.valueOf(Runtime.getRuntime().totalMemory()) + " de memoria Avaliada";
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

    public String lancamento() {
        return Build.VERSION.RELEASE;
    }

    public void usoDoProcessador() {
        
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();
            while (load != null) {
                Log.d("CPU", "Uso CPU: " + load);
                load = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
