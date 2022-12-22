package com.example.motorbike;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.motorbike.Adaptadores.ProductAdapter;
import com.example.motorbike.DB.DBFirebase;
import com.example.motorbike.Entidades.Producto;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ArrayList<Producto> arrayProductos;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProducts = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();
        // **** PRODUCTOS
        /*
        Producto producto1 = new Producto("Producto1", "Desc1",1000, "", "","");
        Producto producto2 = new Producto("Producto2", "Desc2",2000,"","","");
        Producto producto3 = new Producto("Producto3", "Desc3",3000,"","","");
        Producto producto4 = new Producto("Producto4", "Desc4",4000,"","","");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);

        // **** **** ****
        */

        productAdapter = new ProductAdapter(this,arrayProductos);
        listViewProducts.setAdapter(productAdapter);
        dbFirebase.getData(productAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
                return true;
            case R.id.itemMap:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}