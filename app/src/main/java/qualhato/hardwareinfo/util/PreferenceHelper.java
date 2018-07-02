package qualhato.hardwareinfo.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    //essa classe verifica se o app já foi aberto mais de uma vez
    //sem essa classe, mostra a tela de tutorial toda vez que abre o app

    private final String INTRO = "intro";
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context) {
        app_prefs = context.getSharedPreferences("shared",
                Context.MODE_PRIVATE);
        this.context = context;
    }

    public void putIntro(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(INTRO, loginorout);
        edit.commit();
    }
    public String getIntro() {
        return app_prefs.getString(INTRO, "");
    }

}