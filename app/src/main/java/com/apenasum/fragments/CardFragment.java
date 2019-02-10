package com.apenasum.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.apenasum.R;
import com.apenasum.adapter.CardAdapter;
import com.apenasum.gui.HomeActivity;
import com.apenasum.gui.NewCardActivity;
import com.apenasum.model.BankCard;
import com.apenasum.requests.CardRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {

    List<BankCard> bankCards = new ArrayList<>();

    public CardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_card, container, false);


        getListBanksCards();


        CardAdapter cardAdapter = new CardAdapter(R.layout.item_card, getActivity(), bankCards);
        ListView list_cards = v.findViewById(R.id.list_cards);
        list_cards.setAdapter(cardAdapter);
        list_cards.deferNotifyDataSetChanged();

        FloatingActionButton fab = ((HomeActivity) getActivity()).getFab();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewCardActivity.class));
            }
        });

        return v;
    }


    private void getListBanksCards() {

        BankCard bankCard = new BankCard();

        bankCard.setCode("1251.2531.2343-23");
        bankCard.setFlag("Visa");
        bankCard.setNameBank("Itau");
        bankCard.setSecurityCode(123);
        bankCard.setType("Debito");
        bankCards.add(bankCard);

        bankCard = new BankCard();
        bankCard.setCode("3124.6442.7532-41");
        bankCard.setFlag("MasterCard");
        bankCard.setNameBank("NuBank");
        bankCard.setSecurityCode(534);
        bankCard.setType("Credito");
        bankCards.add(bankCard);

        bankCard = new BankCard();
        bankCard.setCode("7456.5427.9563-93");
        bankCard.setFlag("Visa");
        bankCard.setNameBank("Santander");
        bankCard.setSecurityCode(814);
        bankCard.setType("Debito");
        bankCards.add(bankCard);

        bankCard = new BankCard();
        bankCard.setCode("73513.4142.9685-21");
        bankCard.setFlag("MasterCard");
        bankCard.setNameBank("Santander");
        bankCard.setSecurityCode(913);
        bankCard.setType("Debito");
        bankCards.add(bankCard);

        bankCard = new BankCard();
        bankCard.setCode("1251.2531.2343-23");
        bankCard.setFlag("MasterCard");
        bankCard.setNameBank("Bradesco");
        bankCard.setSecurityCode(794);
        bankCard.setType("Credito");
        bankCards.add(bankCard);

        bankCard = new BankCard();
        bankCard.setCode("1251.2531.2343-23");
        bankCard.setFlag("Visa");
        bankCard.setNameBank("NuBank");
        bankCard.setSecurityCode(687);
        bankCard.setType("Debito");
        bankCards.add(bankCard);
    }

}
