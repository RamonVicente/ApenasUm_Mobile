package com.apenasum.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.apenasum.R;
import com.apenasum.model.BankCard;

import java.util.List;

public class CardAdapter extends ArrayAdapter<BankCard> {
    private List<BankCard> cards;
    private Activity activity;
    private int resource;

    public CardAdapter(@LayoutRes int resource, Activity activity, List<BankCard> cards) {
        super(activity.getApplicationContext(), resource, cards);
        this.resource = resource;
        this.activity = activity;
        this.cards = cards;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = activity.getLayoutInflater().from(activity.getApplicationContext()).inflate(this.resource, null);
        }

        TextView numberCard = view.findViewById(R.id.number_card);
        TextView type = view.findViewById(R.id.type);


        numberCard.setText(cards.get(position).getCode());
        type.setText(cards.get(position).getType());

        return view;
    }
}
