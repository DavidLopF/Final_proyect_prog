package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerImp implements OwnerRepository{
    private EntityManager entityManager;
    public OwnerImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void save(Owner o) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Owner> listByNeight(String neight){
        return entityManager.createQuery("SELECT c FROM Owner c WHERE c.neighborhood LIKE :chooseN").setParameter("chooseN",neight).getResultList();
    }


    @Override
    public Optional<Owner> findByUsername(String username) {
        Owner owner = entityManager.find(Owner.class,username);
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public boolean modify(String username, String name, String address, String neighborhood) {
        Owner owner = entityManager.find(Owner.class, username);
        if(owner!=null){
            try {
                entityManager.getTransaction().begin();
                owner.setName(name);
                owner.setAddress(address);
                owner.setNeighborhood(neighborhood);
                entityManager.getTransaction().commit();
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;

            }
        }else{
            return false;
        }

    }


}
