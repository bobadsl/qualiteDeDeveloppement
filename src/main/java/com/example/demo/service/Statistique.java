package com.example.demo.service;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// la classe Statistique est une bean de service

@Service
public class Statistique {

	/*
	  Injection de dependance de voitureRepository ;
	  Spring Boot crée une instance l'instance voitureRepository
	  qui permet d'avoir accès à la couche DAO (services fournis
	  par l'implémentation de Spring de CrudRepository
	 */
    @Autowired
    VoitureRepository voitureRepository;

    public void ajouter(Voiture voiture) {
        voitureRepository.save(voiture);
    }

    public Echantillon prixMoyen(){
        int prixTotal = 0;
        int nombreDeVoitures = 0;
        Iterator<Voiture> voitures = voitureRepository.findAll().iterator();
        while(voitures.hasNext()){
            prixTotal = prixTotal + voitures.next().getPrix();
            nombreDeVoitures++;
        }
        return new Echantillon(nombreDeVoitures, prixTotal/nombreDeVoitures);
    }


}
