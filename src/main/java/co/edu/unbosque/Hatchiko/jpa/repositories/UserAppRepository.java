/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;

import java.util.List;
import java.util.Optional;
/**
 * Interface called User App Repository, here the update of the list of user app by user name is established, in addition to
 * finding all the information stored in it
 */
public interface UserAppRepository {
    Optional<UserApp> findByUserName(String userName);

    List<UserApp> findAll();

    Optional<UserApp> save(UserApp userApp);

//    void updateById(Integer id, String name, String address, String neighborhood);
}
