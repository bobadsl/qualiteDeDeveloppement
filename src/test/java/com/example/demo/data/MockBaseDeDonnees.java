package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MockBaseDeDonnees {

    @MockBean
    private VoitureRepository voitureRepository;

    @Test
    void testInsertionUneVoiture(){
        Voiture voiture = new Voiture("Ferrari", 5000);
        when(voitureRepository.save(voiture)).thenReturn(voiture);
        when(voitureRepository.findAll()).thenReturn(Collections.singletonList(voiture));
    }

    @Test
    void testInsertionPlusieursVoiture(){

        List<Voiture> lV = new ArrayList<Voiture>();

        lV.add(new Voiture("Ford", 59000));
        lV.add(new Voiture("Nissan", 29000));
        lV.add(new Voiture("Toyota", 39000));
        lV.add(new Voiture("Ford", 21000));

        when(voitureRepository.saveAll(lV)).thenReturn(lV);
    }

    @Test
    void deleteAll(){
        Voiture voiture = new Voiture("Ferrari", 5000);

    }

}
