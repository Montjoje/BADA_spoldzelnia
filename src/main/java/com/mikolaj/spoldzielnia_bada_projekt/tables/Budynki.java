package com.mikolaj.spoldzielnia_bada_projekt.tables;

public class Budynki {
    private int nrBudynku;
    private int liczbaPieter;
    private int nrSpoldzielni;
    private long numerAdresu;
    private String miasto;
    private String ulica;
    private String numerBudynku;
    private String numerLokalu;
    private String kodPocztowy;

    public Budynki() {super();}

    public Budynki(int nrBudynku, int liczbaPieter, int nrSpoldzielni, long numerAdresu, String miasto, String ulica, String numerBudynku, String numerLokalu, String kodPocztowy) {
        this.nrBudynku = nrBudynku;
        this.liczbaPieter = liczbaPieter;
        this.nrSpoldzielni = nrSpoldzielni;
        this.numerAdresu = numerAdresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numerBudynku = numerBudynku;
        this.numerLokalu = numerLokalu;
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public String toString() {
        return "Budynki{" +
                "nrBudynku=" + nrBudynku +
                ", liczbaPieter=" + liczbaPieter +
                ", nrSpoldzielni=" + nrSpoldzielni +
                ", numerAdresu=" + numerAdresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numerBudynku='" + numerBudynku + '\'' +
                ", numerLokalu='" + numerLokalu + '\'' +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                '}';
    }

    public int getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(int nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public int getLiczbaPieter() {
        return liczbaPieter;
    }

    public void setLiczbaPieter(int liczbaPieter) {
        this.liczbaPieter = liczbaPieter;
    }

    public int getNrSpoldzielni() {
        return nrSpoldzielni;
    }

    public void setNrSpoldzielni(int nrSpoldzielni) {
        this.nrSpoldzielni = nrSpoldzielni;
    }

    public long getNumerAdresu() {
        return numerAdresu;
    }

    public void setNumerAdresu(long numerAdresu) {
        this.numerAdresu = numerAdresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerBudynku() {
        return numerBudynku;
    }

    public void setNumerBudynku(String numerBudynku) {
        this.numerBudynku = numerBudynku;
    }

    public String getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(String numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
