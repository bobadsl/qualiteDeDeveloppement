package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BaseDeDonneesTests {

    @Autowired
    private VoitureRepository voitureRepository;


    @Test
    void deleteAll(){
        voitureRepository.deleteAll();

        Assert.isTrue(voitureRepository.count()==0,"La base de données n'est pas vide !");


    }

    @Test
    void testInsertionUneVoiture(){

        voitureRepository.deleteAll();

        Voiture voiture = new Voiture("Ferrari", 5000);

        voitureRepository.save(voiture);

        Assert.isTrue(voitureRepository.count()==1, "Une voiture devrait-être présente");
    }

    @Test
    void testInsertionPlusieursVoiture(){

        voitureRepository.deleteAll();

        List<Voiture> lV = new ArrayList<Voiture>();

        lV.add(new Voiture("Ford", 59000));
        lV.add(new Voiture("Nissan", 29000));
        lV.add(new Voiture("Toyota", 39000));
        lV.add(new Voiture("Ford", 21000));

        List<Voiture> l = (List<Voiture>) voitureRepository.saveAll(lV);

        Assert.isTrue(l.size()==lV.size(), "Problème d'insertion dans la bases de données !");

        Assert.isTrue(voitureRepository.count()==4,"Il n'y pas 4 tuples !");


    }


    @Test
    void testFindById(){
        voitureRepository.deleteAll();

        List<Voiture> lV = new ArrayList<Voiture>();

        lV.add(new Voiture("Ford", 59000));
        lV.add(new Voiture("Nissan", 29000));
        lV.add(new Voiture("Toyota", 39000));
        lV.add(new Voiture("Ford", 21000));

        voitureRepository.saveAll(lV);

        Assert.isTrue(voitureRepository.findById(1).get().getMarque().equals("Ford") , "La voiture d'id 1 devrait-être une Ford !");
        Assert.isTrue(voitureRepository.findById(1).get().getPrix()==59000 , "La voiture d'id 1 devrait avoir un prix de 59000 euros");

    }



}
