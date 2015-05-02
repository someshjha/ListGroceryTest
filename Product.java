package com.sjha.listgrocerytest;

import android.content.Context;

/**
 * Created by sjha on 15-04-29.
 */
public class Product{



    private int _id;
    private String productName;
    private double price;
    String newline = System.getProperty("line.separator");


    public Product(String productName, double price) {
        super();
        this.productName = productName;
        this.price = price;

    }
    public Product(Context context, String productName, double price) {
        this.productName = productName;
        this.price = price;

    }

    public Product() {
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }




    @Override
    public String toString() {
        return (_id + newline +
                productName + newline +
                "$ " + price);
    }



}
