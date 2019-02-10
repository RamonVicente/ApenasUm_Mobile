package com.apenasum.gui;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.apenasum.R;
import com.apenasum.model.BankCard;
import com.google.gson.Gson;

public class NewCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView bank = findViewById(R.id.bank);
                TextView code = findViewById(R.id.code);
                TextView flag = findViewById(R.id.flag);
                TextView type = findViewById(R.id.type);
                TextView cvv = findViewById(R.id.cvv);


                BankCard bankCard = new BankCard();
                bankCard.setCode(code.getText().toString());
                bankCard.setFlag(flag.getText().toString());
                bankCard.setNameBank(bank.getText().toString());
                bankCard.setType(type.getText().toString());
                bankCard.setSecurityCode(cvv.getText().toString());

                Gson gson = new Gson();
                Intent intent = new Intent();
                intent.putExtra("obj", gson.toJson(bankCard));
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

}
