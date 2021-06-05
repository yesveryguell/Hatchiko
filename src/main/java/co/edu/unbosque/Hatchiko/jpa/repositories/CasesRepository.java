package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Cases;

import java.util.List;
import java.util.Optional;

public interface CasesRepository {
    Optional<Cases> findById(Integer id);

    List<Cases> findAll();

    Optional<Cases> save(Cases cases);

    void updateById(Integer id, String create_at, String type, String description);
}
