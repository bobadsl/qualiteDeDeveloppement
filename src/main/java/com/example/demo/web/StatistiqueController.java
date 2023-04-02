package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

/**
 * Classe permettant d'iplémenter un Web Service RESTful
 * en utilisant la classe Controller de Spring Boot
 */



/* Permet à Spring Boot d'enregistrer cette classe comme un controleur
   comme un contrôleur de service web RESTful
 */
@RestController
public class StatistiqueController {

	/*
	  Injection de dependance de voitureRepository ;
	  Spring Boot crée une instance l'instance statistique
	
	 */
	
    @Autowired
    private Statistique statistique;

    @GetMapping(value = "/statistique")
    public Echantillon getStatistiques(){
        return statistique.prixMoyen();
    }


    @GetMapping(value = "/statistique/{id}")
    public @ResponseBody Voiture getVoitureById(@PathVariable("id") int id){
        return statistique.getVoitureById(id).get();
    }


    @PostMapping("/voiture")
    public void creerVoiture(@RequestBody Voiture voiture){
        statistique.ajouter(voiture);
    }

}
