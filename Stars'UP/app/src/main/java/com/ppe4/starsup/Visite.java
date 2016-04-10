package com.ppe4.starsup;

/**
 * Created by Alex on 10/04/2016.
 */
public class Visite {
    private String nom;
    private String note;

    public Visite(String nom, String note){
        this.nom = nom;
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public String getNote() {
        return note;
    }
}
