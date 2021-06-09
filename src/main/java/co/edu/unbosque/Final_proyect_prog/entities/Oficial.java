package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "oficial")
public class Oficial implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "user_name")
    private UserApp userApp;

    @Column(name = "name")
    private String name;

}
