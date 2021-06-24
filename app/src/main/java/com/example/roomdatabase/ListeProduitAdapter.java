package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListeProduitAdapter extends BaseAdapter {
    Context context;
    List<Produit> produitsList;
    ListeProduitAdapter(Context context, List<Produit> produitsList){
        this.context=context;
        this.produitsList=produitsList;
    }
    @Override
    public int getCount() {
        return produitsList.size();
    }

    @Override
    public Object getItem(int position) {
        return produitsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produitsList.get(position).getCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_produit_item,null);
        }
        TextView codeTxt,designationTxt,prixUnitaireTxt;

        codeTxt= convertView.findViewById(R.id.codeTxt);
        designationTxt=convertView.findViewById(R.id.designationTxt);
        prixUnitaireTxt=convertView.findViewById(R.id.prixUnitaireTxt);

        codeTxt.setText(produitsList.get(position).getCode().toString());
        designationTxt.setText(produitsList.get(position).getDesignation());
        prixUnitaireTxt.setText(produitsList.get(position).getPrixUnitaire().toString());
        return convertView;
    }
}
