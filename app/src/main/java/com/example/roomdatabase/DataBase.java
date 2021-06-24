package com.example.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {
        Produit.class
},version = 1)
public abstract class DataBase extends RoomDatabase  {
    public abstract ProduitDAO produitDAO();
}
