package com.myapp.controllers;

import com.myapp.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Contrôleur pour la vue d'accueil (home.fxml)
 */
public class HomeController implements Initializable {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button btnGestionEtudiants;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialisation de la vue
        welcomeLabel.setText("Bienvenue dans l'application de gestion");
        
        // Configuration des actions des boutons
        btnGestionEtudiants.setOnAction(e -> {
            // Navigation vers la vue de gestion des étudiants
            SceneManager.loadScene("student_view", "Gestion des étudiants");
        });
    }
}

