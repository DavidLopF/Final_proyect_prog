package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Oficial;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.OficiaImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;
import resources.Pojos.UserAppPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OficialService {

    private UserAppImp userAppRepository;
    private OficiaImp oficiaImp;

    public boolean createOficial(UserAppPOJO user, String name) {
        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()
                && !user.getEmail().isEmpty() && !user.getRole().isEmpty()
                && !name.isEmpty()) {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            userAppRepository = new UserAppImp(entityManager);
            oficiaImp = new OficiaImp(entityManager);

            UserApp userApp = new UserApp(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
            userAppRepository.save(userApp);
            Oficial oficial = new Oficial(userApp, name);
            oficiaImp.save(oficial);
            entityManager.close();
            entityManagerFactory.close();
            return true;
        } else {
            return false;
        }


    }

}
