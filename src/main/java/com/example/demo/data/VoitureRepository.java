package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/*
  Base de données
  
  SpingData va implémnetre autmatiquement les méthode l'interface
  CrudRepository<Voiture, Integer> : Voiture est la table et Integer est 
  le type de l'identifiant

  SpringBoot implémente les méthodes CRUD : Create, Read, Updte et Delete

  L'implémentation par SpringBoot de l'interface CRUD fournis plusieurs méthodes CRUD qu'on peut
  utiliser.

  Voici les méthodes CRUD
  Méthode                                   Description
  long count()                              Retourne le nombre de tuples
  Iterable<T> findAll()                     Retourne tous les tuples du type T
  Optional<T> findById(ID id)               Retourne le tuple désigné par son id
  void delete(T entity)                     Supprime un tuple
  void deleteAll()                          Supprime tous les tuples
  <S extends T> save (S entity)             Insère un tuple
  List<S> saveAll(Iterable <S> entitities)  Insère plusieurs tuples
 */
public interface VoitureRepository extends CrudRepository<Voiture, Integer> {

    /**
     * L'implémentation de interface CrudRepository par SpringBoot permet
     * de créer des requêtes plus riches, les méthodes doivent commencer par
     * findBy
     *
     * Exemple
     * Recherche de voitures par marque
     */
    List<Voiture> findByMarque(String marque);


    /**
     * Recherche d'une voiture par son id
     * @param id
     * @return
     */
    Optional<Voiture> findById(int id);


    /**
     * Il est possible d'utiliser l'annotation @Query et
     * d'ecrire directement la requête ; cela apporte
     * plus de flexibilité pour des requêtes plus sophistiquées
     *
     * Exemple
     * Recherche des voitures sur des critères de prix
     */
    @Query("select v from Voiture v where v.prix>=?1 and v.prix<=?2")
    List<Voiture> findByVoiturePriceBetween(int prixMin, int prixMax);


}
