package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produit {
    @PrimaryKey (autoGenerate = false)
    private Integer code;
    private String designation;
    @ColumnInfo (name = "prix_unitaire")
    private Double prixUnitaire;

    public Produit() { }

    public Produit(Integer code, String designation, Double prixUnitaire) {
        this.code = code;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    @NonNull
    @Override
    public String toString() {
        return "code = "+code+", designation = "+designation+", prix Unitaire = "+prixUnitaire;
    }
}
