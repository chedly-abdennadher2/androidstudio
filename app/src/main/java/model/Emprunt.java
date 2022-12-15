package model;

import java.util.Date;

public class Emprunt {
    private int numemprunt;
    private int id_adherent;
    private int numexemplaire;


    private Date dateemprunt;
    private Date dateretourprevu;
    private Date dateretourreel;
    public int getNumemprunt() {
        return numemprunt;
    }
    public void setNumemprunt(int numemprunt) {
        this.numemprunt = numemprunt;
    }
    public int getId_adherent() {
        return id_adherent;
    }
    public void setId_adherent(int id_adherent) {
        this.id_adherent = id_adherent;
    }
    public int getNumexemplaire() {
        return numexemplaire;
    }
    public void setNumexemplaire(int numexemplaire) {
        this.numexemplaire = numexemplaire;
    }
    public Date getDateemprunt() {
        return dateemprunt;
    }
    public void setDateemprunt(Date dateemprunt) {
        this.dateemprunt = dateemprunt;
    }
    public Date getDateretourprevu() {
        return dateretourprevu;
    }
    public void setDateretourprevu(Date dateretourprevu) {
        this.dateretourprevu = dateretourprevu;
    }
    public Date getDateretourreel() {
        return dateretourreel;
    }
    public void setDateretourreel(Date dateretourreel) {
        this.dateretourreel = dateretourreel;
    }
}
