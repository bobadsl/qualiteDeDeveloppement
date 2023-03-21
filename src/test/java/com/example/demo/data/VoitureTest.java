package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){

        Voiture voiture = null;

        try {
            voiture = new Voiture("Ferrari", 5000);
            Assert.isTrue(voiture.getMarque().equals("Ferrari"), "Doit être Ferrari");
            Assert.isTrue(voiture.getPrix() == 5000, "Doit être 5000");

            // La clef primaire n'a pas été générée
            Assert.isTrue(voiture.getId() == 0, "Doit être 0");
        }

        catch (PrixNegatifException e) {
            Assert.state(false, "Aucune exception ne doit-etre levée");
        }


        try {
            voiture.setPrix(-1);

            Assert.state(false, "Une PrixNegatifException doit-être levée");
        }

        catch (PrixNegatifException e) {}


        try {
            voiture = new Voiture("Ferrari", -1);

            Assert.state(false, "Une PrixNegatifException doit-être levée");
        }

        catch (PrixNegatifException e) {}


        voiture = new Voiture();
        Assert.isNull(voiture.getMarque(), "Doit-être null");
        Assert.isTrue(voiture.getPrix()==0, "Doit-être 0");
        // La clef primaire n'a pas été générée
        Assert.isTrue(voiture.getId()==0, "Doit-être 0");

    }

}
