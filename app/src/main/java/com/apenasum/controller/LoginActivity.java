package com.apenasum.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.apenasum.R;
import com.apenasum.utils.Host;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = (EditText) findViewById(R.id.editEmailLogin);
        edPassword = (EditText) findViewById(R.id.editSenhaLogin);
    }

    public void doLogin(View view){

        String emailLogin = edEmail.getText().toString();
        String passwordLogin = edPassword.getText().toString();

        if(!emailLogin.isEmpty() && !passwordLogin.isEmpty()){
           Ion.with(LoginActivity.this)
                    .load(Host.URL_LOGIN)
                    .setBodyParameter("email", emailLogin)
                    .setBodyParameter("password", passwordLogin)
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>(){
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            try{

                                String status = result.get("status").getAsString();
                                String token = result.get("token_type").getAsString();

                                if(token!=""){
                                    Toast.makeText(LoginActivity.this, "Login com sucesso!"
                                            , Toast.LENGTH_LONG).show();

                                    //pega os dados do login do usuário para persistir os dados em uma lista de preferencia
                                    //como uma sessão de usuário
                                    SharedPreferences sharedPreferences = getSharedPreferences("preferencias",
                                            Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();

                                    editor.putString("idUsuario", result.get("id").getAsString());
                                    editor.putString("nomeUsuario", result.get("nome").getAsString());
                                    editor.putString("emailUsuario", result.get("email").getAsString());
                                    editor.apply();

                                    Intent intent = new Intent(LoginActivity.this,
                                            HomeActivity.class);
                                    intent.putExtra("emailUsuario", result.get("email").getAsString());

                                    startActivity(intent);

                                } else if(status.equals("error")){
                                    Toast.makeText(LoginActivity.this, "Email ou senha "
                                            + "incorretos!", Toast.LENGTH_LONG).show();
                                } else{
                                    Toast.makeText(LoginActivity.this, "Ops, ocorreu algum "
                                            + "erro dentro", Toast.LENGTH_LONG).show();
                                }

                            } catch (Exception erro){
                                Toast.makeText(LoginActivity.this, "Ops, ocorreu algum erro fora.",
                                        Toast.LENGTH_LONG).show();

                            }
                        }
                    });

        } else{
            Toast.makeText(LoginActivity.this, "Todos os campos precisam ser "
                    + "preenchidos", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }

}
