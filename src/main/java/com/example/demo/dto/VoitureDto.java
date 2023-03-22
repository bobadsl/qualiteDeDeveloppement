package com.example.demo.dto;

import com.example.demo.data.Voiture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VoitureDto {

    private String marque;
    private  int prix;
    private int id;



    public static VoitureDto fromEntity(Voiture voiture){

        return VoitureDto.builder()
                .marque(voiture.getMarque())
                .prix(voiture.getPrix())
                .build();
    }

    public static Voiture toEntity(VoitureDto voiture){

        return Voiture.builder()
                .marque(voiture.getMarque())
                .prix(voiture.getPrix())
                .build();
    }


}