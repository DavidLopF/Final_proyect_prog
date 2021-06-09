package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserAppService {

    private UserAppImp userAppRepository;


    public void createUser(String userName, String password, String role, String email) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppImp(entityManager);
        UserApp newUserApp = new UserApp(userName, password, email, role);
        userAppRepository.save(newUserApp);

        entityManager.close();
        entityManagerFactory.close();

    }
}
