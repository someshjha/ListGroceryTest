package com.sjha.listgrocerytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ProductActivity extends Activity {

    ListView listView;
    DbHelperProduct db;
    List<Product> productsList;
    public int count;
    LinearLayout layout;
    double price;
    String productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        layout = (LinearLayout)findViewById(R.id.ProductLayout);
        db = new DbHelperProduct(this);
        listView = (ListView) findViewById(R.id.listProduct);
        productsList = new ArrayList<Product>();
        productsList = db.getallProduct();
        count = productsList.size();

        if(count == 0){
            productAdd();
        }
        Toast.makeText(this,Integer.toString(count) , Toast.LENGTH_SHORT).show();

        final List<Product> productsList = db.getallProduct();

        for (Product cn : productsList){
            String log = "Id: " + cn.get_id() + " ,Product Name: " + cn.getProductName() + " ,Product Price: " + cn.getPrice();
            // Writing products to log
            Log.d("Name: ", log);
        }

        ViewAdapter adapter = new ViewAdapter(this, R.layout.product_row, productsList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i;
                i = new Intent(ProductActivity.this, MakeNewListActivity.class);
                Bundle b = new Bundle();
                b.putString("name", productsList.get(position).getProductName());
                b.putString("price", Double.toString(productsList.get(position).getPrice()));
                i.putExtra("bundle", b);
                startActivity(i);
            }

        });




    }


    public void productAdd(){

        db.createProduct(this, "Asian Yellow Pears" , 1.99);
        db.createProduct(this, "Red/Golden Apples", 1.69);
        db.createProduct(this, "Clementines", 4.99);
        db.createProduct(this, "Globe Grapes", 2.99);

        db.createProduct(this, "Salted Pistachios", 2.00);
        db.createProduct(this, "Roasted Cashews", 8.49);
        db.createProduct(this, "Milk Chocolate Covered Peanuts", 7.00);

        db.createProduct(this, "Red or White Onion", 1.49);
        db.createProduct(this, "Baby Spinach", 3.99);
        db.createProduct(this, "Yellow Corn", 2.99);
        db.createProduct(this, "Baby Carrots", 1.49);
        db.createProduct(this, "White Potatoes", 5.99);

        db.createProduct(this, "Lean Ground Beef", 6.49);
        db.createProduct(this, "Lean Ground Chicken", 5.49);
        db.createProduct(this, "Pork Loin", 5.99);
        db.createProduct(this, "Chicken Drumsticks", 3.99);

        db.createProduct(this, "Fish Fillets", 3.29);
        db.createProduct(this, "Tiger Shrimps", 15.99);
        db.createProduct(this, "salmon", 5.99);
        db.createProduct(this, "Haddock Fillets", 9.99);

        db.createProduct(this, "Multigrain Bread", 3.49);
        db.createProduct(this, "Clabatta Baguette", 3.29);
        db.createProduct(this, "Cookies", 3.99);
        db.createProduct(this, "Boston Cream Pie", 6.99);
    }


    public void showMainMenu(View view){

        Intent mainMenu = new Intent(this, MainActivity.class);
        startActivity(mainMenu);
    }




}
