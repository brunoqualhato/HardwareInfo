package qualhato.hardwareinfo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public static int calcularPercentual(double value, double total) {
        double usage = (int) ((value * 100.0f) / total);
        return (int) usage;
    }
    public static String getDate(long timeStamp) {

        try {
             DateFormat sdf = new SimpleDateFormat(KeyUtil.datePattern);
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }
private static class KeyUtil {
    public static final String datePattern = "dd MMM yyyy HH:mm:ss z";
    public static final String KEY_MODE = "key_mode";

    /*** Sensor */
    public static final String KEY_SENSOR_NAME = "key_sensor_name";
    public static final String KEY_SENSOR_TYPE = "key_sensor_type";
    public static final String KEY_SENSOR_ICON = "key_sensor_icon";

    public static float KEY_LAST_KNOWN_HUMIDITY = 0f;

    public static final int KEY_CAMERA_CODE = 101;
    public static final int KEY_CALL_PERMISSION = 102;
    public static final int KEY_READ_PHONE_STATE = 103;
    public static final int IS_USER_COME_FROM_SYSTEM_APPS = 1;
    public static final int IS_USER_COME_FROM_USER_APPS = 2;
}
}

