package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    public void save(Owner o);
    Optional<Owner> findByUsername(String username);
    public List<Owner> findById(Integer id);
}
