/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Interface called Pet Cases Repository, here the search for the list of pets by user name is established, in addition
 * to finding all the information stored in it, the method of saving pet is initialized and the updating of pets by user
 * name that contains two variables of type Integer and String (id, create_at, type and description)
 */
public interface PetCaseRepository {
    Optional<PetCase> findById(Integer id);

    List<PetCase> findId(Integer id);

    List<PetCase> findAll();

    Optional<PetCase> save(PetCase petCase);

    void updateById(Integer id, LocalDate create_at, String type, String description);
}
