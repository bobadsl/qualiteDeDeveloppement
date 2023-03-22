package com.example.demo.data;

        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Getter;
        import lombok.Setter;

        import javax.persistence.*;


/*
 * Indique que la classe Voiture sera une table de la base de
 * données
 */

@Builder
@AllArgsConstructor
@Entity
public class Voiture {

    private String marque;
    private  int prix;
    private int id;

    public Voiture(){
    }


    /*
     * Annotations
     * @Id permet d'indiquer que l'attribut id servira de clef primaire
     * @GeneratedValue(strategy = GenerationType.AUTO) permet de préciser la startégie de génération
     *                            des valeurs de l'atrribut id (équivalent a SERIAL sour PostgreSQL
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix)  {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marque='" + marque + '\'' +
                ", prix=" + prix +
                ", id=" + id +
                '}';
    }
}
