package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* Permet à Spring Boot d'enregistrer cette classe comme un controleur
   qui permettre de gérer les requêts
 */
@RestController
public class StatistiqueController {

	/*
	  Injection de dependance de voitureRepository ;
	  Spring Boot crée une instance l'instance statistique
	
	 */
	
    @Autowired
    Statistique statistique;

    @GetMapping(value = "/statistique")
    public Echantillon getStatistiques(){
        return statistique.prixMoyen();
    }

    @PostMapping("/voiture")
    public void creerVoiture(@RequestBody Voiture voiture){
        statistique.ajouter(voiture);
    }

}
