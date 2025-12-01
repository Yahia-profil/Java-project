package com.myapp.controllers;

import com.myapp.models.Classe;
import com.myapp.models.Etudiant;
import com.myapp.utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Contrôleur pour la vue de gestion des étudiants (student_view.fxml)
 */
public class StudentController implements Initializable {

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    private ComboBox<Classe> comboClasse;

    @FXML
    private TableView<Etudiant> tableEtudiants;

    @FXML
    private TableColumn<Etudiant, String> colNom;

    @FXML
    private TableColumn<Etudiant, String> colPrenom;

    @FXML
    private TableColumn<Etudiant, String> colClasse;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnRetour;

    private ObservableList<Etudiant> listeEtudiants;
    private ObservableList<Classe> listeClasses;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialiser les listes observables
        listeEtudiants = FXCollections.observableArrayList();
        listeClasses = FXCollections.observableArrayList();

        // Configurer le ComboBox des classes
        comboClasse.setItems(listeClasses);
        
        // Ajouter quelques classes d'exemple
        listeClasses.add(new Classe("4IIR"));
        listeClasses.add(new Classe("3IIR"));
        listeClasses.add(new Classe("2IIR"));

        // Configurer la TableView
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colClasse.setCellValueFactory(cellData -> {
            Classe classe = cellData.getValue().getClasse();
            return new javafx.beans.property.SimpleStringProperty(
                classe != null ? classe.getNomClasse() : "Aucune"
            );
        });
        
        tableEtudiants.setItems(listeEtudiants);

        // Configurer les actions des boutons
        btnAjouter.setOnAction(e -> ajouterEtudiant());
        btnModifier.setOnAction(e -> modifierEtudiant());
        btnSupprimer.setOnAction(e -> supprimerEtudiant());
        btnRetour.setOnAction(e -> SceneManager.loadScene("home", "Accueil"));

        // Désactiver les boutons Modifier et Supprimer initialement
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);

        // Activer les boutons quand une ligne est sélectionnée
        tableEtudiants.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> {
                boolean itemSelected = newSelection != null;
                btnModifier.setDisable(!itemSelected);
                btnSupprimer.setDisable(!itemSelected);
                
                if (itemSelected) {
                    remplirFormulaire(newSelection);
                } else {
                    viderFormulaire();
                }
            }
        );
    }

    /**
     * Ajoute un nouvel étudiant
     */
    private void ajouterEtudiant() {
        if (validerFormulaire()) {
            Etudiant etudiant = new Etudiant(
                txtNom.getText().trim(),
                txtPrenom.getText().trim(),
                comboClasse.getValue()
            );
            
            listeEtudiants.add(etudiant);
            viderFormulaire();
            
            // Ajouter l'étudiant à sa classe
            if (etudiant.getClasse() != null) {
                etudiant.getClasse().ajouterEtudiant(etudiant);
            }
        }
    }

    /**
     * Modifie l'étudiant sélectionné
     */
    private void modifierEtudiant() {
        Etudiant etudiantSelectionne = tableEtudiants.getSelectionModel().getSelectedItem();
        if (etudiantSelectionne != null && validerFormulaire()) {
            etudiantSelectionne.setNom(txtNom.getText().trim());
            etudiantSelectionne.setPrenom(txtPrenom.getText().trim());
            
            // Gérer le changement de classe
            Classe ancienneClasse = etudiantSelectionne.getClasse();
            Classe nouvelleClasse = comboClasse.getValue();
            
            if (ancienneClasse != nouvelleClasse) {
                if (ancienneClasse != null) {
                    ancienneClasse.retirerEtudiant(etudiantSelectionne);
                }
                etudiantSelectionne.setClasse(nouvelleClasse);
                if (nouvelleClasse != null) {
                    nouvelleClasse.ajouterEtudiant(etudiantSelectionne);
                }
            }
            
            tableEtudiants.refresh();
            viderFormulaire();
        }
    }

    /**
     * Supprime l'étudiant sélectionné
     */
    private void supprimerEtudiant() {
        Etudiant etudiantSelectionne = tableEtudiants.getSelectionModel().getSelectedItem();
        if (etudiantSelectionne != null) {
            // Retirer l'étudiant de sa classe
            if (etudiantSelectionne.getClasse() != null) {
                etudiantSelectionne.getClasse().retirerEtudiant(etudiantSelectionne);
            }
            
            listeEtudiants.remove(etudiantSelectionne);
            viderFormulaire();
        }
    }

    /**
     * Remplit le formulaire avec les données de l'étudiant sélectionné
     */
    private void remplirFormulaire(Etudiant etudiant) {
        txtNom.setText(etudiant.getNom());
        txtPrenom.setText(etudiant.getPrenom());
        comboClasse.setValue(etudiant.getClasse());
    }

    /**
     * Vide le formulaire
     */
    private void viderFormulaire() {
        txtNom.clear();
        txtPrenom.clear();
        comboClasse.setValue(null);
        tableEtudiants.getSelectionModel().clearSelection();
    }

    /**
     * Valide les données du formulaire
     * @return true si le formulaire est valide, false sinon
     */
    private boolean validerFormulaire() {
        if (txtNom.getText().trim().isEmpty()) {
            afficherAlerte("Erreur", "Le nom est obligatoire");
            return false;
        }
        if (txtPrenom.getText().trim().isEmpty()) {
            afficherAlerte("Erreur", "Le prénom est obligatoire");
            return false;
        }
        if (comboClasse.getValue() == null) {
            afficherAlerte("Erreur", "Veuillez sélectionner une classe");
            return false;
        }
        return true;
    }

    /**
     * Affiche une alerte
     */
    private void afficherAlerte(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

