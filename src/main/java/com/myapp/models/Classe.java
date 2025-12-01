package com.myapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe modèle représentant une classe
 * Exemple de modèle avec relation (Association 1-N avec Etudiant)
 */
public class Classe {
    private String nomClasse;
    private List<Etudiant> etudiants = new ArrayList<>();

    /**
     * Constructeur par défaut
     */
    public Classe() {
    }

    /**
     * Constructeur avec paramètres
     * @param nomClasse Le nom de la classe
     */
    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    // Getters et Setters
    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    /**
     * Ajoute un étudiant à la classe
     * @param e L'étudiant à ajouter
     */
    public void ajouterEtudiant(Etudiant e) {
        if (e != null) {
            etudiants.add(e);
            e.setClasse(this); // Maintenir la cohérence de la relation
        }
    }

    /**
     * Retire un étudiant de la classe
     * @param e L'étudiant à retirer
     */
    public void retirerEtudiant(Etudiant e) {
        if (e != null) {
            etudiants.remove(e);
            e.setClasse(null);
        }
    }

    /**
     * Retourne le nombre d'étudiants dans la classe
     * @return Le nombre d'étudiants
     */
    public int getNombreEtudiants() {
        return etudiants.size();
    }

    @Override
    public String toString() {
        return "Classe{" +
                "nomClasse='" + nomClasse + '\'' +
                ", nombreEtudiants=" + etudiants.size() +
                '}';
    }
}

