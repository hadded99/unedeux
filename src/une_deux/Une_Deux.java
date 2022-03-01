/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package une_deux;

import gestionProduitCompetition.entities.Categorie;
import gestionProduitCompetition.entities.Competition;
import gestionProduitCompetition.entities.Produit;
import gestionProduitCompetition.entities.Statuts;
import gestionProduitCompetition.services.CategorieService;
import gestionProduitCompetition.services.CompetitionService;
import gestionProduitCompetition.services.ProduitService;
import gestionUser.entites.Reclamation;
import gestionUser.services.ReclamationService;
import gestionUser.entites.Role;
import gestionUser.entites.Utilisateur;
import gestionUser.services.UtilisateurService;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javafx.animation.Animation.Status;

/**
 *
 * @author ahmed
 */
public class Une_Deux {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        //Date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = format.parse("2022-02-18");
        Date dateFin = format.parse("2022-02-19");
        Date dateDebut1 = format.parse("2022-04-28");
        Date dateFin1 = format.parse("2022-05-10");
        Date dateDebut2 = format.parse("2022-06-28");
        Date dateFin2 = format.parse("2022-08-10");

        //Categorie
        System.out.println("LISTE DES CATEGORIES");
        System.out.println("\n");
        Categorie c = new Categorie("chaussures");
        Categorie c1 = new Categorie("pulls");
        Categorie c2 = new Categorie("chaussettes");
        Categorie c3 = new Categorie("vestes");
        CategorieService categorieService = new CategorieService();

        categorieService.ajouter(c);
        categorieService.ajouter(c1);
        categorieService.ajouter(c2);
        categorieService.ajouter(c3);
        System.out.println(c3.getId());
        System.out.println(categorieService.afficher());
        categorieService.modifier(c, 60);
        categorieService.supprimer(c3);

        System.out.println(categorieService.afficher());

        System.out.println(categorieService.afficher());
        System.out.println(categorieService.tri());
        categorieService.rechercher("chaussures");

        System.out.println("\n");

        //Compettion
        System.out.println("LISTE DES COMPETITIONS");
        System.out.println("\n");
        Competition cmp = new Competition("day1", "image1", dateDebut, dateFin, "voilà la description", 0);
        Competition cmp1 = new Competition("day2", "image2", dateDebut1, dateFin1, "voilà la description1", 0);
        Competition cmp2 = new Competition("day3", "image3", dateDebut2, dateFin2, "voilà la description2", 0);
        Competition cmp3 = new Competition("day3", "image3", dateDebut2, dateFin2, "voilà la description2", 0);
        CompetitionService competitionService = new CompetitionService();
        competitionService.ajouter(cmp);
        competitionService.ajouter(cmp1);
        competitionService.ajouter(cmp2);
        competitionService.ajouter(cmp3);
        System.out.println(competitionService.afficher());
        competitionService.modifier(cmp, 4);
        competitionService.supprimer(cmp3);

        System.out.println(competitionService.afficher());
        System.out.println(competitionService.tri());
        competitionService.rechercher("day1");
        System.out.println("\n");

        //Produit
        System.out.println("LISTE DES PRODUITS");
        System.out.println("\n");
        Produit p = new Produit("nike", "imageP", 210, Statuts.disponible, c, cmp);
        Produit p1 = new Produit("adidas", "imageP1", 280, Statuts.disponible, c1, cmp1);
        Produit p2 = new Produit("nike", "imageP", 210, Statuts.disponible, c2, cmp2);

        ProduitService produitService = new ProduitService();
        produitService.ajouter(p);
        produitService.ajouter(p1);
        produitService.ajouter(p2);
        System.out.println(produitService.afficher());
        // produitService.modifier(p, 2);
        System.out.println(produitService.afficher());
        //  produitService.supprimer(p);
        produitService.ajouter(p);
        System.out.println(produitService.tri());
        produitService.rechercher("nike");

        System.out.println("\n");

        UtilisateurService us = new UtilisateurService();
        System.out.println(us.afficher());
        
       Utilisateur u1 = new Utilisateur(1, "sofien", "mazlout", "sofien@gmail.com", dateDebut1, 12346, "aaa", "bb","eee",Role.ADMIN);
       us.ajouter(u1);
    }

}
