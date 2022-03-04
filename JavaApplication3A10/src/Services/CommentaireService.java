/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.MaConnexion;

/**
 *
 * @author MEDIA LAC
 */
public class CommentaireService implements IService<Commentaire> {

    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void ajouter(Commentaire c) {
        String query = "INSERT INTO commentaire(id_comment,id_user,id_act,com) VALUES(?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ste.setInt(1, c.getIdComment());
            ste.setInt(2, c.getIdUser());
            ste.setInt(3, c.getIdact());
            ste.setString(4, c.getCom());

            ste.executeUpdate();
            System.out.println("Commentaire Added Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(Commentaire c) {
        String query = "UPDATE Commentaire SET id_user = " + c.getIdUser() + ", id_act = " + c.getIdact() + ", com = '"
                + c.getCom()+"' WHERE id_comment = " + c.getIdComment() + "";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("commentaire modifiee");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }  

    @Override
    public void supprimer(int id) {
        String query = "DELETE FROM commentaire WHERE id_comment = " + id + "";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("commentaire supprimer ");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Commentaire> afficher() {
        List<Commentaire> Listc = new ArrayList<>();
        String query = "SELECT *, a.id_act from commentaire as c INNER JOIN actualites as a on a.id_act=c.id_act";
        try {

            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(query);
            while (rs.next()) {
                Commentaire co = new Commentaire();
                co.setIdComment(rs.getInt("id_comment"));
                co.setIdUser(rs.getInt("id_user"));
                co.setIdact(rs.getInt("id_act"));
                co.setCom(rs.getString("com"));
                Listc.add(co);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Listc;
    }

public List<Commentaire> afficherId(int id) {
        List<Commentaire> Listc = new ArrayList<>();
        String query = "SELECT *, a.id_act from commentaire  as c INNER JOIN actualites as a on a.id_act=c.id_act where c.id_comment="+id;
        try {

            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(query);
            while (rs.next()) {
                Commentaire co = new Commentaire();
                co.setIdComment(rs.getInt("id_comment"));
                co.setIdUser(rs.getInt("id_user"));
                co.setIdact(rs.getInt("id_act"));
                co.setCom(rs.getString("com"));
                Listc.add(co);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Listc;
    }
}
