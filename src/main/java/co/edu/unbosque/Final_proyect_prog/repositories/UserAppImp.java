package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.UserApp;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public class UserAppImp implements UserAppRepository {

    private EntityManager entityManager;

    public UserAppImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<UserApp> findByID(Integer Id) {
        return Optional.empty();
    }

    @Override
    public List<UserApp> findAll() {
        return null;
    }

    @Override
    public Optional<UserApp> findByUsername(String username) {
        UserApp user = entityManager.find(UserApp.class, username);
        return user != null ? Optional.of(user) : Optional.empty();
    }


    @Override
    public void save(UserApp user) {
               try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
