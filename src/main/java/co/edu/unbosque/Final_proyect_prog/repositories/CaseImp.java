package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.PetCase;

import javax.persistence.EntityManager;
import java.util.List;

public class CaseImp implements CaseRespository{
    private EntityManager entityManager;
    public CaseImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public boolean save(PetCase p){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<PetCase> listAll(){
        return entityManager.createQuery("select a from PetCase a",PetCase.class).getResultList();
    }

    public List<PetCase> listByParam(String param){
        return entityManager.createQuery("select a from PetCase a where a.type like :petCase").setParameter("petCase",param).getResultList();
    }


}
