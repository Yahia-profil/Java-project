package com.myapp.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Gestionnaire centralisé des scènes JavaFX
 * Permet de naviguer facilement entre les différentes vues de l'application
 */
public class SceneManager {
    private static Stage primaryStage;
    private static final String VIEWS_PATH = "/views/";

    /**
     * Définit la fenêtre principale de l'application
     * @param stage La fenêtre principale
     */
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    /**
     * Charge une scène FXML et l'affiche dans la fenêtre principale
     * @param fxmlName Le nom du fichier FXML (sans l'extension .fxml)
     * @param title Le titre de la fenêtre
     */
    public static void loadScene(String fxmlName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource(VIEWS_PATH + fxmlName + ".fxml")
            );
            
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de la scène : " + fxmlName);
            e.printStackTrace();
        }
    }

    /**
     * Charge une scène FXML avec une taille spécifique
     * @param fxmlName Le nom du fichier FXML (sans l'extension .fxml)
     * @param title Le titre de la fenêtre
     * @param width La largeur de la fenêtre
     * @param height La hauteur de la fenêtre
     */
    public static void loadScene(String fxmlName, String title, double width, double height) {
        try {
            FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource(VIEWS_PATH + fxmlName + ".fxml")
            );
            
            Scene scene = new Scene(loader.load(), width, height);
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de la scène : " + fxmlName);
            e.printStackTrace();
        }
    }

    /**
     * Retourne la fenêtre principale
     * @return La fenêtre principale
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}

