package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.Vet;
import co.edu.unbosque.Final_proyect_prog.entities.Visit;
import co.edu.unbosque.Final_proyect_prog.repositories.PetImp;
import co.edu.unbosque.Final_proyect_prog.repositories.VetRepositoryImp;
import co.edu.unbosque.Final_proyect_prog.repositories.VisitRepositoryImp;
import resources.Pojos.VisitPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class VisitService {

    private VisitRepositoryImp visitRepositoryImp;
    private VetRepositoryImp vetRepositoryImp;
    private PetImp petImp;

    public boolean createVisit(String vet_id, int pet_id, String description, String type, String createAt) {

        if (!description.isEmpty() && !type.isEmpty() && !createAt.isEmpty()) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            visitRepositoryImp = new VisitRepositoryImp(entityManager);
            petImp = new PetImp(entityManager);
            vetRepositoryImp = new VetRepositoryImp(entityManager);

            if (petImp.haveSterilization(pet_id) && type.equals("sterilization")) {
                return false;
            } else {
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
            }
        } else {
            return false;
        }
    }

    public boolean createVisitMicro(String vet_id, int pet_id, String description, String type, String createAt, long microchip) {
        if (!description.isEmpty() && !type.isEmpty() && !createAt.isEmpty()) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
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
                a.setMicrochip(microchip);
                petImp.save(a);
            });

            return true;
        } else {
            return false;
        }
    }

    public List<VisitPOJO> visitsPet(int pet_id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);

        Optional<Pet> data = petImp.findByUserName(pet_id);
        Pet pet = data.get();
        List<VisitPOJO> visitPOJOS = new ArrayList<VisitPOJO>();

        for (Visit visit : pet.getVisits()) {
            visitPOJOS.add(new VisitPOJO(visit.getVisitId(), visit.getCreateAt(), visit.getType(), visit.getDescripcion(), visit.getPet().getName_id(),
                    visit.getVet().getUserApp().getUserName()));
        }

        return visitPOJOS;
    }

    public List<VisitPOJO> listByUsername(String username, String type){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepositoryImp = new VetRepositoryImp(entityManager);
        List<Vet> vets = vetRepositoryImp.listAll();
        List<VisitPOJO> pojos = new ArrayList<>();
        for(Vet v:vets){
            if(v.getUserApp().getUserName().equals(username)){
                List<Visit> vesitVet = v.getVisits();
                for(Visit vi: vesitVet){
                    if(vi.getType().equalsIgnoreCase(type)){
                        pojos.add(new VisitPOJO(vi.getVisitId(),vi.getCreateAt(),vi.getType(),vi.getDescripcion(),vi.getPet().getName_id(),vi.getVet().getUserApp().getUserName()));
                    }
                }
            }
        }
        return pojos;

    }

    public List<VisitPOJO> visitPOJOS(int pet_id, Date first, Date second) throws ParseException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petImp = new PetImp(entityManager);
        Optional<Pet> data = petImp.findByUserName(pet_id);
        Pet pet = data.get();
        List<VisitPOJO> visitPOJOS = new ArrayList<VisitPOJO>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");

        for (Visit visit : pet.getVisits()) {
            Date fecha = format.parse(visit.getCreateAt());
            if (first.compareTo(fecha) < 0 && second.compareTo(fecha) > 0) {
                visitPOJOS.add(new VisitPOJO(visit.getVisitId(), visit.getCreateAt(), visit.getType(), visit.getDescripcion(), visit.getPet().getName_id(),
                        visit.getVet().getUserApp().getUserName()));
            }
        }

        return visitPOJOS;

    }


}
