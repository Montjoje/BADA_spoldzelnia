package com.mikolaj.spoldzielnia_bada_projekt.tables;

public class UserProfileDTO {

    private String imieMieszkanca;
    private String nazwiskoMieszkanca;

    private String pesel;
    private Integer wiek;
    private String stanCywilny;
    private Character plec;
    private String numerKontaktowy;

    private Integer numerWBudynku;
    private Double metraz;
    private Integer liczbaPokoi;
    private Integer nrPietra;

    private String adresEmail;

    public String getImieMieszkanca() {
        return imieMieszkanca;
    }

    public void setImieMieszkanca(String imieMieszkanca) {
        this.imieMieszkanca = imieMieszkanca;
    }

    public String getNazwiskoMieszkanca() {
        return nazwiskoMieszkanca;
    }

    public void setNazwiskoMieszkanca(String nazwiskoMieszkanca) {
        this.nazwiskoMieszkanca = nazwiskoMieszkanca;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public String getStanCywilny() {
        return stanCywilny;
    }

    public void setStanCywilny(String stanCywilny) {
        this.stanCywilny = stanCywilny;
    }

    public Character getPlec() {
        return plec;
    }

    public void setPlec(Character plec) {
        this.plec = plec;
    }

    public String getNumerKontaktowy() {
        return numerKontaktowy;
    }

    public void setNumerKontaktowy(String numerKontaktowy) {
        this.numerKontaktowy = numerKontaktowy;
    }

    public Integer getNumerWBudynku() {
        return numerWBudynku;
    }

    public void setNumerWBudynku(Integer numerWBudynku) {
        this.numerWBudynku = numerWBudynku;
    }

    public Double getMetraz() {
        return metraz;
    }

    public void setMetraz(Double metraz) {
        this.metraz = metraz;
    }

    public Integer getLiczbaPokoi() {
        return liczbaPokoi;
    }

    public void setLiczbaPokoi(Integer liczbaPokoi) {
        this.liczbaPokoi = liczbaPokoi;
    }

    public Integer getNrPietra() {
        return nrPietra;
    }

    public void setNrPietra(Integer nrPietra) {
        this.nrPietra = nrPietra;
    }

    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }
}
