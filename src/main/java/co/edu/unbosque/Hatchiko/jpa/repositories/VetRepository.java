package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    Optional<Vet> findByUserName(String userName);

    List<Vet> findAll();

    Optional<Vet> save(Vet vet);

    void updateByUsername(String username, String name, String address, String neighborhood);
}
