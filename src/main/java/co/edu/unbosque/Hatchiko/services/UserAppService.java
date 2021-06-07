package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.UserAppPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserAppService {

    UserAppRepository userAppRepository;

    public Optional<String> validateUser(String username, String password ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Getting credentials from the database
        userAppRepository = new UserAppRepositoryImpl(entityManager);
        Optional<UserApp> user = userAppRepository.findByUserName(username);

        entityManager.close();
        entityManagerFactory.close();

        // Validating if credentials provided by the user are valid
        // If success, return the user role
        if (user.isPresent()) {
            if (user.get().getUserName().equals(username) && user.get().getPassword().equals(password)) {
                return Optional.of(user.get().getRole());
            }
        }

        return Optional.empty();

    }

    public List<UserAppPojo> listUsers() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);
        List<UserApp> users = userAppRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<UserAppPojo> userAppPojo = new ArrayList<>();
        for (UserApp userApp : users) {
            userAppPojo.add(new UserAppPojo(
                    userApp.getUserName(),
                    userApp.getPassword(),
                    userApp.getEmail(),
                    userApp.getRole()
            ));
        }

        return userAppPojo;

    }

    public Optional<UserAppPojo> saveUser(UserAppPojo user) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userApp = new UserApp(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
        Optional<UserApp> persistedUserApp = userAppRepository.save(userApp);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedUserApp.isPresent()) {
            return Optional.of(new UserAppPojo(persistedUserApp.get().getUserName(),
                    persistedUserApp.get().getPassword(),
                    persistedUserApp.get().getEmail(),
                    persistedUserApp.get().getRole()));
        } else {
            return Optional.empty();
        }

    }



}
