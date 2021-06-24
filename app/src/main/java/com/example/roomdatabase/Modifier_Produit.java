package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modifier_Produit extends AppCompatActivity {
    EditText codeEdt,desinationEdt,prixUnitaireEdt;
    Integer code=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier__produit);
        codeEdt=findViewById(R.id.codeEdt);
        desinationEdt=findViewById(R.id.disignationEdt);
        prixUnitaireEdt=findViewById(R.id.prixUnitaireEdt);
    }

    public void rechercherProduit(View view) {
        if(TextUtils.isEmpty(codeEdt.getText().toString())){
            showToast("Il faut remplir le code pour rechrecher");
            return;
        }
        code=Integer.parseInt(codeEdt.getText().toString());
        Produit p=MainActivity.db.produitDAO().getProduitByCode(code);
        if(p==null){
            showToast("Ce produit n'existe pas");
            code=-1;
            return;
        }
        desinationEdt.setText(p.getDesignation());
        prixUnitaireEdt.setText(p.getPrixUnitaire().toString());
    }

    public void modifierProduit(View view) {
        if(TextUtils.isEmpty(desinationEdt.getText().toString())){
            showToast("Il faut remplir la designation");
            return;
        }
        if(TextUtils.isEmpty(prixUnitaireEdt.getText().toString())){
            showToast("Il faut remplir le prixUnitaire");
            return;
        }
        if(code==-1){
            showToast("Il faut chercher le produit");
            return;
        }
        String designation=desinationEdt.getText().toString();
        Double prixUnitaire=Double.parseDouble(prixUnitaireEdt.getText().toString());
        MainActivity.db.produitDAO().modifierProduit(new Produit(code,designation,prixUnitaire));
        showToast("La modification a ete effectue");
    }

    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void backToMenu(View view) {
        finish();
    }
}