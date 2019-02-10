package com.apenasum.gui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import com.apenasum.R;
import com.apenasum.model.Transaction;
import com.apenasum.utils.TransactionAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransactionFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        List<Transaction> transactions = new ArrayList<Transaction>();
        Transaction transaction1 = new Transaction();
        transaction1.setNomeLogista("Seu João das Coxinhas");
        transaction1.setValor("R$21.50");

        Transaction transaction2 = new Transaction();
        transaction2.setNomeLogista("Atacado Feirão");
        transaction2.setValor("R$12.50");

        Transaction transaction3 = new Transaction();
        transaction3.setNomeLogista("Cervejaria Da Região");
        transaction3.setValor("R$41.20");



        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);

        ListView listView = (ListView) view.findViewById(R.id.categoria_list_view);
        TransactionAdapter cardAdapter = new TransactionAdapter(getActivity(), R.layout.transaction_list, transactions);
        listView.setAdapter(cardAdapter);

        return view;
    }

}
