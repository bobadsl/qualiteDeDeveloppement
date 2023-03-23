package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

/*
  Base de données
  
  SpingData va implémnter autmatiquement les méthode l'interface
  CrudRepository<Voiture, Integer> : Voiture est la table et Integer est 
  le type de l'identifiant

  CRUD : Opérations  Create, Read, Update et Delete dans une base de données

 */
public interface VoitureRepository extends CrudRepository<Voiture, Integer> {
}
