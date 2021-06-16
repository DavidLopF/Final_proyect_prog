package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Vet;

public interface VetRepository {
    public boolean save(Vet vet);

    public boolean update(String userName, String address, String neighborhood);
}
