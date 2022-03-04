/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.ActualitesService;
import entities.Actualites;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MEDIA LAC
 */
public class ActualiteController implements Initializable {

    @FXML
    private TableView<Actualites> tableActualite;
    @FXML
    private TableColumn<Actualites,String> TITRE;
    @FXML
    private TableColumn<Actualites,String> TYPE;
    @FXML
    private TableColumn<Actualites,String> CONTENU;
    @FXML
    private TableColumn<Actualites,String> IMAGE;
    @FXML
    private TableColumn<Actualites,String> VIDEO;
      @FXML
    private TableColumn<Actualites,Integer> ID;
       @FXML
    private TableColumn<Actualites,Button> SUPPRIMER;
        @FXML
    private TextField TITREA;

    @FXML
    private TextField TYPEA;

    @FXML
    private TextField IMAGEA;

    @FXML
    private TextField VIDEOA;

    @FXML
    private TextArea CONTENUA;
     @FXML
    private TextField TITREA1;

    @FXML
    private TextField TYPEA1;

    @FXML
    private TextField IMAGEA1;

    @FXML
    private TextField VIDEOA1;

    @FXML
    private TextArea CONTENUA1;
       @FXML
               private TextField ids;
       @FXML
               private TextField idm;
      
        Button[] supprimerb = new Button[100];
        int index=101; 
         @FXML    
 private void load (ActionEvent event)
    {
        ActualitesService sc = new ActualitesService();
        int idd= Integer.parseInt(idm.getText());
        List<Actualites> l =sc.afficherId(idd);
         TYPEA1.setText(l.get(0).getTypeSport());
        TITREA1.setText(l.get(0).getTitreArticle());
        CONTENUA1.setText(l.get(0).getContuArticle());
        IMAGEA1.setText(l.get(0).getImage());
        VIDEOA1.setText(l.get(0).getVideo());
        
        
        
      
    }
  @FXML    
 private void modifierAct (ActionEvent event)
    {
        int idd= Integer.parseInt(idm.getText());
        String type = TYPEA1.getText();
        String titre = TITREA1.getText();
        String contenu = CONTENUA1.getText();
        String image = IMAGEA1.getText();
        String video = VIDEOA1.getText();
        Actualites a = new Actualites(idd,titre,type,contenu,image,video);
        System.out.println(a);
        ActualitesService sc = new ActualitesService();
        
         ActualitesService tt = new ActualitesService();
            
            sc.modifier(a);
             lt = tt.afficher();
             tableActualite.getItems().clear();
          afficher_tournoi(lt);
    }
  @FXML    
 private void ajouterAct (ActionEvent event)
    {
        String type = TYPEA.getText();
        String titre = TITREA.getText();
        String contenu = CONTENUA.getText();
        String image = IMAGEA.getText();
        String video = VIDEOA.getText();
        Actualites a = new Actualites(titre,type,contenu,image,video);
        ActualitesService sc = new ActualitesService();
        
         ActualitesService tt = new ActualitesService();
            
            sc.ajouter(a);
             lt = tt.afficher();
             tableActualite.getItems().clear();
          afficher_tournoi(lt);
    }
        
         @FXML    
 private void handleButtonAction (ActionEvent event)
    {
       
        
            
                 index= Integer.parseInt(ids.getText());
         
          System.out.println(index);
         
            ActualitesService tt = new ActualitesService();
            
             tt.supprimer(index);
             lt = tt.afficher();
             tableActualite.getItems().clear();
          afficher_tournoi(lt);
          
       
     }
    /**
     * Initializes the controller class.
     */
    ActualitesService s = new ActualitesService();
    List<Actualites> lt =s.afficher();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
      ObservableList<Actualites> datalist = FXCollections.observableArrayList(lt);
        System.out.println(lt);
          TITRE.setCellValueFactory(new PropertyValueFactory<>("titreArticle"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("typeSport"));
        CONTENU.setCellValueFactory(new PropertyValueFactory<>("contuArticle"));
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("image"));
        VIDEO.setCellValueFactory(new PropertyValueFactory<>("video"));
        ID.setCellValueFactory(new PropertyValueFactory<>("idAct"));
//        SUPPRIMER.setCellFactory(new PropertyValueFactory<>("supprimer"));
       

        tableActualite.setItems(datalist);

    }    
      public void afficher_tournoi(List<Actualites> ltt)
    {
     
      ObservableList<Actualites> datalist = FXCollections.observableArrayList(ltt);
     
          TITRE.setCellValueFactory(new PropertyValueFactory<>("titreArticle"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("typeSport"));
        CONTENU.setCellValueFactory(new PropertyValueFactory<>("contuArticle"));
        IMAGE.setCellValueFactory(new PropertyValueFactory<>("image"));
        VIDEO.setCellValueFactory(new PropertyValueFactory<>("video"));
        ID.setCellValueFactory(new PropertyValueFactory<>("idAct"));
      
       
tableActualite.setItems(datalist);
    }

}
