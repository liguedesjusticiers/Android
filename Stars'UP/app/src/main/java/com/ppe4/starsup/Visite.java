package com.ppe4.starsup;

/**
 * Created by Alex on 10/04/2016.
 */
public class Visite {
    private String nom;
    private String note;
    private String commentaire;

    public Visite(String nom, String note, String commentaire){
        this.nom = nom;
        this.note = note;
        this.commentaire = commentaire;
    }

    public String getNom() {
        return nom;
    }

    public String getNote() {
        return note;
    }

    public String getCommentaire(){
        return commentaire;
    }

    public void setCommentaire(String commentaire){
        this.commentaire = commentaire;
    }
}
