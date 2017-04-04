package com.example.mike.drinkspap.Delegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mike.drinkspap.Pojo.DrinksObject;
import com.example.mike.drinkspap.Pojo.MainObject;
import com.example.mike.drinkspap.R;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

/**
 * Created by Mike on 4/4/2017.
 */

public class DrinksDelegate extends AdapterDelegate<List<MainObject>> {

    private final LayoutInflater inflater;
    private final Context context;

    public DrinksDelegate(Context context){
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    protected boolean isForViewType(@NonNull List<MainObject> items, int position) {
        return items.get(position) instanceof DrinksObject;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new DrinksDelegateViewHolder(inflater.inflate(R.layout.drinks_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<MainObject> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        DrinksObject drinksObject = (DrinksObject) items.get(position);
        DrinksDelegateViewHolder delegateViewHolder = (DrinksDelegateViewHolder) holder;

        delegateViewHolder.name.setText(drinksObject.getName());
        delegateViewHolder.price.setText(drinksObject.getPrice());
        delegateViewHolder.type.setText(drinksObject.getType());

    }

    private class DrinksDelegateViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
        TextView name, type, price;
        public DrinksDelegateViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgIcon);
            name = (TextView) itemView.findViewById(R.id.tvname);
            type = (TextView) itemView.findViewById(R.id.tvtype);
            price = (TextView) itemView.findViewById(R.id.tvprice);
        }
    }

}