package com.mikolaj.spoldzielnia_bada_projekt.tables;

public class Lokale {
    private int nrLokalu;
    private int numerWBudynku;
    private double metraz;
    private int liczbaPokoi;
    private int nrPietra;
    private int nrKlatki;

    public Lokale() {super();}

    public Lokale(int nrLokalu, int numerWBudynku, double metraz, int liczbaPokoi, int nrPietra, int nrKlatki) {
        this.nrLokalu = nrLokalu;
        this.numerWBudynku = numerWBudynku;
        this.metraz = metraz;
        this.liczbaPokoi = liczbaPokoi;
        this.nrPietra = nrPietra;
        this.nrKlatki = nrKlatki;
    }

    public int getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(int nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public int getNumerWBudynku() {
        return numerWBudynku;
    }

    public void setNumerWBudynku(int numerWBudynku) {
        this.numerWBudynku = numerWBudynku;
    }

    public double getMetraz() {
        return metraz;
    }

    public void setMetraz(double metraz) {
        this.metraz = metraz;
    }

    public int getLiczbaPokoi() {
        return liczbaPokoi;
    }

    public void setLiczbaPokoi(int liczbaPokoi) {
        this.liczbaPokoi = liczbaPokoi;
    }

    public int getNrPietra() {
        return nrPietra;
    }

    public void setNrPietra(int nrPietra) {
        this.nrPietra = nrPietra;
    }

    public int getNrKlatki() {
        return nrKlatki;
    }

    public void setNrKlatki(int nrKlatki) {
        this.nrKlatki = nrKlatki;
    }

    @Override
    public String toString() {
        return "Lokale{" +
                "nrLokalu=" + nrLokalu +
                ", numerWBudynku=" + numerWBudynku +
                ", metraz=" + metraz +
                ", liczbaPokoi=" + liczbaPokoi +
                ", nrPietra=" + nrPietra +
                ", nrKlatki=" + nrKlatki +
                '}';
    }
}
