/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;

import java.util.List;
import java.util.Optional;

/**
 * Interface named Official Repository, here the list of officials is established and the official save method is
 * initialized and the updateByUsername that contains two variables type String (username and name)
 */
public interface OfficialRepository {

    List<Official> findAll();

    Optional<Official> save(Official official);

    void updateByUsername(String username, String name);
}
