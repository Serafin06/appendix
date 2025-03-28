package pl.marko.model;

import jakarta.persistence.*;
;

@Entity
@Table(name = "praca_materialy")
public class PracaMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "praca_id")
    private long pracaId;

    @Column(name = "material_id")
    private long materialId;

    @Column(name = "ilosc")
    private double ilosc;

    // Gettery i settery
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPracaId() {
        return pracaId;
    }

    public void setPracaId(long pracaId) {
        this.pracaId = pracaId;
    }

    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }
}