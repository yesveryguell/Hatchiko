/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;

import java.util.List;
import java.util.Optional;

/**
 * Interface called Owner Repository, here the update of the list of owners by user name is established, in addition to
 * finding all the information stored in it, the owner saving method is initialized and the updateByUsername that
 * contains two variables type String (name of username and name, address and neighborhood)
 */
public interface OwnerRepository {

    Optional<Owner> findByUserName(String userName);

    List<Owner> findAll();

    Optional<Owner> save(Owner owner);

    void updateByUsername(String username, String name, String address, String neighborhood);
}
