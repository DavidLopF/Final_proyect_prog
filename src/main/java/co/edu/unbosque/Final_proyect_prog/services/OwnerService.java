package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.UserApp;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.UserAppImp;
import resources.Pojos.OwnerPOJO;
import resources.Pojos.PetPOJO;
import resources.Pojos.UserAppPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OwnerService{
    private UserAppImp userAppImp;
    private OwnerImp ownerImp;

    public boolean createOwner(UserAppPOJO user, String name, String address, String neight){
        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()
                && !user.getEmail().isEmpty() && !user.getRole().isEmpty()) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            userAppImp = new UserAppImp(entityManager);
            ownerImp = new OwnerImp(entityManager);
            int num = 1;

                num = (int)(Math.random()*(10000+0));


            UserApp userApp = new UserApp(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
            userAppImp.save(userApp);

            Owner owner = new Owner(userApp,name,address,neight,num);

            ownerImp.save(owner);
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyOwner(String username, String name,  String address, String neighborhood){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerImp = new OwnerImp(entityManager);
        boolean bandera =ownerImp.modify(username,name,address,neighborhood);
        entityManager.close();
        entityManagerFactory.close();
        return bandera;
    }

    public List<OwnerPOJO> filterByNeight(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerImp = new OwnerImp(entityManager);
        List<Owner> owners = ownerImp.getAllOwner();
        List<OwnerPOJO> pojos = new ArrayList<>();
        List<String> takens = new ArrayList<>();
        for(Owner o:owners){
            if(!isInList(takens,o.getNeighborhood())){
                takens.add(String.valueOf(o.getNeighborhood()));
                pojos.add(new OwnerPOJO(o.getName(),o.getPerson_id(),o.getAddress(),o.getNeighborhood()));
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

    public List<OwnerPOJO> listByNeigth(String neight){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("4Citycens_final_proyect");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerImp = new OwnerImp(entityManager);
        List<Owner> owners = ownerImp.listByNeight(neight);
        List<OwnerPOJO> pojos = new ArrayList<>();
        for(Owner o:owners){
            pojos.add(new OwnerPOJO(o.getName(),o.getPerson_id(),o.getAddress(),o.getNeighborhood()));
        }
        return pojos;

    }
}
