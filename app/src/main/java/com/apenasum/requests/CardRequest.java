package com.apenasum.requests;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.apenasum.R;
import com.apenasum.api.UserApi;
import com.apenasum.controller.Validations;
import com.apenasum.gui.HomeActivity;
import com.apenasum.utils.Constants;
import com.apenasum.utils.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardRequest {

    /**
     * SingleTon to not invoke many different Objects
     */
    private static final CardRequest INSTANCE = new CardRequest();

    private CardRequest() {
    }

    public static CardRequest getInstance() {
        return INSTANCE;
    }

    private Retrofit retrofit = new Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    private UserApi userApi = retrofit.create(UserApi.class);


    public void getCards(final Activity activity) {
        if (Validations.isConnected(activity)) {

//todo colocar campos de email do edittext
            Call<UserApi.LoginResponse> userRequest = userApi.login("apenasum@gmail.com", "apenasum2019");
            userRequest.enqueue(new Callback<UserApi.LoginResponse>() {
                @Override
                public void onResponse(Call<UserApi.LoginResponse> call, Response<UserApi.LoginResponse> response) {
                    if (response.code() == 200) {
                        Util.saveUser(activity, response.body());
                        activity.startActivity(new Intent(activity, HomeActivity.class));
                        Toast.makeText(activity, R.string.login_sucess, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserApi.LoginResponse> call, Throwable t) {
                    Toast.makeText(activity, R.string.login_error, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


}



