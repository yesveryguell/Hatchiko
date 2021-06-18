/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;

import java.util.List;
import java.util.Optional;

/**
 * Interface called Pet Repository, here the search for the list of pets by id is established, in addition to finding
 * all the information stored in it, the method of saving pets and updating pets by id is initialized, which contains
 * two variables such as Integer and String (id, name, species, race, size, gender and image)
 */
public interface PetRepository {
    Optional<Pet> findById(Integer id);

    List<Pet> findByOwner(String owner);

    List<Pet> findByIdList(Integer id);

    List<Pet> findByIdMicrochip(String microchip);

    List<Pet> findByName(String name);

    List<Pet> findBySpecie(String specie);

    List<Pet> findByRace(String race);

    List<Pet> findBySize(String size);

    List<Pet> findBySex(String sex);

    List<Pet> findAll();

    Optional<Pet> save(Pet pet);

    void updateById(Integer id, String name, String species, String race, String size, String sex);

    void uploapImage(Integer id, String image);

    void editMicrochip(Integer id, String microchip);
}
