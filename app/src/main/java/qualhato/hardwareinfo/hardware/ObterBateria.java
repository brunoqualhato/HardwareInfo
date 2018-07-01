package qualhato.hardwareinfo.hardware;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.DebugUtils;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import qualhato.hardwareinfo.R;

public class ObterBateria {

    public String readBattery(Context context) {
        StringBuilder sb = new StringBuilder();
        IntentFilter batteryIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryIntent = context.registerReceiver(null, batteryIntentFilter);

        boolean present = batteryIntent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);
        sb.append("PRESENTE?: " + present + "\n");

        int status = batteryIntent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            sb.append("BATERIA ESTÁ CARREGANDO\n");
        }
        if (status == BatteryManager.BATTERY_STATUS_FULL) {
            sb.append("BATERIA ESTÁ CHEIA\n");
        }

        int plugged = batteryIntent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        if (plugged == BatteryManager.BATTERY_PLUGGED_USB) {
            sb.append("BATERIA PLUGADA NA USB\n");
        }
        if (plugged == BatteryManager.BATTERY_PLUGGED_AC) {
            sb.append("BATERIA PLUGADA NO AC\n");
        }

        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        sb.append("LEVEL: " + level + "\n");

        int scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        sb.append("ESCALA: " + scale + "\n");

        int health = batteryIntent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
        sb.append("SAUDE: " + saudeBateria(health) + "\n");

        String technology = batteryIntent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
        sb.append("TECNOLOGIA: " + technology + "\n");

        int temperature = batteryIntent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
        sb.append("TEMPERATURE: " + temperature + "\n");

        int voltage = batteryIntent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
        sb.append("VOLTAGE: " + voltage + "\n");



        int icon_small_resourceId = batteryIntent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, 0);
        sb.append("ICONE PEQUENO: " + icon_small_resourceId + "\n");

        return sb.toString();
    }

    public String saudeBateria(int health) {
        String result;
        switch (health) {
            case BatteryManager.BATTERY_HEALTH_COLD:
                result = "BATERIA ESTÁ VELHA";
                break;
            case BatteryManager.BATTERY_HEALTH_DEAD:
                result = "BATERIA ESTÁ QUASE MORTA";
                break;
            case BatteryManager.BATTERY_HEALTH_GOOD:
                result = "BATERIA ESTÁ BOA";
                break;
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                result = "BATERIA ESTÁ OTIMA";
                break;
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                result = "BATERIA ESTÁ SOB SUPER TENSÃO";
                break;
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                result = "ESTADO DA BATERIA DESCONHECIDO";
                break;
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                result = "SAUDE DA BATERIA NÃO ESPECIFICADA";
                break;
            default:
                result = "unkknown";
        }

        return result;
    }
}