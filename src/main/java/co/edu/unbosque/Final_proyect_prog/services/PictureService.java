package co.edu.unbosque.Final_proyect_prog.services;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.Pet;
import co.edu.unbosque.Final_proyect_prog.entities.Picture;
import co.edu.unbosque.Final_proyect_prog.repositories.OwnerImp;
import co.edu.unbosque.Final_proyect_prog.repositories.PetImp;
import co.edu.unbosque.Final_proyect_prog.repositories.PictureImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PictureService {
    private PictureImp pictureImp;
    private OwnerImp ownerImp;
    private PetImp petImp;
    public void modify(String username, String url, String filename){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HouseAppDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        pictureImp = new PictureImp(entityManager);
        List<Picture> pictures = pictureImp.obtenerDadoNombreImagen(filename);

        for(Picture p: pictures){
            System.out.println("La uri es "+p.getUrl());
        }

        entityManager.close();
        entityManagerFactory.close();
    }

}
