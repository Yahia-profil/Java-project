# 🎯 Application JavaFX MVC

Petit projet de gestion écrit en **Java 21**, **JavaFX 21** et **Maven**. Il illustre :
- une architecture MVC nette (models / views / controllers),
- la navigation multi-scènes via un `SceneManager`,
- un exemple de relation 1-N (classe → étudiants),
- une base de données provisoire en mémoire, prête à être remplacée par CSV ou JDBC.

<p>
  <a href="https://www.oracle.com/java/"><img src="https://img.shields.io/badge/Java-21-orange.svg" /></a>
  <a href="https://openjfx.io/"><img src="https://img.shields.io/badge/JavaFX-21-blue.svg" /></a>
  <a href="https://maven.apache.org/"><img src="https://img.shields.io/badge/Maven-3.8+-green.svg" /></a>
</p>

## ⚡ Fonctionnalités
- Interface JavaFX en FXML
- Navigation entre plusieurs vues (`SceneManager`)
- CRUD basique sur les étudiants
- Modèles reliés (classe 1-N étudiants)
- Données provisoires en mémoire / CSV

## 🧱 Structure
```
src/main/java/com/myapp/
├── Main.java
├── controllers/ (HomeController, StudentController)
├── models/ (Etudiant, Classe)
└── utils/ (SceneManager)

src/main/resources/views/
├── home.fxml
└── student_view.fxml
```

## 🧰 Prérequis
- JDK 17+ (testé avec Java 21) → https://adoptium.net/
- Maven 3.8+
- Scene Builder (optionnel mais pratique)

## 🚀 Lancement rapide
```bash
git clone https://github.com/Yahia-profil/Java-project.git
cd Java-project
mvn clean compile
mvn javafx:run
```

💡 Windows : exécutez `.\\setup-env.ps1` pour définir `JAVA_HOME` et ajouter Maven au `PATH`.

## 🕹️ Utilisation
1. Démarrez l’app (`mvn javafx:run` ou bouton Run dans votre IDE).
2. Depuis l’écran d’accueil, ouvrez « Gestion des étudiants ».
3. Utilisez le formulaire pour ajouter/modifier/supprimer un étudiant ; la TableView se met à jour automatiquement.

## 🔭 Pistes d’évolution
- Persister les données (CSV ou JDBC)
- Ajouter une couche service / DAO
- Couvrir les contrôleurs avec des tests
- Gérer plusieurs types d’entités (professeurs, matières, etc.)

## 👤 Auteur
**Toutiya Yahia** — [@Yahia-profil](https://github.com/Yahia-profil)

⭐ N’hésitez pas à donner une étoile si le projet vous aide !
