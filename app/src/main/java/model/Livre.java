package model;

public class Livre {
    private int numISBN;
    private String titre;
    private String auteur;
    private String dateedition;
    private Categorie categorie;

    public int getNumISBN() {
        return numISBN;
    }
    public void setNumISBN(int numISBN) {
        this.numISBN = numISBN;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public String getDateedition() {
        return dateedition;
    }
    public void setDateedition(String dateedition) {
        this.dateedition = dateedition;
    }

}
