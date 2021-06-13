package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.Optional;

public class OwnerImp implements OwnerRepository{
    private EntityManager entityManager;
    public OwnerImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Owner o) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Owner> findByUsername(String username) {
        Owner owner = entityManager.find(Owner.class,username);
        return owner != null ? Optional.of(owner) : Optional.empty();
    }



}
