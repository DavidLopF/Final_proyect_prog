package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Picture")
public class Picture implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    @Id
    @Column(name = "url")
    private String url;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private String date;

    public Picture(){

    }

    public Picture(Pet pet,String url, String description, String date) {
        this.pet = pet;
        this.url = url;
        this.description = description;
        this.date = date;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
