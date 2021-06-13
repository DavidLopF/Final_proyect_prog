package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Oficial;
import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.OficiaImp;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.Optional;

public class UserAppService {

    private UserAppImp userAppRepository;



    public Optional<String> validateUser(String username, String password ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Getting credentials from the database
        userAppRepository = new UserAppImp(entityManager);
        Optional<UserApp> user = userAppRepository.findByUsername(username);

        entityManager.close();
        entityManagerFactory.close();

        // Validating if credentials provided by the user are valid
        // If success, return the user role
        if (user.isPresent()) {
            if (user.get().getUserName().equals(username) && user.get().getPassword().equals(password)) {
                return Optional.of(user.get().getRole());
            }
        }

        return Optional.empty();

    }
}
