/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionProduitCompetition.services;
import gestionProduitCompetition.entities.Produit;
import gestionProduitCompetition.entities.IService;
import gestionProduitCompetition.entities.Categorie;
import gestionProduitCompetition.entities.Competition;
import gestionProduitCompetition.entities.Statuts;
import java.io.InputStream;
import une_deux.utils.DataSource;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author ahmed
 */
public class ProduitService implements IService<Produit>{
    
    private Connection conn;
    private PreparedStatement pst;

    public ProduitService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void supprimerId(int id) {
        String req = "delete from produit where id=" + id;
        try {
            PreparedStatement pst = conn.prepareStatement(req);
            pst.executeUpdate(req);
            System.out.println("Produit supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouter(Produit p) {

        String req = "insert into produit  (libelle,image,prix,status,idCategorie,idCompetition)"
                + " values(?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, p.getLibelle());
            pst.setString(2, p.getImage());
            pst.setFloat(3, p.getPrix());
            pst.setString(4, p.getStatus().toString());
            pst.setInt(5, p.getCategorie().getId());
            pst.setInt(6, p.getCompetition().getId());
            pst.executeUpdate();
            ResultSet generatedKeys = pst.getGeneratedKeys();

            if (generatedKeys.next()) {
                p.setId(generatedKeys.getInt(1));
            }
            System.out.println("Produit ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Produit p) {

        String req = "delete from produit where id = " + p.getId();
        try {
            pst = conn.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Produit supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Produit p, int id) {

        String req = "update `produit` SET libelle=?,image=?,prix=?,status=?,idCategorie=?,idCompetition=? where id=" + id;
        try {
            pst = conn.prepareStatement(req);
             pst.setString(1, p.getLibelle());
            pst.setString(2, p.getImage());
            pst.setFloat(3, p.getPrix());
            pst.setString(4, p.getStatus().toString());
            pst.setInt(5, p.getCategorie().getId());
            pst.setInt(6, p.getCompetition().getId());
            pst.executeUpdate();
            pst.close();
            System.out.println("Produit modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Produit> afficher() {

        List<Produit> LProduit = new ArrayList<>();
        String req = " select * from `produit`";
        try {
            pst = conn.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
               String req1 = " select * from `categorie` where id=" + rs.getInt(6);
               PreparedStatement pst1 = conn.prepareStatement(req1);
               ResultSet rss = pst1.executeQuery();
               Categorie c = new Categorie();
                if (rss.next())
                {
                InputStream stream = rss.getBinaryStream(1);
                c.setId(rss.getInt("id"));
                c.setLibelle(rss.getString(2));
                }
               Produit p = new Produit();
               p.setId(rs.getInt("id"));
               p.setLibelle(rs.getString(2));
               p.setImage(rs.getString(3));
               p.setPrix(rs.getFloat(4));
               p.setStatus(Statuts.valueOf(rs.getString(5)));
               LProduit.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LProduit;
    }

    @Override

    public List<Produit> tri() {

        List<Produit> LProduit = new ArrayList<>();
        String req = " select * from `produit` order by prix DESC";
          try {
       pst = conn.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
               String req1 = " select * from `categorie` where id=" + rs.getInt(6);
               PreparedStatement pst1 = conn.prepareStatement(req1);
               ResultSet rss = pst1.executeQuery();
               Categorie c = new Categorie();
                if (rss.next())
                {
                InputStream stream = rss.getBinaryStream(1);
                c.setId(rss.getInt("id"));
                c.setLibelle(rss.getString(2));
                }
               Produit p = new Produit();
               p.setId(rs.getInt("id"));
               p.setLibelle(rs.getString(2));
               p.setImage(rs.getString(3));
               p.setPrix(rs.getFloat(4));
               p.setStatus(Statuts.valueOf(rs.getString(5)));
               LProduit.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LProduit;
    }

    @Override
    public void rechercher(String libelle) {
        List<Produit> result = afficher().stream().
                filter(line -> libelle.equals(line.getLibelle())).collect(Collectors.toList());
        System.out.println("----------");
        result.forEach(System.out::println);
    }

   
    
}
