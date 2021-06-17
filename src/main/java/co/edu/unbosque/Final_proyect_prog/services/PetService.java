package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.Picture;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.PetImp;
import co.edu.unbosque.Final_proyect_prog.repositories.PictureImp;
import resources.Pojos.PetPOJO;
import resources.Pojos.PicturePojo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.descriptor.JspConfigDescriptor;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class PetService {
    private PictureImp pictureImp;
    private PetImp petImp;
    private OwnerImp ownerImp;

    public boolean createPet(PicturePojo pojo, String name, long microship,
                             String specie, String race, String size, String sex, String username) {
        if (!pojo.getDate().isEmpty() && !pojo.getDescription().isEmpty() && !pojo.getNamePicture().isEmpty()) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            pictureImp = new PictureImp(entityManager);
            petImp = new PetImp(entityManager);
            ownerImp = new OwnerImp(entityManager);

            Optional<Owner> owner = ownerImp.findByUsername(username);

            Pet pet = new Pet(microship, name, specie, race, size, sex, pojo.getNamePicture());
            owner.ifPresent(a -> {
                a.addPet(pet);
                pet.setOwner_id(a.getPerson_id());
                pet.setOwner(a);
            });
            Picture picture = new Picture(pet, pojo.getNamePicture(), pojo.getDescription(), pojo.getDate());
            petImp.save(pet);
            pictureImp.save(picture);
            return true;
        } else {
            return false;
        }

    }

    public boolean modify(String name, long microchip, String size, String specie, String race, String sex, Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);
        boolean bandera =petImp.modify(name,microchip,specie,size,race,sex,id);
        return bandera;
    }

    public List<PetPOJO> listPetsByUsername(String username) {


    public List<PetPOJO> listAllPets() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);

        List<Pet> pets = petImp.findAll();
        List<PetPOJO> petPOJOS = new ArrayList<PetPOJO>();

        for (Pet pet : pets) {
            petPOJOS.add(new PetPOJO(pet.getName_id(), pet.getOwner().getUserApp().getUserName(),
                    pet.getMicrochip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getPicture()));
        }

        return petPOJOS;
    }

    public List<PetPOJO> listPets(String username) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);

        List<Pet> pets = petImp.listByUsername(username);
        List<PetPOJO> petPOJOS = new ArrayList<>();

        for (Pet pet : pets) {
            petPOJOS.add(new PetPOJO(pet.getName_id(),pet.getOwner().getUserApp().getUserName(),
                    pet.getMicrochip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(),pet.getPicture()));

            petPOJOS.add(new PetPOJO(pet.getName_id(), pet.getOwner().getUserApp().getUserName(),
                    pet.getMicrochip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex()));
        }


        return petPOJOS;
    }

    public List<PetPOJO> listPetsByParameter(String param, String value){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);
        List<Pet> pets = petImp.listByParameter(param,value);
        List<PetPOJO> pojos = new ArrayList<>();
        for(Pet p:pets){
            pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
        }
        return pojos;
    }

    public List getByParameter(String param){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);
        List pets = petImp.getByParam(param);
        return pets;

    }

    public List<PetPOJO> listAllPets(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);
        List<Pet> pets = petImp.listAllPets();
        List<PetPOJO> pojos = new ArrayList<>();
        for(Pet p:pets){
            pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
        }
        return pojos;
    }

    public List<PetPOJO> filterByParam(String param){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petImp = new PetImp(entityManager);
        List<Pet> pets = petImp.listAllPets();
        List<PetPOJO> pojos = new ArrayList<>();
        List<String> takens = new ArrayList<>();
        for(Pet p:pets){
            if(param.equals("species")){
                if(!isInList(takens,p.getSpecies())){
                    takens.add(p.getSpecies());
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
            if(param.equals("id")){
                if(!isInList(takens,String.valueOf(p.getOwner_id()))){
                    takens.add(String.valueOf(p.getOwner_id()));
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
            if(param.equals("microchip")){
                if(!isInList(takens,String.valueOf(p.getMicrochip()))){
                    takens.add(String.valueOf(p.getMicrochip()));
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
            if(param.equals("name")){
                if(!isInList(takens,p.getName())){
                    takens.add(p.getName());
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
            if(param.equals("race")){
                if(!isInList(takens,p.getRace())){
                    takens.add(p.getRace());
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
            if(param.equals("size")){
                if(!isInList(takens,p.getSize())){
                    takens.add(p.getSize());
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
            if(param.equals("size")){
                if(!isInList(takens,p.getSize())){
                    takens.add(p.getSize());
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
            if(param.equals("sex")){
                if(!isInList(takens,p.getSex())){
                    takens.add(p.getSex());
                    pojos.add(new PetPOJO(p.getName_id(),String.valueOf(p.getOwner_id()),p.getMicrochip(),p.getName(),p.getSpecies(),p.getRace(),p.getSize(),p.getSex(),p.getPicture()));
                }
            }
        }
        return pojos;

    }

    private boolean isInList(List<String>a, String value){
        for(String s: a){
            if(s.equals(value)){
                return true;
            }
        }
        return false;
    }


}
