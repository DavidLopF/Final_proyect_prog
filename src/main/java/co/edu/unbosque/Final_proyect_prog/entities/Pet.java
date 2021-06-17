package co.edu.unbosque.Final_proyect_prog.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Name_id")
    private Integer name_id;
    @Column(name = "Microship")
    private long microchip;
    @Column(name = "Name")
    private String name;
    @Column(name = "Species")
    private String species;
    @Column(name = "Race")
    private String race;
    @Column(name = "Size")
    private String size;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "Owner_id")
    private Integer owner_id;
    @Column(name = "pictureUrl")
    private String picture;
    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name")
    private Owner owner;

    @OneToMany(mappedBy = "pet",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetCase> cases = new ArrayList<PetCase>();


    @OneToMany(mappedBy = "pet",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> visits = new ArrayList<Visit>();


    public Pet(long microchip, String name, String species, String race, String size, String sex, String pictureUrl) {
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = pictureUrl;
    }


    public Pet() {

    }

    public void addCase(PetCase p) {
        cases.add(p);
        p.setPet_id(this.getName_id());
    }

    public void removeCase(PetCase p) {
        cases.remove(p);
        p.setPet_id(0);
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getName_id() {
        return name_id;
    }

    public void setName_id(Integer name_id) {
        this.name_id = name_id;
    }

    public long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name_id=" + name_id +
                ", microchip=" + microchip +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", size='" + size + '\'' +
                ", sex='" + sex + '\'' +
                ", owner_id=" + owner_id +
                ", picture='" + picture + '\'' +
                ", owner=" + owner +
                ", cases=" + cases +
                ", visits=" + visits +
                '}';
    }
}
