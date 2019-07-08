package com.example.flickrdemo.ui.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Button;

import com.example.flickrdemo.R;

public class Utility {

    public static android.support.v7.app.AlertDialog alert;


    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivitymanager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnectedOrConnecting()) {
            return false;
        } else {
            return true;
        }
    }


    public static void showNetworkFailureAlert(Context mContext) {
        if (alert != null && alert.isShowing())
            return;
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(mContext, R.style.AppTheme_AlertDialog);
        builder.setMessage(mContext.getResources().getString(R.string.no_network_msg)).setTitle(mContext.getResources().getString(R.string.app_name))
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        alert = builder.create();
        alert.show();
        Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        nbutton.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));

    }

}
