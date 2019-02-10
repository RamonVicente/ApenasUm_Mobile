package com.apenasum.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.apenasum.api.UserApi;
import com.apenasum.model.User;

public abstract class Util {


    public static void saveUser(Activity activity, UserApi.LoginResponse user) {


        SharedPreferences sharedPreferences = activity.getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Constants.USER_ID, user.getId());
        editor.putString(Constants.USER_CPF, user.getCpf());
        editor.putString(Constants.USER_EMAIL, user.getEmail());
        editor.putString(Constants.USER_LAST_NAME, user.getLastName());
        editor.putString(Constants.USER_NAME, user.getName());
        editor.putString(Constants.USER_PASS, user.getPassword());

        editor.commit();
    }

}
