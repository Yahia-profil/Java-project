# 📚 Projet JavaFX - Application de Gestion

> Application JavaFX développée avec une architecture MVC modulaire pour la gestion de données.

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-blue.svg)](https://openjfx.io/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-green.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 Description

Ce projet est une application JavaFX structurée suivant les principes de l'architecture MVC (Modèle-Vue-Contrôleur). Il démontre une séparation claire entre :

- **Vue** : Interfaces utilisateur créées avec JavaFX et FXML
- **Contrôleur** : Logique de gestion des interactions utilisateur
- **Modèle** : Représentation des données métier
- **Services** : Logique métier (à venir)
- **DAO** : Accès aux données via fichiers CSV (provisoire) puis JDBC

## ✨ Fonctionnalités

- ✅ Interface graphique moderne avec JavaFX
- ✅ Navigation entre plusieurs scènes
- ✅ Gestion CRUD complète (Create, Read, Update, Delete)
- ✅ Relations entre modèles (Association 1-N)
- ✅ Architecture modulaire et maintenable
- ✅ Gestion de données via fichiers CSV (base provisoire)

## 🏗️ Architecture du projet

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── myapp/
│   │           ├── Main.java              # Point d'entrée
│   │           ├── controllers/           # Contrôleurs MVC
│   │           │   ├── HomeController.java
│   │           │   └── StudentController.java
│   │           ├── models/                # Modèles de données
│   │           │   ├── Etudiant.java
│   │           │   └── Classe.java
│   │           └── utils/                 # Utilitaires
│   │               └── SceneManager.java
│   └── resources/
│       └── views/                         # Fichiers FXML
│           ├── home.fxml
│           └── student_view.fxml
```

## 🚀 Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- **JDK 17 ou 21** (LTS recommandé)
  - [Télécharger OpenJDK](https://adoptium.net/)
- **Maven 3.8+**
  - [Télécharger Maven](https://maven.apache.org/download.cgi)
- **IDE** (optionnel mais recommandé)
  - IntelliJ IDEA, Eclipse, ou VS Code avec extensions Java

## 📦 Installation

### 1. Cloner le dépôt

```bash
git clone https://github.com/Yahia-profil/Java-project.git
cd Java-project
```

### 2. Configurer l'environnement

#### Windows (PowerShell)

Exécutez le script de configuration :

```powershell
.\setup-env.ps1
```

Ou configurez manuellement :

```powershell
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot"
$env:Path += ";C:\Program Files\Apache\apache-maven-3.9.11\bin"
```

#### Linux/Mac

```bash
export JAVA_HOME=/path/to/jdk
export PATH=$PATH:/path/to/maven/bin
```

### 3. Vérifier l'installation

```bash
java -version
mvn -version
```

### 4. Compiler le projet

```bash
mvn clean compile
```

## 🎮 Utilisation

### Lancer l'application

```bash
mvn javafx:run
```

Ou depuis votre IDE :
- Exécutez la classe `com.myapp.Main`
- Cliquez sur le bouton "Run" dans votre IDE

### Utilisation de l'interface

1. **Page d'accueil** : Cliquez sur "Gestion des Étudiants"
2. **Ajouter un étudiant** : Remplissez le formulaire et cliquez sur "Ajouter"
3. **Modifier un étudiant** : Sélectionnez une ligne du tableau, modifiez les champs, puis cliquez sur "Modifier"
4. **Supprimer un étudiant** : Sélectionnez une ligne et cliquez sur "Supprimer"

## 🛠️ Technologies utilisées

- **Java 21** - Langage de programmation
- **JavaFX 21** - Framework d'interface graphique
- **Maven** - Gestionnaire de dépendances et build
- **OpenCSV** - Gestion des fichiers CSV
- **FXML** - Format de description d'interface JavaFX

## 📚 Structure des dépendances

Le projet utilise les dépendances suivantes (gérées par Maven) :

```xml
- JavaFX Controls 21
- JavaFX FXML 21
- OpenCSV 5.9
```

## 🔧 Développement

### Structure MVC

- **Models** (`models/`) : Classes représentant les entités métier
- **Views** (`resources/views/`) : Fichiers FXML définissant l'interface
- **Controllers** (`controllers/`) : Classes gérant les interactions

### Ajouter une nouvelle vue

1. Créer un fichier `.fxml` dans `src/main/resources/views/`
2. Créer le contrôleur correspondant dans `controllers/`
3. Utiliser `SceneManager.loadScene()` pour naviguer

### Exemple de code

```java
// Navigation vers une nouvelle scène
SceneManager.loadScene("student_view", "Gestion des étudiants");

// Création d'un modèle
Etudiant etudiant = new Etudiant("Dupont", "Jean", classe);
```

## 📝 Prochaines étapes

- [ ] Implémentation de la couche Service
- [ ] Migration vers JDBC (remplacement des fichiers CSV)
- [ ] Ajout de tests unitaires
- [ ] Amélioration de la gestion des erreurs
- [ ] Documentation API

## 🤝 Contribution

Les contributions sont les bienvenues ! Pour contribuer :

1. Fork le projet
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Committez vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## 👨‍💻 Auteur

**Votre Nom**
- GitHub: [@votre-username](https://github.com/votre-username)

## 🙏 Remerciements

- [OpenJFX](https://openjfx.io/) pour le framework JavaFX
- [Apache Maven](https://maven.apache.org/) pour l'outil de build
- [OpenCSV](http://opencsv.sourceforge.net/) pour la gestion CSV

## 📞 Support

Pour toute question ou problème :

- Ouvrez une [issue](https://github.com/votre-username/Java-project/issues)
- Consultez la [documentation](https://github.com/votre-username/Java-project/wiki)

---

⭐ Si ce projet vous a été utile, n'hésitez pas à lui donner une étoile !
