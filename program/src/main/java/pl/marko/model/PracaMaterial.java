package pl.marko.model;

import jakarta.persistence.*;

@Entity
@Table(name = "praca_material")
public class PracaMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "praca_id", nullable = false)
    private Praca praca;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    @Column(nullable = false)
    private int ilosc;

    // Konstruktory
    public PracaMaterial() {}

    public PracaMaterial(Praca praca, Material material, int ilosc) {
        this.praca = praca;
        this.material = material;
        this.ilosc = ilosc;
    }

    // Gettery i Settery
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Praca getPraca() { return praca; }

    public void setPraca(Praca praca) { this.praca = praca; }

    public Material getMaterial() { return material; }

    public void setMaterial(Material material) { this.material = material; }

    public int getIlosc() { return ilosc; }

    public void setIlosc(int ilosc) { this.ilosc = ilosc; }
}
