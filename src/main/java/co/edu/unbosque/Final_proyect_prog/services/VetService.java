package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.entities.Vet;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;
import co.edu.unbosque.Final_proyect_prog.repositories.VetRepository;
import co.edu.unbosque.Final_proyect_prog.repositories.VetRepositoryImp;
import resources.Pojos.UserAppPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VetService {

    UserAppImp userAppImp;
    VetRepositoryImp vetRepositoryImp;

    public boolean createVet(UserAppPOJO user,
                             String name, String addres, String neighborhood) {

        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()
                && !user.getEmail().isEmpty() && !user.getRole().isEmpty()
                && !name.isEmpty() && !addres.isEmpty() && !neighborhood.isEmpty()) {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            userAppImp = new UserAppImp(entityManager);
            vetRepositoryImp = new VetRepositoryImp(entityManager);

            UserApp userApp = new UserApp(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
            Vet vet = new Vet(userApp, name, addres, neighborhood);

            userAppImp.save(userApp);
            vetRepositoryImp.save(vet);
            return true;

        } else {
            return false;
        }

    }
}
