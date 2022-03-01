/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionProduitCompetition.entities;

import java.util.*;

/**
 *
 * @author ahmed
 */
public interface IService <T>{
    
    void supprimerId(int id);
    void ajouter(T entity);
    void supprimer(T entity);
    void modifier(T entity,int id);
    List<T> afficher();
    List<T> tri();
    void rechercher(String mot );
    
    
}
