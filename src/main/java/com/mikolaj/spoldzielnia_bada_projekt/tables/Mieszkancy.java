package com.mikolaj.spoldzielnia_bada_projekt.tables;

public class Mieszkancy {
    private int nrMieszkanca;
    private String imieMieszkanca;
    private String nazwiskoMieszkanca;
    private String pesel = null;
    private Integer wiek = null;
    private String stanCywilny = null;
    private char plec;
    private String numerKontaktowy = null;
    private int nrLokalu;
    private String password;
    private String username;
    public Mieszkancy(){super();}

    public Mieszkancy(int nrMieszkanca, String imieMieszkanca, String nazwiskoMieszkanca, String pesel, Integer wiek, String stanCywilny, char plec, String numerKontaktowy, int nrLokalu) {
        this.nrMieszkanca = nrMieszkanca;
        this.imieMieszkanca = imieMieszkanca;
        this.nazwiskoMieszkanca = nazwiskoMieszkanca;
        this.pesel = pesel;
        this.wiek = wiek;
        this.stanCywilny = stanCywilny;
        this.plec = plec;
        this.numerKontaktowy = numerKontaktowy;
        this.nrLokalu = nrLokalu;
        this.username = ("mieszkaniec@" + nrMieszkanca);
    }

    @Override
    public String toString() {
        return "Mieszkancy{" +
                "nrMieszkanca=" + nrMieszkanca +
                ", imieMieszkanca='" + imieMieszkanca + '\'' +
                ", nazwiskoMieszkanca='" + nazwiskoMieszkanca + '\'' +
                ", pesel='" + pesel + '\'' +
                ", wiek=" + wiek +
                ", stanCywilny='" + stanCywilny + '\'' +
                ", plec=" + plec +
                ", numerKontaktowy='" + numerKontaktowy + '\'' +
                ", nrLokalu=" + nrLokalu +
                '}';
    }

    public int getNrMieszkanca() {
        return nrMieszkanca;
    }

    public void setNrMieszkanca(int nrMieszkanca) {
        this.nrMieszkanca = nrMieszkanca;
    }

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

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getNumerKontaktowy() {
        return numerKontaktowy;
    }

    public void setNumerKontaktowy(String numerKontaktowy) {
        this.numerKontaktowy = numerKontaktowy;
    }

    public int getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(int nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername(){
        return username;
    }

}
