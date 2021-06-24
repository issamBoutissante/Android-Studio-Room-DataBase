package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProduitDAO {
    @Insert
    public void ajouterProduit(Produit pr);
    @Update
    public void modifierProduit(Produit pr);
    @Delete
    public void supprimerProduit(Produit pr);
    @Query("select * from Produit")
    public List<Produit> getAllProduit();
    @Query("select * from Produit where code=:code")
    public Produit getProduitByCode(int code);
}
