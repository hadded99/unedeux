/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionProduitCompetition.entities;

import java.util.Objects;
import javafx.animation.Animation.Status;

/**
 *
 * @author ahmed
 */
public class Produit {
    private int id;
    private String libelle;
    private String image;
    private float prix;
    private Statuts status;
    private Categorie categorie;
    private Competition competition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Statuts getStatus() {
        return status;
    }

    public void setStatus(Statuts status) {
        this.status = status;
    }

   

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public String toString() {
        return "Produit{" +  " libelle=" + libelle + ", image=" + image + ", prix=" + prix + ", status=" + status + ", categorie=" + categorie + ", competition=" + competition + '}';
    }

    public Produit(String libelle, String image, float prix, Statuts status, Categorie categorie, Competition competition) {
        this.libelle = libelle;
        this.image = image;
        this.prix = prix;
        this.status = status;
        this.categorie = categorie;
        this.competition = competition;
    }

    public Produit() {
    }

    @Override
    public int hashCode() {
       
        return id+image.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.competition, other.competition)) {
            return false;
        }
        return true;
    }
    
    
    
}
