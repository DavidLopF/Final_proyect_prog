package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.PetCase;
import org.hibernate.Criteria;
import org.hibernate.jpa.QueryHints;

import co.edu.unbosque.Final_proyect_prog.entities.Vet;
import co.edu.unbosque.Final_proyect_prog.entities.Visit;

import javax.persistence.EntityManager;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

public class PetImp implements PetRepository{
    private EntityManager entityManager;

    public PetImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Optional<Pet> finById(Integer id){
        Pet pet = entityManager.find(Pet.class, id);
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    public Optional<Pet> findByUserName(int id) {
        Pet pet = entityManager.find(Pet.class, id);
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    public void addCase(Integer id, PetCase p){
        Pet pet = entityManager.find(Pet.class, id);
        if(pet!=null){
            try {
                entityManager.getTransaction().begin();
                pet.addCase(p);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
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
    public boolean modify(String name, long microchip, String specie,String size, String race, String sex, Integer id) {
        Pet pet = entityManager.find(Pet.class, id);
        if(pet!=null){
            try {
                entityManager.getTransaction().begin();
                pet.setMicrochip(microchip);
                pet.setSpecies(specie);
                pet.setRace(race);
                pet.setSex(sex);
                pet.setName(name);
                pet.setSize(size);
                entityManager.getTransaction().commit();
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    public boolean haveSterilization(int pet_id) {
        Pet pet = entityManager.find(Pet.class, pet_id);
        boolean flag = false;

        for (Visit visit : pet.getVisits()) {
            if (visit.getType().equals("sterilization")) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public List<Pet> findAll() {
        return entityManager.createQuery("from Pet").getResultList();
    }

    public List listByUsername(String username){
        return entityManager.createQuery("SELECT c FROM Pet c WHERE c.owner.userApp.userName LIKE :petUser").setParameter("petUser",username).getResultList();
    }

    public List<Pet> listByParameter(String param, String value){
        if(param.equals("specie")){
            return entityManager.createQuery("SELECT c FROM Pet c WHERE c.species LIKE :species").setParameter("species",value).getResultList();
        }else if(param.equals("race")){
            return entityManager.createQuery("SELECT c FROM Pet c WHERE c.race LIKE :races").setParameter("races",value).getResultList();

        }else if(param.equals("size")){
            return entityManager.createQuery("SELECT c FROM Pet c WHERE c.size LIKE :sizes").setParameter("sizes",value).getResultList();

        }else if(param.equals("sex")){
            return entityManager.createQuery("SELECT c FROM Pet c WHERE c.sex LIKE :sexs").setParameter("sexs",value).getResultList();
        }
        else if(param.equals("id")){
            return entityManager.createQuery("SELECT c FROM Pet c WHERE c.owner.person_id LIKE :ids").setParameter("ids",value).getResultList();
        }
        else if(param.equals("microchip")){
            return entityManager.createQuery("SELECT c FROM Pet c WHERE c.microchip LIKE :micro").setParameter("micro",value).getResultList();
        }
        else if(param.equals("name")){
            return entityManager.createQuery("SELECT c FROM Pet c WHERE c.name LIKE :names").setParameter("names",value).getResultList();
        }
        return null;
    }

    public List getByParam(String param){
        return entityManager.createQuery("select distinct p from Pet p left join fetch p.name",Pet.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH,false)
                .getResultList();
    }



}
