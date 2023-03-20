package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

/*
  Base de données
  
  SpingData va implémnetre autmatiquement les méthode l'interface
  CrudRepository<Voiture, Integer> : Voiture est la table et Integer est 
  le type de l'identifiant
 */
public interface VoitureRepository extends CrudRepository<Voiture, Integer> {
}
