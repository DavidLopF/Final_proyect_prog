package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vet")
public class Vet implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "user_name")
    private UserApp userApp;


    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String adress;

    @Column(name = "neighborhood")
    private String neighborhood;

    public Vet(UserApp userApp, String name, String adress, String neighborhood) {
        this.userApp = userApp;
        this.name = name;
        this.adress = adress;
        this.neighborhood = neighborhood;
    }

    public Vet() {

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
