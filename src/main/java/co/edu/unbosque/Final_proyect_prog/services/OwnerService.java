package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OwnerService {
    private OwnerImp ownerImp;
    private UserAppImp userAppImp;

    public void createOwner(String username,String name, String neight, String address, String password, String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppImp = new UserAppImp(entityManager);
        UserApp newUserApp = new UserApp(username, password, email, "Owner");
        userAppImp.save(newUserApp);

        ownerImp = new OwnerImp(entityManager);
        Owner owner = new Owner(username,name,address,neight);
        ownerImp.save(owner);

        entityManager.close();
        entityManagerFactory.close();
    }
}
