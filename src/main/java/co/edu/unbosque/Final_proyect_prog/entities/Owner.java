package co.edu.unbosque.Final_proyect_prog.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Owner")
public class Owner implements Serializable {
    @Id
    @JsonbTransient
    @OneToOne
    private UserApp userApp;

    @Column(name = "Person_id")
    private Integer person_id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Neighborhood")
    private String neighborhood;


    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

    public Owner(UserApp userApp, String name, String address, String neighborhood, Integer person_id) {
        this.userApp = userApp;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.person_id = person_id;
    }



    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Owner(){

    }

    public void addPet(Pet p){
        pets.add(p);
    }



    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

}
