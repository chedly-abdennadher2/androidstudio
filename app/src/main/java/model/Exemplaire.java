package model;

import java.math.BigDecimal;

public class Exemplaire {
    private int numexemplaire;
    private String disponible;

    private BigDecimal prix;


    public int getNumexemplaire() {
        return numexemplaire;
    }

    public void setNumexemplaire(int numexemplaire) {
        this.numexemplaire = numexemplaire;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }



}

