package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Vet;

import java.util.Optional;

public interface VetRepository {

    public Optional<Vet> findByUserName(String userName);


    public boolean save(Vet vet);

    public boolean update(String userName, String address, String neighborhood);
}
