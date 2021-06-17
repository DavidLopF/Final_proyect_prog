package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetImp implements PetRepository{
    private EntityManager entityManager;

    public PetImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    public Optional<Pet> findByUserName(int id) {
        Pet pet = entityManager.find(Pet.class, id);
        return pet != null ? Optional.of(pet) : Optional.empty();
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

    @Override
    public List<Pet> findAll() {
        return entityManager.createQuery("from Pet").getResultList();
    }

    public List listByUsername(String username){
        return entityManager.createQuery("SELECT c FROM Pet c WHERE c.owner.userApp.userName LIKE :petUser").setParameter("petUser",username).getResultList();
    }



}
