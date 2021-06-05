package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;

import java.util.List;
import java.util.Optional;

public interface UserAppRepository {
    Optional<UserApp> findByUserName(String userName);

    List<UserApp> findAll();

    Optional<UserApp> save(UserApp userApp);

//    void updateById(Integer id, String name, String address, String neighborhood);
}
