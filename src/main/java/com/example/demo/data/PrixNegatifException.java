package com.example.demo.data;

public class PrixNegatifException extends Exception {

    public PrixNegatifException(){
        super("Le prix ne peut pas être négatif");
    }

}
