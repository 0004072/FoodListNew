package com.hsenidmobile.romeosierra.foodlistnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsenidmobile.romeosierra.foodlistnew.model.FoodItem;

import java.util.ArrayList;

public class FoodListAdapter extends BaseAdapter {

    private ArrayList<FoodItem> foodItem;
    private LayoutInflater inflater;

    public FoodListAdapter(Context context, ArrayList<FoodItem> foodItem) {
        this.foodItem = foodItem;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return foodItem.size();
    }

    @Override
    public Object getItem(int i) {
        return foodItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list_view_item,null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        textView.setText(foodItem.get(position).getName());
        imageView.setImageResource(R.drawable.ic_lion);
        return view;
    }

}