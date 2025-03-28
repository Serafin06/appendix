package pl.marko.model;

import java.util.Date;

public class Praca {
    private long id;
    private String adres;
    private Date dataWykonania;
    private int iloscGodzin;
    private boolean dojazd;
    private double vat;
    private String opis; // Dodane pole

    // Gettery i settery dla wszystkich pól, w tym nowe pole 'opis'
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getDataWykonania() {
        return dataWykonania;
    }

    public void setDataWykonania(Date dataWykonania) {
        this.dataWykonania = dataWykonania;
    }

    public int getIloscGodzin() {
        return iloscGodzin;
    }

    public void setIloscGodzin(int iloscGodzin) {
        this.iloscGodzin = iloscGodzin;
    }

    public boolean isDojazd() {
        return dojazd;
    }

    public void setDojazd(boolean dojazd) {
        this.dojazd = dojazd;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}