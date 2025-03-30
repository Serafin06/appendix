package pl.marko.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prace")
public class Praca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "budynek_id", nullable = false)
    private Budynek budynek;

    @Column(name = "data_wykonania", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataWykonania;

    @Column(name = "ilosc_godzin", nullable = false)
    private int iloscGodzin;

    @Column(nullable = false)
    private boolean dojazd;

    @Column(nullable = false)
    private double vat;

    @Column(nullable = false, name = "praca")
    private String praca;

    // Konstruktory
    public Praca() {}

    public Praca(Budynek budynek, Date dataWykonania, int iloscGodzin, boolean dojazd, double vat, String praca) {
        this.budynek = budynek;
        this.dataWykonania = dataWykonania;
        this.iloscGodzin = iloscGodzin;
        this.dojazd = dojazd;
        this.vat = vat;
        this.praca = praca;
    }

    // Gettery i Settery
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Budynek getBudynek() { return budynek; }

    public void setBudynek(Budynek budynek) { this.budynek = budynek; }

    public Date getDataWykonania() { return dataWykonania; }

    public void setDataWykonania(Date dataWykonania) { this.dataWykonania = dataWykonania; }

    public int getIloscGodzin() { return iloscGodzin; }

    public void setIloscGodzin(int iloscGodzin) { this.iloscGodzin = iloscGodzin; }

    public boolean isDojazd() { return dojazd; }

    public void setDojazd(boolean dojazd) { this.dojazd = dojazd; }

    public double getVat() { return vat; }

    public void setVat(double vat) { this.vat = vat; }

    public String getPraca() {
        return praca;
    }

    public void setPraca(String praca) {
        this.praca = praca;
    }
}
