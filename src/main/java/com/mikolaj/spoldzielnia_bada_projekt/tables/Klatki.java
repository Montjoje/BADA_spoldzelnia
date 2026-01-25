package com.mikolaj.spoldzielnia_bada_projekt.tables;

public class Klatki {
    private int nrKlatki;
    private int numerWBudynku;
    private int liczbaWind;
    private int nrBudynku;

    public Klatki() {super();}

    public Klatki(int nrKlatki, int numerWBudynku, int liczbaWind, int numerBudynku) {
        this.nrKlatki = nrKlatki;
        this.numerWBudynku = numerWBudynku;
        this.liczbaWind = liczbaWind;
        this.nrBudynku = numerBudynku;
    }

    public int getNrKlatki() {
        return nrKlatki;
    }

    public void setNrKlatki(int nrKlatki) {
        this.nrKlatki = nrKlatki;
    }

    public int getNumerWBudynku() {
        return numerWBudynku;
    }

    public void setNumerWBudynku(int numerWBudynku) {
        this.numerWBudynku = numerWBudynku;
    }

    public int getLiczbaWind() {
        return liczbaWind;
    }

    public void setLiczbaWind(int liczbaWind) {
        this.liczbaWind = liczbaWind;
    }

    public int getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(int nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    @Override
    public String toString() {
        return "Klatki{" +
                "nrKlatki=" + nrKlatki +
                ", numerWBudynku=" + numerWBudynku +
                ", liczbaWind=" + liczbaWind +
                ", nrBudynku=" + nrBudynku +
                '}';
    }
}
