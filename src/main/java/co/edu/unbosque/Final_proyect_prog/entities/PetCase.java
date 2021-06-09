package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Petcase")
public class PetCase implements Serializable {
    @Id
    @Column(name = "Case_id")
    private Integer case_id;

    @Column(name = "Created_at")
    private String created_at;

    @Column(name = "Type")
    private String type;

    @Column(name = "description")
    private Integer description;

    @Column(name = "pet_id")
    private Integer pet_id;

    @ManyToOne
    @JoinColumn(name = "Name_id")
    private Pet pet;



    public PetCase(){

    }

    public PetCase(Integer case_id, String created_at, String type, Integer description, Integer pet_id) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }
}

