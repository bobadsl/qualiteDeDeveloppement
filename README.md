# Qualité de développement

Le but de ce cours est de faire des tests d'intégration au fur et à mesure que des nouveaux composants sont intégrés dans une apllication 
tout en vérifiant que les tests précédents continuent de passer sans relever d'erreur. 
On appelle cela des tests de non regression.

# Présentation de l'application

L'application à développer contient : 

- une base de données.
- un service Web

L'application est programmée en Java avec le framework Spring Boot (pour faciliter l'accès à la base de données ainsi 
que le développement du service web).

Le but de l'application est de faire des statistiques sur des voitures.

# Récupération du projet 

```
git clone https://github.com/charroux/qualiteDeDeveloppement
```

# Configuration de l'application

A l'IUT, le traffic réseau passe par un proxy. Il faut donc décommenter le fichier de configuration : 

https://github.com/charroux/qualiteDeDeveloppement/blob/main/gradle.properties

# Le code 

## La classe Voiture

https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/data/Voiture.java

## La classe qui calcule les statistiques et les enregistrent dans la base de données

Cette classe permet de calculer le prix moyen d'un ensemble de voitures au fur et à mesure qu'on ajoute des voitures.

https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/service/Statistique.java

## La clase qui expose le calcule des statistiques sur le Web

Cette classe permet tout simplement d'ajouter une voiture via un HTTP POST et de récupérer le prix moyen des voitures via un HTTP GET grâce à l'appel du service.

https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/web/StatistiqueController.java

# Test de l'application via des requettes HTTP

Lancer le programme principal : https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/main/java/com/example/demo/DemoApplication.java

La base de données est HSQLDB. Elle s'exécute "En mémoire" pour ne pas avoir à démarrer un serveur de base de données tant qu'on est en mode développement.
En conséquence, les données sont perdues dès que l'application s'arrête.

Ajouter une voiture en ligne de commande avec cURL (sous Linux) : 

```
curl --header "Content-Type: application/json" --request POST --data '{"marque":"Ferrari","prix":1000}' http://localhost:8080/voiture
```

Obtenir les statistiques : 

```
curl --request GET http://localhost:8080/statistique
```

# Programmes de test

## Tests unitaires de la classe Voiture

https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/test/java/com/example/demo/data/VoitureTest.java

## Tests unitaires de l'accès à la base de données

https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/test/java/com/example/demo/data/BaseDeDonneesTests.java

## Tests de la classe de service qui intègre la base de données

https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/test/java/com/example/demo/service/ServiceTests.java

## Tests de la classe de service Web qui intègre le service

https://github.com/charroux/qualiteDeDeveloppement/blob/main/src/test/java/com/example/demo/web/WebTests.java

# Lancement des tests

## Via Eclipse

## Via Intellij

## En ligne de commande

Sous Linux :

```
./gradlew build
```

Sous Windows : 

```
gradle build
```

Consulter le rapport de test : build/reports/tests/test/index.html
