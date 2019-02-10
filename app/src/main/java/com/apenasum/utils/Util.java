package com.apenasum.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.apenasum.fragments.CardFragment;
import com.apenasum.R;
import com.apenasum.api.UserApi;
import com.apenasum.gui.HomeActivity;

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

    public static void changePageFragment(HomeActivity activity, @Nullable String nameItemMenu) {

        String tag = activity.getResources().getString(R.string.cards);

        Class fragmentClass = null;

        if (nameItemMenu != null) {

            if (nameItemMenu.contentEquals(activity.getResources().getString(R.string.cards))) {

                fragmentClass = CardFragment.class;
                tag = activity.getResources().getString(R.string.cards);

            }
        }
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        changeFragment(activity, fragmentManager, fragmentClass, tag);

    }


    private static void changeFragment(HomeActivity activity, FragmentManager fragmentManager, Class
            fragmentClass, String tag) {

        Fragment fragment = null;
        fragmentManager = activity.getSupportFragmentManager();

        Fragment frag = fragmentManager.findFragmentByTag(tag);


        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment, tag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(fragment.getClass().getName())
                .commit();
        activity.getSupportFragmentManager();

    }

}
