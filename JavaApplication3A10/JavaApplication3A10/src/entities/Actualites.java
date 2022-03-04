/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.scene.control.Button;

public class Actualites {

    private int idAct, idUser;
    private String titreArticle, typeSport, contuArticle, image, video;
    private Button supprimer;

    public Actualites() {
    }

    public Actualites(int idAct, int idUser, String titreArticle, String typeSport, String contuArticle, String image, String video) {
        this.idAct = idAct;
        this.idUser = idUser;
        this.titreArticle = titreArticle;
        this.typeSport = typeSport;
        this.contuArticle = contuArticle;
        this.image = image;
        this.video = video;

    }

    public Actualites(String titreArticle, String typeSport, String contuArticle, String image, String video) {
        this.titreArticle = titreArticle;
        this.typeSport = typeSport;
        this.contuArticle = contuArticle;
        this.image = image;
        this.video = video;
    }

    public Actualites(int idAct, String titreArticle, String typeSport, String contuArticle, String image, String video) {
        this.idAct = idAct;
        this.titreArticle = titreArticle;
        this.typeSport = typeSport;
        this.contuArticle = contuArticle;
        this.image = image;
        this.video = video;

    }

    public void setSupprimer(Button supprimer) {
        this.supprimer = supprimer;
    }

    public Button getSupprimer() {
        return supprimer;
    }

    public int getIdAct() {
        return idAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitreArticle() {
        return titreArticle;
    }

    public void setTitreArticle(String titreArticle) {
        this.titreArticle = titreArticle;
    }

    public String getTypeSport() {
        return typeSport;
    }

    public void setTypeSport(String TypeSport) {
        this.typeSport = TypeSport;
    }

    public String getContuArticle() {
        return contuArticle;
    }

    public void setContuArticle(String contuArticle) {
        this.contuArticle = contuArticle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Actualites{" + "idAct=" + idAct + ", idUser=" + idUser + ", titreArticle=" + titreArticle + ", typeSport=" + typeSport + ", contuArticle=" + contuArticle + ", image=" + image + ", video=" + video + ", supprimer=" + supprimer + '}';
    }

  

}
