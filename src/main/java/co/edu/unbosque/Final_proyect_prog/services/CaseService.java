package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.PetCase;
import co.edu.unbosque.Final_proyect_prog.repositories.CaseImp;
import co.edu.unbosque.Final_proyect_prog.repositories.PetImp;
import resources.Pojos.CasePOJO;
import resources.Pojos.PetCasePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class CaseService {
    private CaseImp caseImp;
    private PetImp petImp;

    public boolean create(CasePOJO c){
        if(!c.getCreatedAt().isEmpty()&&!c.getDescription().isEmpty()&&!c.getCreatedAt().isEmpty()){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            caseImp = new CaseImp(entityManager);
            PetCase caso = new PetCase(c.getCreatedAt(),c.getType(),c.getDescription(),c.getPet_id());
            petImp = new PetImp(entityManager);
            Optional<Pet> pet = petImp.finById(c.getPet_id());
            pet.ifPresent(a->{
                petImp.addCase(c.getPet_id(),caso);
                caso.setPet(a);
                caseImp.save(caso);
            });
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        return false;
    }

    public List<PetCase> listCases(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        caseImp = new CaseImp(entityManager);
        List<PetCase> petCases = caseImp.listAll();
        return petCases;

    }

    public List<PetCasePOJO> listCasesByParam(String param){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        caseImp = new CaseImp(entityManager);
        List<PetCase> petCases = caseImp.listByParam(param);
        List<PetCasePOJO> pojos = new ArrayList<>();
        for(PetCase p: petCases){
            pojos.add(new PetCasePOJO(p.getCreated_at(),p.getType(),p.getDescription(),p.getPet_id()));
        }
        return pojos;

    }
}
