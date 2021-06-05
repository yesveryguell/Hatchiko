package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    Optional<Owner> findById(Integer id);

    List<Owner> findAll();

    Optional<Owner> save(Owner owner);

    void updateById(Integer id, String name, String address, String neighborhood);
}
