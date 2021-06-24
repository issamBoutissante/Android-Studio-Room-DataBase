package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Supprimer_Produit extends AppCompatActivity {
    EditText codeEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer__produit);
        codeEdt=findViewById(R.id.codeEdt);
    }

    public void supprimerProduit(View view) {
        if(TextUtils.isEmpty(codeEdt.getText().toString())){
            showToast("Il faut remplir le code pour rechrecher");
            return;
        }
        Integer code=Integer.parseInt(codeEdt.getText().toString());
        Produit p=MainActivity.db.produitDAO().getProduitByCode(code);
        if(p==null){
            showToast("Ce produit n'existe pas");
            return;
        }
        MainActivity.db.produitDAO().supprimerProduit(p);
        showToast("La supprission a ete effecutue");
    }

    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void backToMenu(View view) {
        finish();
    }
}