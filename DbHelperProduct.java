package com.sjha.listgrocerytest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjha on 15-04-29.
 */
public class DbHelperProduct extends SQLiteOpenHelper{

    private SQLiteDatabase database;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    private static final String TAG = "ProductDBAdapter";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productName";
    public static final String COLUMN_PRICE = "price";






    // Database creation sql statement
    public static final String CreateProductTable = "CREATE TABLE " + TABLE_PRODUCTS + " ( " +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_PRODUCTNAME + " TEXT, " +
            COLUMN_PRICE + " Double);";



    public DbHelperProduct(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CreateProductTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelperProduct.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }



    public  void open(){

        database = getWritableDatabase();

    }



    public void createProduct(Context context, String productName, double price) {

        open();
        ContentValues values = new ContentValues();
        values.put(DbHelperProduct.COLUMN_PRODUCTNAME, productName);
        values.put(DbHelperProduct.COLUMN_PRICE, price);
        database.insert(DbHelperProduct.TABLE_PRODUCTS, null, values);
        close();
    }





    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PRODUCTS;
        int count = 0;
        getReadableDatabase();
        Cursor cursor = database.rawQuery(countQuery, null);
        if (cursor != null && !cursor.isClosed()) {
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }



    public void deleteProduct(int id) {
        String countQuery = "DELETE FROM " + TABLE_PRODUCTS + " where " + COLUMN_ID + "= " + id ;
        getReadableDatabase();
        database.execSQL(countQuery);

    }



    public List<Product> getallProduct() {
        List<Product> products = new ArrayList<Product>();

        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCTS;
        open();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.set_id(Integer.parseInt(cursor.getString(0)));
                product.setProductName(cursor.getString(1));
                product.setPrice(Double.parseDouble(cursor.getString(2)));
                products.add(product);

            } while (cursor.moveToNext());
            cursor.close();

        }

        return products;
    }





}
