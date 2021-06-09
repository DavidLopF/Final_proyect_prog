package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.UserApp;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByID(Integer Id);

    List<UserApp> findAll();

}
