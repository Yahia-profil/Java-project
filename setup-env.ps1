# Script de configuration de l'environnement pour PowerShell
# À exécuter dans chaque nouvelle session PowerShell

# Configuration de JAVA_HOME
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.9.10-hotspot"

# Ajout de Java et Maven au PATH
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
$env:Path += ";C:\Program Files\Apache\apache-maven-3.9.11\bin"

# Vérification
Write-Host "=== Configuration de l'environnement ===" -ForegroundColor Green
Write-Host ""
Write-Host "JAVA_HOME: $env:JAVA_HOME" -ForegroundColor Cyan
Write-Host "Java version:" -ForegroundColor Cyan
java -version
Write-Host ""
Write-Host "Maven version:" -ForegroundColor Cyan
mvn -version
Write-Host ""
Write-Host "=== Configuration terminée ===" -ForegroundColor Green
Write-Host ""
Write-Host "Vous pouvez maintenant utiliser:" -ForegroundColor Yellow
Write-Host "  mvn clean compile" -ForegroundColor White
Write-Host "  mvn javafx:run" -ForegroundColor White

