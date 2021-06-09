package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.VetCase;

import java.util.List;
import java.util.Optional;

public interface CasesRepository {
    Optional<VetCase> findById(Integer id);

    List<VetCase> findAll();

    Optional<VetCase> save(VetCase vetCase);

    void updateById(Integer id, String create_at, String type, String description);
}
