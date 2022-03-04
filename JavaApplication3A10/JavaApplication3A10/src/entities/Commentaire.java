/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Commentaire {

    private int idComment , idUser,idact;
    private String com;

    public Commentaire() {
    
}

    public Commentaire(int idComment, int idUser, int idact, String com) {
        this.idComment = idComment;
        this.idUser = idUser;
        this.idact = idact;
        this.com = com;
    }

    public Commentaire(int idact, String com) {
        this.idact = idact;
        this.com = com;
    }

    public Commentaire(int idComment, int idact, String com) {
        this.idComment = idComment;
        this.idact = idact;
        this.com = com;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdact() {
        return idact;
    }

    public void setIdact(int idact) {
        this.idact = idact;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "idComment=" + idComment + ", idUser=" + idUser + ", idact=" + idact + ", com=" + com + '}';
    }

 
}
