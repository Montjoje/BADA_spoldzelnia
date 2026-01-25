package com.mikolaj.spoldzielnia_bada_projekt.tables;

public class SpoldzielnieMieszkaniowe {
    private int nrSpoldzielni;
    private String nazwa;
    private long numerAdresu;
    private String miasto;
    private String ulica;
    private String numerBudynku;
    private String numerLokalu = null;
    private String kodPocztowy;

    public SpoldzielnieMieszkaniowe() {
        super();
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

    @Override
    public String toString() {
        return "SpoldzielnieMieszkaniowe{" +
                "nr_spoldzielni=" + nrSpoldzielni +
                ", nazwa='" + nazwa + '\'' +
                ", numer_adresu=" + numerAdresu +
                '}';
    }
    public int getNrSpoldzielni() {
        return nrSpoldzielni;
    }
    public void setNrSpoldzielni(int nrSpoldzielni) {
        this.nrSpoldzielni = nrSpoldzielni;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public long getNumerAdresu() {
        return numerAdresu;
    }

    public void setNumerAdresu(long numerAdresu) {
        this.numerAdresu = numerAdresu;
    }

    public SpoldzielnieMieszkaniowe(int nrSpoldzielni, String nazwa, int numerAdresu, String miasto, String ulica, String numerBudynku, String numerLokalu, String kodPocztowy) {
        this.nrSpoldzielni = nrSpoldzielni;
        this.nazwa = nazwa;
        this.numerAdresu = numerAdresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numerBudynku = numerBudynku;
        this.numerLokalu = numerLokalu;
        this.kodPocztowy = kodPocztowy;
    }
}
