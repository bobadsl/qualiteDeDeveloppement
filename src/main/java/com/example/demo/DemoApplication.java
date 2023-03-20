package com.example.demo;

import com.example.demo.data.Voiture;
import com.example.demo.data.VoitureRepository;
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
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
