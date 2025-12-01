package com.myapp;

import com.myapp.utils.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Classe principale de l'application JavaFX
 * Point d'entrée de l'application
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialiser le gestionnaire de scènes
        SceneManager.setPrimaryStage(primaryStage);
        
        // Charger la scène d'accueil
        SceneManager.loadScene("home", "Accueil");
        
        // Afficher la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

