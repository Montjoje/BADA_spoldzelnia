package com.mikolaj.spoldzielnia_bada_projekt.tables;

public class AdresyEmail {
    private Integer nrAdrEmail = null;
    private String adresEmail = null;
    private Integer nrPracownika = null;
    private Integer nrMieszkanca = null;

    public AdresyEmail(){super();}

    public AdresyEmail(Integer nrAdrEmail, String adresEmail, Integer nrPracownika, Integer nrMieszkanca) {
        this.nrAdrEmail = nrAdrEmail;
        this.adresEmail = adresEmail;
        this.nrPracownika = nrPracownika;
        this.nrMieszkanca = nrMieszkanca;
    }

    @Override
    public String toString() {
        return "AdresyEmail{" +
                "nrAdrEmail=" + nrAdrEmail +
                ", adresEmail='" + adresEmail + '\'' +
                ", nrPracownika=" + nrPracownika +
                ", nrMieszkanca=" + nrMieszkanca +
                '}';
    }

    public Integer getNrAdrEmail() {
        return nrAdrEmail;
    }

    public void setNrAdrEmail(Integer nrAdrEmail) {
        this.nrAdrEmail = nrAdrEmail;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    public Integer getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(Integer nrPracownika) {
        this.nrPracownika = nrPracownika;
    }

    public Integer getNrMieszkanca() {
        return nrMieszkanca;
    }

    public void setNrMieszkanca(Integer nrMieszkanca) {
        this.nrMieszkanca = nrMieszkanca;
    }
}
