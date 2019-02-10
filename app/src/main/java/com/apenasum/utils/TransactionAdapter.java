package com.apenasum.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.apenasum.model.Transaction;
import com.apenasum.R;

import java.util.List;

public class TransactionAdapter extends ArrayAdapter<Transaction> {

    private List<Transaction> transactions;

    public TransactionAdapter(@NonNull Context context, int resource, @NonNull List<Transaction> transactions) {
        super(context, resource, transactions);
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        View listItem = null;
        TransactionAdapter.ViewHolder holder = null;

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listItem = inflater.inflate(R.layout.transaction_list, null, true);

            holder = new TransactionAdapter.ViewHolder();
            holder.logista = (TextView) listItem.findViewById(R.id.logista);
            holder.valor = (TextView) listItem.findViewById(R.id.valor);

            listItem.setTag(holder);
        } else{
            listItem = view;
            holder = (TransactionAdapter.ViewHolder) view.getTag();
        }

        holder.logista.setText(transactions.get(position).getNomeLogista());
        holder.valor.setText(transactions.get(position).getValor());

        return listItem;
    }

    static class ViewHolder {
        TextView logista;
        TextView valor;

    }
}
