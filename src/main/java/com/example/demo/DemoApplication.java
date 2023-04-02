package com.example.demo;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;

/**
 * Permet d'insérer du code avant l'éxécution
 * complète de l'application SpringBoot
 *
 * Par exemple pour insérer des tuples dans la base de donnée
 * Pour cela il faut redéfinir la méthode run
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;

/* Point d'entrée de l'application
 * doit-être à la racine du package pour permettre
 * a Spring Boot de scanner le package courant et les
 * sous-package
 */


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private VoitureRepository voitureRepository;

	private static final Logger logger =
			LoggerFactory.getLogger(VoitureRepository.class);


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	/**
	 * Implémentation de l'interface CommandLineRunner
	 *
	 * Permet d'exécuter des instructions avant le lancement
	 * complet d el'application
	 */
	@Override
	public void run(String... args) throws Exception {
		voitureRepository.save(new Voiture("Ford", 59000));
		voitureRepository.save(new Voiture("Nissan", 29000));
		voitureRepository.save(new Voiture("Toyota", 39000));
		voitureRepository.save(new Voiture("Ford", 21000));

		/**
		 * Parcours de toutes les voitures de la base de données pour
		 * les afficher dans le logs
		 */

		for (Voiture v : voitureRepository.findAll()) {
			logger.info(v.getMarque() + " " + v.getPrix());
		}

		/**
		 * Parcours de voitures de marque Ford
		 */

		for (Voiture v : voitureRepository.findByMarque("Ford")) {
			logger.info(v.getMarque() + " " + v.getPrix());
		}

		/**
		 * Parcours de voitures dont le prix est dans une fourchette
		 * de prix
		 */

		for (Voiture v : voitureRepository.findByVoiturePriceBetween(20000, 30000)) {
			logger.info(v.getMarque() + " " + v.getPrix());
		}

	}

}
