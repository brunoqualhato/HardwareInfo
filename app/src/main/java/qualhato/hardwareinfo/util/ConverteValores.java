package qualhato.hardwareinfo.util;

import java.text.DecimalFormat;

public class ConverteValores {

    public static String pegaTamanho(long num) {
        int flooring, numlength;
        String[] unitname = {"B", "kB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        numlength = String.valueOf(num).length();
        flooring = (int) Math.floor((numlength - 1) / 3);
        String size = unitname[flooring];
        java.text.DecimalFormat dfmt = new java.text.DecimalFormat("###.## " + size);
        return dfmt.format((double) num / Math.pow(1024, flooring));
    }

}
