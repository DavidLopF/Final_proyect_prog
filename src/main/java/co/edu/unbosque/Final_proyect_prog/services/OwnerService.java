package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;
import resources.Pojos.UserAppPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OwnerService {
    private UserAppImp userAppImp;
    private OwnerImp ownerImp;

    public boolean createOwner(UserAppPOJO user, String name, String address, String neight){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppImp = new UserAppImp(entityManager);
        ownerImp = new OwnerImp(entityManager);

        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()
                && user.getEmail().isEmpty() && !user.getRole().isEmpty()) {
            UserApp userApp = new UserApp(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
            userAppImp.save(userApp);

            Owner owner = new Owner(userApp,name,address,neight);
            ownerImp.save(owner);
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }else{
            entityManager.close();
            entityManagerFactory.close();
            return false;
        }
    }
}
