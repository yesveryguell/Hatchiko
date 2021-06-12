package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    Optional<Pet> findById(Integer id);

    List<Pet> findAll();

    Optional<Pet> save(Pet pet);

    void updateById(Integer id, String name, String species, String race, String size, String sex, String picture);
}
