package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Pet;

public interface PetRepository {
    public void save(Pet p);

    public boolean modify(String name, long microchip,String size, String specie, String race, String sex, Integer id);
}
