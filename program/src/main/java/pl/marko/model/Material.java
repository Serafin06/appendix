package pl.marko.model;

import jakarta.persistence.*;

@Entity
@Table(name = "materialy")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nazwa;

    @Column(nullable = false)
    private double cena;

    @Column(name = "jednostka_miary", nullable = false)
    private String jednostkaMiary;

    // Konstruktory
    public Material() {}

    public Material(String nazwa, double cena, String jednostkaMiary) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.jednostkaMiary = jednostkaMiary;
    }

    // Gettery i Settery
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNazwa() { return nazwa; }

    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public double getCena() { return cena; }

    public void setCena(double cena) { this.cena = cena; }

    public String getJednostkaMiary() { return jednostkaMiary; }

    public void setJednostkaMiary(String jednostkaMiary) { this.jednostkaMiary = jednostkaMiary; }
}
