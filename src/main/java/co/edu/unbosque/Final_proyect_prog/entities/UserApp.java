package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User_app") //name of table
public class UserApp implements Serializable {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Vet vet;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Oficial oficial;


    public UserApp(String userName, String password, String email, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public UserApp() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}