package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {
    Optional<Official> findById(Integer id);

    List<Official> findAll();

    Optional<Official> save(Official official);

    void updateById(Integer id, String name);
}
