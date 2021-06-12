package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "create_at")
    private String createAt;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String descripcion;

    @ManyToOne
    private Vet vet;

    public Visit() {
    }

    public Visit(Integer visitId, String createAt, String type, String descripcion, Vet vet) {
        this.visitId = visitId;
        this.createAt = createAt;
        this.type = type;
        this.descripcion = descripcion;
        this.vet = vet;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
