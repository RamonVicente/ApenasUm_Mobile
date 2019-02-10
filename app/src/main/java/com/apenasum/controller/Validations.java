package com.apenasum.controller;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
import com.apenasum.R;

import java.util.Date;

/**
 * Created by daividvasconcelos on 12/05/2017.
 */

public class Validations {

    public static boolean isSelectionValid(String selected, String text, String msgError) throws Exception {
        boolean vailid = true;

        if (selected.toLowerCase().trim().equals("selecione") || selected.toLowerCase().trim().equals("select") || selected.toLowerCase().trim().equals("detinatário")) {
            throw new Exception(msgError);
        } else if (text.trim().length() < 5) {
            throw new Exception("Favor inserir mensagem.");
        }

        return vailid;

    }

    public static boolean isEmailValid(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    public static boolean isLicenseValid(Date date) {
        Date today = new Date();
        if (date == null) {
            return true;
        } else if (today.before(date)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isConnected(Activity activity) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) activity.getApplicationContext().getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            Toast.makeText(activity, R.string.check_connection, Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
