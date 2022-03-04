/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.ActualitesService;
import Services.CommentaireService;
import entities.Actualites;
import entities.Commentaire;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author MEDIA LAC
 */
public class CommentaireController implements Initializable {

    @FXML
    private TableView<Commentaire> tableCommentaire;
   
    @FXML
    private TableColumn<Commentaire,String> CONTENU;
     @FXML
    private TableColumn<Commentaire,Integer> ID;
       @FXML
    private TableColumn<Commentaire,Integer> IDA;
    
   

    @FXML
    private TextArea CONTENUA;
     @FXML
    private TextField IDAA;
   

    @FXML
    private TextArea CONTENUA1;
    @FXML
    private TextField IDAAA;
       @FXML
               private TextField ids;
       @FXML
               private TextField idm;
      
        Button[] supprimerb = new Button[100];
        int index=101; 
         @FXML    
 private void load (ActionEvent event)
    {
        CommentaireService sc = new CommentaireService();
        int idd= Integer.parseInt(idm.getText());
        List<Commentaire> l =sc.afficherId(idd);
        IDAAA.setText(String.valueOf(l.get(0).getIdact()));
        CONTENUA1.setText(l.get(0).getCom());
       
        
        
        
      
    }
  @FXML    
 private void modifierAct (ActionEvent event)
    {
        int idd= Integer.parseInt(idm.getText());
       int idA= Integer.parseInt(IDAAA.getText());
       CommentaireService sc = new CommentaireService();
      
        List<Commentaire> l =sc.afficherId(idd);
        String contenu = CONTENUA1.getText();
        
        Commentaire a = new Commentaire(idd,l.get(0).getIdUser(),idA,contenu);
        System.out.println(a);
      
        
         CommentaireService tt = new CommentaireService();
            
            sc.modifier(a);
             lt = tt.afficher();
             tableCommentaire.getItems().clear();
          afficher_tournoi(lt);
    }
  @FXML    
 private void ajouterAct (ActionEvent event)
    {
       
        String contenu = CONTENUA.getText();
        int idA= Integer.parseInt(IDAA.getText());
        Commentaire a = new Commentaire(idA,contenu);
        CommentaireService sc = new CommentaireService();
        
         CommentaireService tt = new CommentaireService();
            
            sc.ajouter(a);
             lt = tt.afficher();
             tableCommentaire.getItems().clear();
          afficher_tournoi(lt);
    }
        
         @FXML    
 private void handleButtonAction (ActionEvent event)
    {
       
        
            
                 index= Integer.parseInt(ids.getText());
         
          System.out.println(index);
         
           CommentaireService tt = new CommentaireService();
            
             tt.supprimer(index);
             lt = tt.afficher();
             tableCommentaire.getItems().clear();
          afficher_tournoi(lt);
          
       
     }
    /**
     * Initializes the controller class.
     */
    CommentaireService s = new CommentaireService();
    List<Commentaire> lt =s.afficher();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
      ObservableList<Commentaire> datalist = FXCollections.observableArrayList(lt);
        System.out.println(lt);
         IDA.setCellValueFactory(new PropertyValueFactory<>("idact"));
        CONTENU.setCellValueFactory(new PropertyValueFactory<>("com"));
        ID.setCellValueFactory(new PropertyValueFactory<>("idComment"));
//        SUPPRIMER.setCellFactory(new PropertyValueFactory<>("supprimer"));
       

        tableCommentaire.setItems(datalist);

    }    
      public void afficher_tournoi(List<Commentaire> ltt)
    {
     
      ObservableList<Commentaire> datalist = FXCollections.observableArrayList(ltt);
     
         
        CONTENU.setCellValueFactory(new PropertyValueFactory<>("com"));
       IDA.setCellValueFactory(new PropertyValueFactory<>("idact"));
        ID.setCellValueFactory(new PropertyValueFactory<>("idComment"));
      
       
tableCommentaire.setItems(datalist);
    }
 
    
}
