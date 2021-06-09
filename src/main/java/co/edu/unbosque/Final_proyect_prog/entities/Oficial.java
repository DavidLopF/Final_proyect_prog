package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "oficial")
public class Oficial implements Serializable {

    @Id
    @OneToOne
    private UserApp userApp;

    @Column(name = "name")
    private String name;

    public Oficial(UserApp userApp, String name) {
        this.userApp = userApp;
        this.name = name;
    }

    public Oficial() {

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
}