/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Services.ActualitesService;
import Services.CommentaireService;
import entities.Actualites;
import entities.Commentaire;
import tools.MaConnexion;

/**
 *
 * @author Fayechi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaConnexion mc = MaConnexion.getInstance();
        Actualites a = new Actualites( 2, "qq", "dj944yyt899id", "xxxuyuyhxx", "fllll", "j8jjjjj");
        Commentaire c = new Commentaire(5, 20, 8, "vv3vv");
        Commentaire c2 = new Commentaire(8, 6, 9, "aa");

        ActualitesService as = new ActualitesService();
        CommentaireService cs = new CommentaireService();
        Actualites p = new Actualites();
        //cs.ajouter(c2);

        //as.trierActualites();
        // cs.ajouter(c2);
        cs.modifier(c2);
        //as.ajouter(a);
        //as.supprimer(a);
        //cs.modifier(c2);
        //cs.supprimer(c2);
        //p.Recherchetypesport();
        //System.out.println(as.afficher());
        //System.out.println(as.Recherchetypesport("dj9yyt899id"));
        //System.out.println(as.afficher());
        //as.supprimer(a);
        System.out.println(as.afficher());
    }

}
