package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;

import javax.persistence.EntityManager;

public class PetImp implements PetRepository{
    private EntityManager entityManager;

    public PetImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public void save(Pet p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
