package com.myapp.models;

/**
 * Classe modèle représentant un étudiant
 * Exemple de modèle avec relation (Association 1-N avec Classe)
 */
public class Etudiant {
    private String nom;
    private String prenom;
    private Classe classe; // Relation : chaque étudiant appartient à une classe

    /**
     * Constructeur par défaut
     */
    public Etudiant() {
    }

    /**
     * Constructeur avec paramètres
     * @param nom Le nom de l'étudiant
     * @param prenom Le prénom de l'étudiant
     * @param classe La classe de l'étudiant
     */
    public Etudiant(String nom, String prenom, Classe classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    /**
     * Retourne le nom complet de l'étudiant
     * @return Le nom complet (prénom + nom)
     */
    public String getNomComplet() {
        return prenom + " " + nom;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", classe=" + (classe != null ? classe.getNomClasse() : "null") +
                '}';
    }
}

