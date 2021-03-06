package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.Vet;
import co.edu.unbosque.Final_proyect_prog.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetRepositoryImp implements VetRepository {

    private EntityManager entityManager;

    public VetRepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    public Optional<Vet> findByUserName(String userName) {
        Vet vet = entityManager.find(Vet.class, userName);
        return vet != null ? Optional.of(vet) : Optional.empty();
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

    public List<Vet> listAll(){
        return entityManager.createQuery("from Vet ").getResultList();
    }



    @Override
    public boolean update(String userName, String address, String neighborhood) {
        boolean flag = false;
        Vet finedVet = entityManager.find(Vet.class, userName);
        if (finedVet != null) {
            try {
                entityManager.getTransaction().begin();
                finedVet.setAddress(address);
                finedVet.setNeighborhood(neighborhood);
                entityManager.getTransaction().commit();
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
