package com.example.eccezioni;

public class DatiBrano {

    private String titolo;
    private String autore;
    private String genere;
    private int durata;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n titolo:" + this.titolo);
        sb.append("\n autore:" + this.autore);
        sb.append("\n genere:" + this.genere);
        sb.append("\n durata:" + this.durata);

        return sb.toString();
    }

}
