package com.sjha.listgrocerytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sjha on 15-05-01.
 */
public class NewListViewAdapter extends ArrayAdapter<Product>{

    TextView numId,
            productName,
            price;


    public NewListViewAdapter(Context context, int textViewResourceId){
        super(context, textViewResourceId);
    }

    public NewListViewAdapter(Context context, int layoutResourceId, List<Product> data){
        super(context, layoutResourceId, data);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        double priceConvert;

        if (row == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.newlist_row, parent, false);
        }

        productName = (TextView) row.findViewById(R.id.textView);
        price = (TextView) row.findViewById(R.id.textView2);

        productName.setText(getItem(position).getProductName());
        price.setText(Double.toString(getItem(position).getPrice()));


        return row;
    }



}
