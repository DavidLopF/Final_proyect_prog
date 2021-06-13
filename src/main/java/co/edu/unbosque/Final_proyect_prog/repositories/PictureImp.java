package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.Picture;

import javax.persistence.EntityManager;

public class PictureImp implements PictureRepository{
    private EntityManager entityManager;
    public PictureImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public void save(Picture p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
