package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;
import co.edu.unbosque.Final_proyect_prog.entities.Picture;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PictureImp implements PictureRepository{
    private EntityManager entityManager;
    public PictureImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public void save(Picture p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Picture> obtenerDadoNombreImagen(String uri){
        return entityManager.createQuery("from Picture where url =: "+uri).getResultList();
    }

    public void modificar(int id, String path){
        Picture picture = entityManager.find(Picture.class, id);
        if(picture!=null){
            try {
                entityManager.getTransaction().begin();
                picture.setUrl(path);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public Optional<Picture> findById(Integer id) {
        Picture picture = entityManager.find(Picture.class,id);
        return picture != null ? Optional.of(picture) : Optional.empty();
    }
}
