package co.edu.unbosque.Final_proyect_prog.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_app") //name of table
public class UserApp implements Serializable {

    @Id
    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;


    public UserApp(String userName, String password, String email, String role) {
        this.user_name = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public UserApp() {

    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String userName) {
        this.user_name = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}