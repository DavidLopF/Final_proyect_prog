package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Oficial;

import javax.persistence.EntityManager;

public class OficiaImp implements OficialRepositry {

    private EntityManager entityManager;

    public OficiaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Oficial oficial) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(oficial);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
