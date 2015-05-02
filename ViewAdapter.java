
package com.sjha.listgrocerytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sjha on 15-04-29.
 */

public class ViewAdapter extends ArrayAdapter<Product> {

    TextView numId,
        productName,
        price;

    public ViewAdapter(Context context, int textViewResourceId){
        super(context, textViewResourceId);
    }

    public ViewAdapter(Context context, int layoutResourceId, List<Product> data){
        super(context, layoutResourceId, data);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.product_row, parent, false);
        }
            numId = (TextView) row.findViewById(R.id.numId);
            productName = (TextView) row.findViewById(R.id.ProductName);
            price = (TextView) row.findViewById(R.id.ProductPrice);
            numId.setText(Integer.toString((getItem(position).get_id())));
            productName.setText(getItem(position).getProductName());
            price.setText(Double.toString(getItem(position).getPrice()));
            return row;
    }
}






