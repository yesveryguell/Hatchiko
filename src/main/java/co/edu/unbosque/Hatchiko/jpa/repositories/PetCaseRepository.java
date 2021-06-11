package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;

import java.util.List;
import java.util.Optional;

public interface PetCaseRepository {
    Optional<PetCase> findById(Integer id);

    List<PetCase> findAll();

    Optional<PetCase> save(PetCase petCase);

    void updateById(Integer id, String create_at, String type, String description);
}
