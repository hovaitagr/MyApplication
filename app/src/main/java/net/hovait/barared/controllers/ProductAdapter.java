package net.hovait.barared.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import net.hovait.barared.models.Product;
import net.hovait.barared.printtest02.R;

import java.util.List;

/**
 * Created by hovait4 on 12/11/2015.
 */
public class ProductAdapter extends BaseAdapter {

    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context, List<Product> products){
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.product_adapter, parent, false);
        }

        Button prodSKU = (Button) rowView.findViewById(R.id.prodSKU);
        TextView prodPrice = (TextView) rowView.findViewById(R.id.prodPrice);

        Product product = this.products.get(position);
        prodSKU.setText(product.getProdSKU());
        prodPrice.setText(String.valueOf(product.getProdPrice()));

        return rowView;
    }

}
