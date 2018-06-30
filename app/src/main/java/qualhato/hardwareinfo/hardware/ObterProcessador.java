package qualhato.hardwareinfo.hardware;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ObterProcessador {

    public static String mostrarEstatistica() {
        java.lang.Process p = null;
        BufferedReader in = null;
        String returnString = null;
        try {
            p = Runtime.getRuntime().exec("top -n 1");
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (returnString == null || returnString.contentEquals("")) {
                returnString = in.readLine();
            }
        } catch (IOException e) {
            Log.e("Erro", "Erro ao obter informaçoes do processador");
            e.printStackTrace();
        } finally {
            try {
                in.close();
                p.destroy();
            } catch (IOException e) {
                Log.e("Erro",
                        "Erro ao apagar as informações obtidas");
                e.printStackTrace();
            }
        }
        return returnString;
    }

    public static void especificacoesDoCpu(TextView textView) {
        ProcessBuilder processBuilder;
        String suporte = "";
        String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
        InputStream inputStream;
        Process process;
        byte[] byteArry;


        byteArry = new byte[1024];

        try {
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            inputStream = process.getInputStream();

            while (inputStream.read(byteArry) != -1) {

                suporte = suporte + new String(byteArry);
            }

            inputStream.close();

        } catch (IOException ex) {

            ex.printStackTrace();
        }

        textView.setText(suporte);
    }

    public int[] obterStatisticaDoCpu() {

        String tempString = mostrarEstatistica();

        tempString = tempString.replaceAll(",", "\n");
        tempString = tempString.replaceAll("User", "\n");
        tempString = tempString.replaceAll("System", "\n");
        tempString = tempString.replaceAll("IOW", "\n");
        tempString = tempString.replaceAll("IRQ", "\n");
        tempString = tempString.replaceAll("%", "\n");
        for (int i = 0; i < 10; i++) {
            tempString = tempString.replaceAll("  ", " ");
        }
        tempString = tempString.trim();
        String[] myString = tempString.split(" ");
        int[] cpuUsageAsInt = new int[myString.length];
        for (int i = 0; i < myString.length; i++) {
            myString[i] = myString[i].trim();
            cpuUsageAsInt[i] = Integer.parseInt(myString[i]);
        }
        return cpuUsageAsInt;
    }


}


