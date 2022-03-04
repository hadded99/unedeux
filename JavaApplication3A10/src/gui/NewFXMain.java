/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */
public class NewFXMain extends Application {
    
     private double x,y;
    @Override
    public void start(Stage primaryStage)  {
        try {
            Parent root =FXMLLoader.load(getClass().getResource("Actualite.fxml"));
            
            
            
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            
            primaryStage.initStyle (StageStyle.UNDECORATED);
            root.setOnMousePressed (event -> {
             x= event.getSceneX ();
             y= event.getSceneY();});

           root.setOnMouseDragged (event -> {
               
               primaryStage.setX(event.getScreenX()-x);
               primaryStage.setY(event.getScreenY()- y);
                          
           });
       
            
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
