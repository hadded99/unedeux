/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.Actualites;
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
public class ActualitesService implements IService<Actualites> {

    Connection cnx = MaConnexion.getInstance().getCnx();

    @Override
    public void ajouter(Actualites a) {
        String query = "INSERT INTO actualites(id_user,titre_article,type_sport,contu_article,image,video) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ste.setInt(1, a.getIdUser());
            ste.setString(2, a.getTitreArticle());
            ste.setString(3, a.getTypeSport());
            ste.setString(4, a.getContuArticle());
            ste.setString(5, a.getImage());
            ste.setString(6, a.getVideo());
            ste.executeUpdate();
            System.out.println("actualites Added Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @return
     */
    @Override
    public List<Actualites> afficher() {
        List<Actualites> listA = new ArrayList<>();
        String query = "SELECT * FROM actualites";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(query);
            while (rs.next()) {
                Actualites act = new Actualites();
                act.setIdAct(rs.getInt("id_act"));
                act.setIdUser(rs.getInt("id_user"));
                act.setTitreArticle(rs.getString("titre_article"));
                act.setTypeSport(rs.getString("type_sport"));
                act.setContuArticle(rs.getString("contu_article"));
                act.setImage(rs.getString("image"));
                act.setVideo(rs.getString("video"));

                listA.add(act);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listA;
    }

    @Override
    public void modifier(Actualites a) {
        String query = "UPDATE actualites SET id_user = " + a.getIdUser() + ", titre_article = '"
                + a.getTitreArticle() + "', type_sport= '" + a.getTypeSport() + "', contu_article = '" + a.getContuArticle() + "', image = '"
                + a.getImage() + "', video= '" + a.getVideo()
                + "' WHERE id_act = " + a.getIdAct() + "";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Actualites modifiee");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String query = "DELETE FROM actualites WHERE id_act = " + id + "";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("actualites Deleted Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void afficher(Actualites a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Actualites> Recherchetypesport(String type_sport) {
        List<Actualites> myList = new ArrayList<Actualites>();

        try {
            String requete3 = "SELECT * From Actualites  where type_sport like '%" + type_sport + "%'";
            Statement st3 = MaConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st3.executeQuery(requete3);
            while (rs.next()) {
                Actualites p = new Actualites();
                p.setIdAct(rs.getInt("id_act"));
                p.setIdUser(rs.getInt("id_user"));
                p.setTitreArticle(rs.getString("titre_article"));
                p.setTitreArticle(rs.getString("type_sport"));
                p.setContuArticle(rs.getString("contu_article"));
                p.setImage(rs.getString("image"));
                p.setVideo(rs.getString("video"));

                myList.add(p);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myList;

    }

public List<Actualites> trierActualites(){
        List<Actualites> evenements = new ArrayList<>();
        String sql="select * from Actualites ORDER BY id_act DESC";
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
           while(rs.next()){
               Actualites e = new Actualites();
                e.setIdAct(rs.getInt("id_act"));
                e.setIdUser(rs.getInt("id_user"));
                e.setTitreArticle(rs.getString("titre_article"));
                e.setTitreArticle(rs.getString("type_sport"));
                e.setContuArticle(rs.getString("contu_article"));
                e.setImage(rs.getString("image"));
                e.setVideo(rs.getString("video"));

               evenements.add(e);
               System.out.println(e.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return evenements;
    }

    public List<Actualites> afficherId(int id) {
        List<Actualites> listA = new ArrayList<>();
        String query = "SELECT * FROM actualites where id_act="+id;
        try {
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(query);
            while (rs.next()) {
                Actualites act = new Actualites();
                act.setIdAct(rs.getInt("id_act"));
                act.setIdUser(rs.getInt("id_user"));
                act.setTitreArticle(rs.getString("titre_article"));
                act.setTypeSport(rs.getString("type_sport"));
                act.setContuArticle(rs.getString("contu_article"));
                act.setImage(rs.getString("image"));
                act.setVideo(rs.getString("video"));

                listA.add(act);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listA;
    }
    
}
