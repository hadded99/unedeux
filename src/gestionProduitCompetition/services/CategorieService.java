/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionProduitCompetition.services;

import gestionProduitCompetition.entities.Categorie;
import gestionProduitCompetition.entities.IService;
import gestionProduitCompetition.entities.Produit;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import une_deux.utils.DataSource;

/**
 *
 * @author ahmed
 */
public class CategorieService implements IService<Categorie>{

     private Connection conn;
    private PreparedStatement pst;

    public CategorieService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void supprimerId(int id) {
        String req = "delete from categorie where id=" + id;
        try {
            PreparedStatement pst = conn.prepareStatement(req);
            pst.executeUpdate(req);
            System.out.println("Categorie supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouter(Categorie c) {

        String req = "insert into categorie (libelle)  values(?)";

        try {
            pst = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getLibelle());
          
            pst.executeUpdate();
            ResultSet generatedKeys = pst.getGeneratedKeys();

            if (generatedKeys.next()) {
                c.setId(generatedKeys.getInt(1));
            }
            System.out.println("Categorie ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Categorie c) {

        String req = "delete from categorie where id = " + c.getId();
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Categorie supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Categorie c, int id) {

        String req = "update `categorie` SET libelle=? where id=" + id;
        try {
            pst = conn.prepareStatement(req);
             pst.setString(1, c.getLibelle());
           
            pst.executeUpdate();
            pst.close();
            System.out.println("Categorie modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Categorie> afficher() {

        List<Categorie> LCategorie = new ArrayList<>();
        String req = " select * from `categorie`";
        try {
            pst = conn.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
              
               Categorie c = new Categorie();
               c.setId(rs.getInt("id"));
               c.setLibelle(rs.getString(2));
              
               LCategorie.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LCategorie;
    }

    @Override

    public List<Categorie> tri() {

      List<Categorie> LCategorie = new ArrayList<>();
        String req = " select * from `categorie` order by libelle ASC";
        try {
            pst = conn.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
              
               Categorie c = new Categorie();
               c.setId(rs.getInt("id"));
               c.setLibelle(rs.getString(2));
              
               LCategorie.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LCategorie;
    }

    @Override
    public void rechercher(String libelle) {
        List<Categorie> result = afficher().stream().
                filter(line -> libelle.equals(line.getLibelle())).collect(Collectors.toList());
        System.out.println("----------");
        result.forEach(System.out::println);
    }

    
}
