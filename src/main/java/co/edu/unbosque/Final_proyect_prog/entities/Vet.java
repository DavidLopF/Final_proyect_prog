package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "neigborhood")
    private String neigborhood;

    public Vet(UserApp userApp, String name, String address, String neigborhood) {
        this.userApp = userApp;
        this.name = name;
        this.address = address;
        this.neigborhood = neigborhood;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeigborhood() {
        return neigborhood;
    }

    public void setNeigborhood(String neigborhood) {
        this.neigborhood = neigborhood;
    }


}
