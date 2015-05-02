package com.sjha.listgrocerytest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjha on 15-05-01.
 */
public class NewListDbHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "List";
    private static final String TABLE_LIST = "listTable";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PRICE = "price";


    public NewListDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableList = "CREATE TABLE " + TABLE_LIST + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_PRICE + " TEXT" + ")";
        db.execSQL(CreateTableList);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIST);
        onCreate(db);
    }

    //Insert Value
    public void adddata(Context context,String name,double price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PRICE, price);
        db.insert(TABLE_LIST, name, values);
        db.close();
    }

    //Get Row Count
    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LIST;
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if(cursor != null && !cursor.isClosed()){
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }

    //Delete Query
    public void removeListItem(int id) {
        String countQuery = "DELETE FROM " + TABLE_LIST + " where " + KEY_ID + "= " + id ;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(countQuery);
    }

    //Get newList
    public List<Product> getNewList(){
        String selectQuery = "SELECT  * FROM " + TABLE_LIST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<Product> newList = new ArrayList<Product>();
        if (cursor.moveToFirst()) {
            do {
                Product list = new Product();
                list.set_id(Integer.parseInt(cursor.getString(0)));
                list.setProductName(cursor.getString(1));
                list.setPrice(Double.parseDouble(cursor.getString(2)));
                newList.add(list);
            } while (cursor.moveToNext());
        }
        return newList;
    }


}
