package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Oficial;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.OficiaImp;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class UserAppService {

    private UserAppImp userAppRepository;
    private OficiaImp oficiaImp;
    private OwnerImp ownerImp;

    public void createUser(String userName, String password, String email, String role) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppImp(entityManager);
        UserApp newUserApp = new UserApp(userName, password, email, role);
        userAppRepository.save(newUserApp);


        if (newUserApp.getRole().equals("oficial")) {
            oficiaImp = new OficiaImp(entityManager);
            oficiaImp.save(new Oficial(newUserApp, "oficial david"));
        } else if (newUserApp.getRole().equals("owner")) {
            ownerImp = new OwnerImp(entityManager);
            // Owner newOwner = new Owner();
            //ownerImp.save(newOwner);

        }
        entityManager.close();
        entityManagerFactory.close();

    }

    public Optional<String> validateUser(String username, String password ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Getting credentials from the database
        userAppRepository = new UserAppImp(entityManager);
        Optional<UserApp> user = userAppRepository.findByUsername(username);

        entityManager.close();
        entityManagerFactory.close();

        // Validating if credentials provided by the user are valid
        // If success, return the user role
        if (user.isPresent()) {
            if (user.get().getUser_name().equals(username) && user.get().getPassword().equals(password)) {
                return Optional.of(user.get().getRole());
            }
        }

        return Optional.empty();

    }
}
