/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionUser.services;

import gestionProduitCompetition.entities.Competition;
import une_deux.utils.DataSource;
import gestionProduitCompetition.entities.IService;
import gestionUser.entites.Role;
import gestionUser.entites.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mahdi
 */
public class UtilisateurService implements IService<Utilisateur> {

    private Connection conn;
    private PreparedStatement pst;
    private Statement ste;

    public UtilisateurService() {
        conn = DataSource.getInstance().getCnx();

    }

    @Override
    public void ajouter(Utilisateur user) {

        String req = "INSERT INTO `user` (`nom`,`prenom`,`email`,`dateNaissance`,`numTel`,`ville`,`login`,`mdp`,`role`) VALUES (?,?,?,?,?,?,?,?,?)";

        try {

            pst = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(3, user.getEmail());
            pst.setDate(4, new java.sql.Date(user.getDateNaissance().getTime()));
            pst.setInt(5, user.getNumTel());
            pst.setString(6, user.getVille());
            pst.setString(7, user.getLogin());
            pst.setString(8, user.getMdp());
            pst.setString(9, user.getRole().toString());
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();

            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
            System.out.println("utilisateur ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Utilisateur user) {
        try {
            PreparedStatement pre = conn.prepareStatement("Delete from user where id=? ;");
            pre.setInt(1, user.getId());
            if (pre.executeUpdate() != 0) {
                System.out.println("user Deleted");

            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void modifier(Utilisateur user) {
        String req;

        req = "UPDATE `user` SET `nom`=?,`prenom`=?,`email`=?,`dateDeNaissance`=?,`numTel`=?,`ville`=?,`login`=? ,`mdp`=? ,`role`=? WHERE id =?";

        try {
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getEmail());
            ps.setDate(4, new java.sql.Date(user.getDateNaissance().getTime()));
            ps.setInt(5, user.getNumTel());
            ps.setString(6, user.getVille());
            ps.setString(7, user.getLogin());
            ps.setString(8, user.getMdp());
            ps.setString(9, user.getRole().toString());
            ps.setInt(10, user.getId());
            ps.executeUpdate();
            System.out.println("utilisateur modifié");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Utilisateur> afficher() {
        List<Utilisateur> utilisateurs = new ArrayList<>();

        String req = "SELECT * from `user`";

        try {
            pst = conn.prepareStatement(req);
            ResultSet us = pst.executeQuery();

            while (us.next()) {
                Utilisateur user = new Utilisateur();
                user.setId(us.getInt("id"));
                user.setNom(us.getString(2));
                user.setPrenom(us.getString(3));
                user.setEmail(us.getString(4));
                user.setDateNaissance(us.getDate(5));
                user.setNumTel(us.getInt(6));
                user.setVille(us.getString(7));
                user.setLogin(us.getString(8));
                user.setMdp(us.getString(9));
                user.setRole(Role.valueOf(us.getString(10)));

                utilisateurs.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public void supprimerId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Utilisateur entity, int id) {
        String req = "update `user` SET nom=?,prenom=?,email=?,dateNaissance=?,numTel=?,ville=?=?,login=?,mdp=?,role=? where id=" + id;
        try {
            pst = conn.prepareStatement(req);
            pst.setString(1, entity.getNom());
            pst.setString(2, entity.getPrenom());
            pst.setString(3, entity.getEmail());
            pst.setDate(4, new java.sql.Date(entity.getDateNaissance().getTime()));
            
            pst.setInt(5, entity.getNumTel());
            pst.setString(6, entity.getVille());
            pst.setString(7, entity.getLogin());
            pst.setString(8, entity.getMdp());
            pst.setString(9, entity.getRole().toString());

            pst.executeUpdate();
            pst.close();
            System.out.println("Competition modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        @Override

    public List<Utilisateur> tri() {

      List<Utilisateur> LUtilisateur = new ArrayList<>();
        String req = " SELECT * FROM `user` order by nom ASC";
        try {
            pst = conn.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
              
               Utilisateur u = new Utilisateur();
               u.setId(rs.getInt("id"));
               u.setNom(rs.getString(2));
              u.setPrenom(rs.getString(3));
              u.setEmail(rs.getString(4));
                u.setDateNaissance(rs.getDate(5));
                u.setNumTel(rs.getInt(6));
                u.setVille(rs.getString(7));
                 u.setLogin(rs.getString(7));
                 u.setMdp(rs.getString(7));
                
               LUtilisateur.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return LUtilisateur;
    }

    @Override
    public void rechercher(String nom) {
        List<Utilisateur> result = afficher().stream().
                filter(line -> nom.equals(line.getNom())).collect(Collectors.toList());
        System.out.println("----------");
        result.forEach(System.out::println);
    }
}
