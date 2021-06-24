package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= Room.databaseBuilder(getApplicationContext(),DataBase.class,"GestionProduit").allowMainThreadQueries().build();
        findViewById(R.id.ajouterBtn).setOnClickListener(this);
        findViewById(R.id.modifierBtn).setOnClickListener(this);
        findViewById(R.id.supprimerBtn).setOnClickListener(this);
        findViewById(R.id.listerProduit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ajouterBtn:
                Intent intentAjout=new Intent(this,Ajouter_Produit.class);
                startActivity(intentAjout);
                break;
            case R.id.modifierBtn:
                Intent intentModification=new Intent(this,Modifier_Produit.class);
                startActivity(intentModification);
                break;
            case R.id.supprimerBtn:
                Intent intentSupprission=new Intent(this,Supprimer_Produit.class);
                startActivity(intentSupprission);
                break;
            case R.id.listerProduit:
                Intent intentListeProduit=new Intent(this,Lister_Produits.class);
                startActivity(intentListeProduit);
                break;
        }
    }
}