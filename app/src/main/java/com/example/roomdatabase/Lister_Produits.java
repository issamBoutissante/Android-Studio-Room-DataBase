package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Lister_Produits extends AppCompatActivity {
    ListView listProduitListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister__produits);
        listProduitListView = findViewById(R.id.list_produit);
        List<Produit> listProduit;
        try{
            listProduit=MainActivity.db.produitDAO().getAllProduit();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        ListeProduitAdapter adapter=new ListeProduitAdapter(this,listProduit);
        listProduitListView.setAdapter(adapter);
    }

    public void backToMenu(View view) {
        finish();
    }
}