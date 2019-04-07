package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    ArrayList<String> ProductList2 = new ArrayList<String>();
    public void ClickFunction2(View view) {
        int tmp=0;
        EditText product2 = (EditText) findViewById(R.id.editText);
        final ListView MyListView = (ListView) findViewById(R.id.ListId);
        ProductList2.add(product2.getText().toString());
        if(tmp==0){
            Toast.makeText( Main3Activity.this, "Dodano Produkt", Toast.LENGTH_SHORT).show();
        }
        for(int i=0 ;i<ProductList2.size()-1;i++){
            if(ProductList2.get(i).equals(product2.getText().toString())){
                Toast.makeText(Main3Activity.this, "Ten produkt został juz dodany", Toast.LENGTH_SHORT).show();
                ProductList2.remove(product2.getText().toString());
            }
            else{
                Toast.makeText(Main3Activity.this, "Dodano Produkt", Toast.LENGTH_SHORT).show();
            }
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ProductList2);
        MyListView.setAdapter(arrayAdapter);
        MyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductList2.remove(position);
                MyListView.invalidateViews();
                Toast.makeText(Main3Activity.this, "Usunięto produkt", Toast.LENGTH_SHORT).show();
            }
        });
        tmp+=1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        image.animate().alpha(0.25f).setDuration(0);
    }

}

