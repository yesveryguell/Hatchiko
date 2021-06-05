package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {
    Optional<Vet> findById(Integer id);

    List<Vet> findAll();

    Optional<Vet> save(Vet vet);

    void updateById(Integer id, String name, String address, String neighborhood);
}
