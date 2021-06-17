package co.edu.unbosque.Final_proyect_prog.repositories;

import co.edu.unbosque.Final_proyect_prog.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    public boolean save(Visit visit);

    public List<Visit> listVisits();
}
