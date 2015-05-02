package com.sjha.listgrocerytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void openShowProduct(View view){

        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);

    }

    public void makeNewList(View view){


        Intent intent = new Intent(this, MakeNewListActivity.class);
        startActivity(intent);

    }

    public void showAllList(View view){

        Intent intent = new Intent(this, ShowAllListsActivity.class);
        startActivity(intent);

    }

    public void shareList(View view){

        Intent intent = new Intent(this, ShareListActivity.class);
        startActivity(intent);

    }








}
