package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "visit")
public class Visit implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "visit_id")
    private Integer visit_id;

    @Column(name = "create_at")
    private String createAt;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private Vet vet;

    public Visit(Integer visit_id, String createAt, String type, String description) {
        this.visit_id = visit_id;
        this.createAt = createAt;
        this.type = type;
        this.description = description;
    }
}
