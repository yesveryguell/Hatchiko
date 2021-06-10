package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> findByUserName(String userName);

    List<Owner> findAll();

    Optional<Owner> save(Owner owner);

    void updateByUsername(String username, String name, String address, String neighborhood);
}
