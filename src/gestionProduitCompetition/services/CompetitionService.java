/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionProduitCompetition.services;

import gestionProduitCompetition.entities.Categorie;
import gestionProduitCompetition.entities.Competition;
import gestionProduitCompetition.entities.IService;
import gestionProduitCompetition.entities.Produit;
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
public class CompetitionService implements IService<Competition>{
    
    private Connection conn;
    private PreparedStatement pst;

    public CompetitionService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void supprimerId(int id) {
        String req = "delete from competition where id=" + id;
        try {
            PreparedStatement pst = conn.prepareStatement(req);
            pst.executeUpdate(req);
            System.out.println("Competition supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouter(Competition c) {

        String req = "insert into competition (libelle,image,dateDebut,dateFin,description,resultat)  values(?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getLibelle());
             pst.setString(2, c.getImage());
             pst.setDate(3, new java.sql.Date(c.getDateDebut().getTime()));
              pst.setDate(4, new java.sql.Date(c.getDateFin().getTime()));
              pst.setString(5, c.getDescription());
              pst.setInt(6,c.getResultat());
            pst.executeUpdate();
            ResultSet generatedKeys = pst.getGeneratedKeys();

            if (generatedKeys.next()) {
                c.setId(generatedKeys.getInt(1));
            }
            System.out.println("Competition ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Competition c) {

        String req = "delete from competition where id = " + c.getId();
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Competition supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Competition c, int id) {

        String req = "update `competition` SET libelle=?,image=?,dateDebut=?,dateFin=?,description=?,resultat=? where id=" + id;
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, c.getLibelle());
             pst.setString(2, c.getImage());
             pst.setDate(3, new java.sql.Date(c.getDateDebut().getTime()));
              pst.setDate(4, new java.sql.Date(c.getDateFin().getTime()));
              pst.setString(5, c.getDescription());
              pst.setInt(6,c.getResultat());
           
            pst.executeUpdate();
            pst.close();
            System.out.println("Competition modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Competition> afficher() {
        
        
         List<Competition> LCompetition = new ArrayList<>();
        String req = " SELECT * FROM `competition` ";
        try {
            pst = conn.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
              
               Competition c = new Competition();
               c.setId(rs.getInt("id"));
               c.setLibelle(rs.getString(2));
               c.setImage(rs.getString(3));
               c.setDateDebut(rs.getDate(4));
               c.setDateFin(rs.getDate(5));
               c.setDescription(rs.getString(6));
               c.setResultat(rs.getInt(7));
              
               LCompetition.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LCompetition;
    }

       

    @Override

    public List<Competition> tri() {

      List<Competition> LCompetition = new ArrayList<>();
        String req = " SELECT * FROM `competition` order by libelle ASC";
        try {
            pst = conn.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
              
               Competition c = new Competition();
               c.setId(rs.getInt("id"));
               c.setLibelle(rs.getString(2));
              c.setImage(rs.getString(3));
              c.setDateDebut(rs.getDate(4));
                c.setDateFin(rs.getDate(5));
                c.setDescription(rs.getString(6));
                c.setResultat(rs.getInt(7));
                
               LCompetition.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LCompetition;
    }

    @Override
    public void rechercher(String libelle) {
        List<Competition> result = afficher().stream().
                filter(line -> libelle.equals(line.getLibelle())).collect(Collectors.toList());
        System.out.println("----------");
        result.forEach(System.out::println);
    }
    
}
