package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Vet;

import javax.persistence.EntityManager;

public class VetRepositoryImp implements VetRepository {

    private EntityManager entityManager;

    public VetRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
