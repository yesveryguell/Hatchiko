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

@Stateless
public class UserAppService {

    UserAppRepository userAppRepository;


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

    public UserApp saveUser(String username, String password, String email, String role) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userApp = new UserApp(username, password, email, role);
        UserApp persistedUserApp = userAppRepository.save(userApp).get();

        entityManager.close();

        return persistedUserApp;

    }



}
