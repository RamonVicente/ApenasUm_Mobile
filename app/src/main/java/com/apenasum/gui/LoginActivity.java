package com.apenasum.gui;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.apenasum.R;
import com.apenasum.requests.UserRequest;
import com.apenasum.utils.Constants;

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail;
    private String edPassword;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;
        edEmail = (EditText) findViewById(R.id.et_email);
        edPassword = Constants.PASS;
        // edPassword = (EditText) findViewById(R.id.editSenhaLogin);
        MaterialButton btn_login = (MaterialButton) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRequest.getInstance().login(activity, edEmail.getText().toString(), edPassword);
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();


    }

}
