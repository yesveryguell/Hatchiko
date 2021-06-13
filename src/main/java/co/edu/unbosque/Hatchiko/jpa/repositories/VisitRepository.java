/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;
/**
 * Interface called visit Repository, here the update of the list of visits by id is established, in addition to
 * finding all the information stored in it, the visits saving method is initialized and the update by id that
 * contains variables type Integer and String (name of id, creared at, type and description)
 */
public interface VisitRepository {
    Optional<Visit> findById(Integer id);

    List<Visit> findAll();

    Optional<Visit> save(Visit visit);

    void updateById(Integer id, String created_at, String type, String description);
}
