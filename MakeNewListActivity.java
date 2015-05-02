package com.sjha.listgrocerytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MakeNewListActivity extends ActionBarActivity {



    ListView listView;
    NewListDbHelper db;
    List<Product> newList;
    public int count;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_new_list);


        listView = (ListView) findViewById(R.id.listView);
        newList = new ArrayList<Product>();

        count = newList.size();

        Intent i = getIntent();
        Bundle b = i.getBundleExtra("bundle");
        String name = b.getString("name");
        String price = b.getString("price");
        double newprice = Double.parseDouble(price);
        db = new NewListDbHelper(this);

        db.adddata(this, name, newprice);
        newList = db.getNewList();

        for (Product cn : newList){
            String log = "Id: " + cn.get_id() + " ,Product Name: " + cn.getProductName() + " ,Product Price: " + cn.getPrice();
            // Writing products to log
            Log.d("Name: ", log);

        }
        NewListViewAdapter adapter = new NewListViewAdapter(this, R.layout.product_row, newList);
        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_make_new_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void mainMenu(View view){
        Intent mainMenu = new Intent(this, MainActivity.class);
        startActivity(mainMenu);
    }

    public void showProduct(View view){

        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);

    }
}
