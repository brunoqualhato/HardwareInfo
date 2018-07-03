package qualhato.hardwareinfo.fragmentos;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import qualhato.hardwareinfo.R;
import qualhato.hardwareinfo.util.ConverteValores;

public class SistemaOperacional extends Fragment {

    Resources mResources;
    ImageView ivMenu;
    ImageView ivBack;
    TextView tvTitle;
    ImageView ivOSVerIC;
    TextView tvVersionName;
    TextView tvReleaseDate;
    TextView tvVersion;
    TextView tvApiLevel;
    TextView tvBuildId;
    TextView tvBuildTime;
    TextView tvFingerprint;
    TextView tvSdkName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sistema_operacional, container, false);
    }

    private void getOSInfo() {

        int CVersion = android.os.Build.VERSION.SDK_INT;
        tvApiLevel.setText("".concat(String.valueOf(Build.VERSION.SDK_INT)));
        tvVersion.setText("".concat(Build.VERSION.RELEASE));
        tvBuildId.setText("".concat(Build.ID));
        tvBuildTime.setText("".concat(ConverteValores.getDate(Build.TIME)));
        tvFingerprint.setText("".concat(Build.FINGERPRINT));

        tvSdkName.setText(Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName());
        switch (CVersion) {
            case 11:
                tvVersionName.setText(mResources.getString(R.string.honeycomb).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("February 22, 2011"));
                break;

            case 12:
                tvVersionName.setText(mResources.getString(R.string.honeycomb).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("May 10, 2011"));
                break;

            case 13:
                tvVersionName.setText(mResources.getString(R.string.honeycomb).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("July 15, 2011"));
                break;

            case 14:
                tvVersionName.setText(mResources.getString(R.string.ics).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("October 18, 2011"));
                break;

            case 15:
                tvVersionName.setText(mResources.getString(R.string.ics).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("November 28, 2011"));
                break;

            case 16:
                tvVersionName.setText(mResources.getString(R.string.jellybean).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("July 9, 2012"));
                break;

            case 17:
                tvVersionName.setText(mResources.getString(R.string.jellybean).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("November 13, 2012"));
                break;

            case 18:
                tvVersionName.setText(mResources.getString(R.string.jellybean).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("July 24, 2013"));
                break;

            case 19:
                tvVersionName.setText(mResources.getString(R.string.kitkat).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("October 31, 2013"));
                break;

            case 21:
                tvVersionName.setText(mResources.getString(R.string.lollipop).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("November 12, 2014"));
                break;

            case 22:
                tvVersionName.setText(mResources.getString(R.string.lollipop).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("March 9, 2015"));
                break;

            case 23:
                tvVersionName.setText(mResources.getString(R.string.marshmallow).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("October 5, 2015"));
                break;

            case 24:
                tvVersionName.setText(mResources.getString(R.string.nougat).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("August 22, 2016"));
                break;

            case 25:
                tvVersionName.setText(mResources.getString(R.string.nougat).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("October 4, 2016"));
                break;
            case 26:
                tvVersionName.setText(mResources.getString(R.string.oreo).concat(" ".concat(String.valueOf(Build.VERSION.RELEASE))));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("August 21, 2017"));
                break;
            default:
                tvVersionName.setText(mResources.getString(R.string.unknown_version));
                tvReleaseDate.setText(mResources.getString(R.string.release_date).concat("-"));
                break;
        }
    }

}
