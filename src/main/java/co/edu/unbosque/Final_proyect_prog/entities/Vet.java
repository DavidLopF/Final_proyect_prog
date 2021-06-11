package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;
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

    @Column(name = "neigborhood")
    private String neigborhood;

    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> visits;

    @Column(name = "vet:id", unique = true)
    @GeneratedValue
    private Integer vetId;

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
