package pl.marko.model;

import jakarta.persistence.*;

@Entity
@Table(name = "budynki")
public class Budynek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String adres;

    // Konstruktory
    public Budynek() {}

    public Budynek(String adres) {
        this.adres = adres;
    }

    // Gettery i Settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
