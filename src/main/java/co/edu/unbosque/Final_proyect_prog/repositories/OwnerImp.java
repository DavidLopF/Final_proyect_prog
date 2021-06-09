package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;

import javax.persistence.EntityManager;

public class OwnerImp implements OwnerRepository{
    private EntityManager entityManager;

    public OwnerImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
