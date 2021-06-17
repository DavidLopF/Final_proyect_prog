package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.Vet;
import co.edu.unbosque.Final_proyect_prog.entities.Visit;
import co.edu.unbosque.Final_proyect_prog.repositories.PetImp;
import co.edu.unbosque.Final_proyect_prog.repositories.VetRepositoryImp;
import co.edu.unbosque.Final_proyect_prog.repositories.VisitRepositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class VisitService {

    private VisitRepositoryImp visitRepositoryImp;
    private VetRepositoryImp vetRepositoryImp;
    private PetImp petImp;

    public boolean createVisit(String vet_id, int pet_id, String description, String type, String createAt) {
        if (!description.isEmpty() && !type.isEmpty() && !createAt.isEmpty()) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            visitRepositoryImp = new VisitRepositoryImp(entityManager);
            petImp = new PetImp(entityManager);
            vetRepositoryImp = new VetRepositoryImp(entityManager);

            Visit visit = new Visit(createAt, type, description);
            Optional<Vet> vet = vetRepositoryImp.findByUserName(vet_id);
            Optional<Pet> pet = petImp.findByUserName(pet_id);


            vet.ifPresent(a -> {
                a.addVisit(visit);
                visit.setVet(a);
                vetRepositoryImp.save(a);
            });

            pet.ifPresent(a -> {
                a.addVisit(visit);
                visit.setPet(a);
                petImp.save(a);
            });

            return true;
        } else {
            return false;
        }
    }
}
