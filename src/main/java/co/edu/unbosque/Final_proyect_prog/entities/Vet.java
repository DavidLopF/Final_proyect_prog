package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vet")
public class Vet implements Serializable {

    @Id
    @OneToOne
    private UserApp userApp;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;


    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> visits = new ArrayList<>();


    public Vet(UserApp userApp, String name, String address, String neighborhood) {
        this.userApp = userApp;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Vet() {

    }



    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
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

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }


}
