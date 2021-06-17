package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;

import java.util.List;

public interface PetRepository {
    public void save(Pet p);

    public List findAll();
}
