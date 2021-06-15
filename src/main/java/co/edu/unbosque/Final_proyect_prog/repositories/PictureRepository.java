package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Picture;

import java.util.Optional;

public interface PictureRepository {
    public void save(Picture p);
    public Optional<Picture> findById(Integer id);
}
