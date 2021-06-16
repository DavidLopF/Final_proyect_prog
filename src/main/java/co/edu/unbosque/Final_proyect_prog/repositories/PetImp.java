package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List listByUsername(String username){
        return entityManager.createQuery("SELECT c FROM Pet c WHERE c.owner.userApp.userName LIKE :petUser").setParameter("petUser",username).getResultList();
    }



}
