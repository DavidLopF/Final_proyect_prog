package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;

@Entity
@Table(name = "Picture")
public class Picture {
    @Id
    @ManyToOne
    @JoinColumn(name = "pet")
    private Pet pet;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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
