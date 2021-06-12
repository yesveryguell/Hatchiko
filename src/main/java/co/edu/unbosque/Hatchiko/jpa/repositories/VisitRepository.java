package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {
    Optional<Visit> findById(Integer id);

    List<Visit> findAll();

    Optional<Visit> save(Visit visit);

    void updateById(Integer id, String created_at, String type, String description);
}
