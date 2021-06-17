package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;

public class VisitRepositoryImp implements VisitRepository {

    private EntityManager entityManager;

    public VisitRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean save(Visit visit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Visit> listVisits() {
        return null;
    }
}
