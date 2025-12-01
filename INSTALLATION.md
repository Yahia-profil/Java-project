# Guide d'Installation Détaillé - Projet JavaFX

## Étape par étape

### Étape 1 : Installer JDK 17 ou 21

1. **Télécharger OpenJDK** (recommandé - gratuit et open source)
   - Aller sur https://adoptium.net/
   - Choisir "JDK 17" ou "JDK 21" (LTS)
   - Sélectionner "Windows x64"
   - Télécharger le fichier `.msi`

2. **Installer JDK**
   - Exécuter le fichier `.msi` téléchargé
   - Suivre l'assistant d'installation
   - **Important** : Cocher "Set JAVA_HOME variable" et "Add to PATH" pendant l'installation

3. **Vérifier l'installation**
   ```powershell
   java -version
   javac -version
   ```
   Vous devriez voir quelque chose comme :
   ```
   openjdk version "17.0.x" ...
   ```

### Étape 2 : Installer Maven

1. **Télécharger Maven**
   - Aller sur https://maven.apache.org/download.cgi
   - Télécharger `apache-maven-3.9.x-bin.zip`

2. **Installer Maven**
   - Extraire l'archive dans `C:\Program Files\Apache\maven` (ou un autre dossier)
   - Ajouter au PATH Windows :
     - Ouvrir "Variables d'environnement" (rechercher dans le menu Démarrer)
     - Dans "Variables système", trouver "Path" et cliquer "Modifier"
     - Ajouter : `C:\Program Files\Apache\maven\bin`
     - Cliquer "OK" partout

3. **Vérifier l'installation**
   ```powershell
   mvn -version
   ```
   Vous devriez voir la version de Maven et de Java

### Étape 3 : Installer IntelliJ IDEA (Recommandé)

1. **Télécharger IntelliJ IDEA Community**
   - Aller sur https://www.jetbrains.com/idea/download/
   - Télécharger la version "Community" (gratuite)

2. **Installer IntelliJ IDEA**
   - Exécuter le fichier d'installation
   - Suivre l'assistant
   - Au premier lancement, IntelliJ détectera automatiquement JDK et Maven

3. **Configurer IntelliJ pour JavaFX**
   - Ouvrir IntelliJ IDEA
   - File → Settings → Languages & Frameworks → JavaFX
   - Vérifier que JavaFX est détecté (via Maven)

### Étape 4 : Installer Scene Builder

1. **Télécharger Scene Builder**
   - Aller sur https://gluonhq.com/products/scene-builder/
   - Télécharger la version Windows (.msi)

2. **Installer Scene Builder**
   - Exécuter le fichier `.msi`
   - Installer dans le dossier par défaut

3. **Configurer Scene Builder dans IntelliJ**
   - File → Settings → Languages & Frameworks → JavaFX
   - Dans "Path to SceneBuilder", spécifier : `C:\Program Files\SceneBuilder\SceneBuilder.exe`
   - (Ajuster le chemin selon votre installation)

### Étape 5 : Configurer le projet

1. **Ouvrir le projet dans IntelliJ**
   - File → Open
   - Sélectionner le dossier `Java-project`

2. **Synchroniser Maven**
   - IntelliJ devrait détecter automatiquement le fichier `pom.xml`
   - Si une notification apparaît, cliquer "Import Maven Project"
   - Sinon : Clic droit sur `pom.xml` → Maven → Reload Project

3. **Vérifier la structure du projet**
   - Le projet devrait avoir la structure suivante :
     ```
     Java-project/
     ├── pom.xml
     ├── src/
     │   └── main/
     │       ├── java/
     │       └── resources/
     ```

### Étape 6 : Tester l'installation

1. **Compiler le projet**
   ```powershell
   cd C:\Users\yahia\Desktop\Java-project
   mvn clean compile
   ```

2. **Lancer l'application** (une fois que Main.java sera créé)
   ```powershell
   mvn javafx:run
   ```

## Vérification finale

Exécutez ces commandes dans PowerShell pour vérifier que tout fonctionne :

```powershell
# Vérifier Java
java -version

# Vérifier Maven
mvn -version

# Vérifier que le projet compile
cd C:\Users\yahia\Desktop\Java-project
mvn clean compile
```

## Résolution de problèmes courants

### Problème : "java n'est pas reconnu"
**Solution** : Vérifier que JAVA_HOME est défini et que Java est dans le PATH

### Problème : "mvn n'est pas reconnu"
**Solution** : Vérifier que Maven est dans le PATH et redémarrer PowerShell

### Problème : IntelliJ ne détecte pas JavaFX
**Solution** : 
- File → Project Structure → Modules → Ajouter JavaFX SDK
- Ou vérifier que les dépendances Maven sont bien téléchargées

### Problème : Scene Builder ne s'ouvre pas depuis IntelliJ
**Solution** : Vérifier le chemin dans Settings → JavaFX → Path to SceneBuilder

## Prochaines étapes

Une fois l'installation terminée, vous pouvez :
1. Créer la structure de base du projet
2. Commencer à développer selon les spécifications de l'Étape 1

