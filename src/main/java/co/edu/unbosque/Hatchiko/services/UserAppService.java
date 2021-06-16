/**
 * Package that connects co.edu.unbosque with services
 */
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
/**
 * annotations to a class will turn it into an EJB bean
 */
@Stateless
/**
 * This class allows the interface to be implemented and stored in the database and the class is initialized UserAppService
 */
public class UserAppService {
    /**
     * Attribute you type UserAppRepository name userAppRepository
     */
    UserAppRepository userAppRepository;

    /**
     * This method allows validating the information of the users who have entered the forms
     * @param username username!= null, username!=" "
     * @param password password!= null, password!=" "
     * @return username, password
     */
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


    /**
     * This method is responsible for storing the information that is added to the User App list in the database
     * <b>pre</b> The information previously added in the forms is saved
     * <b>post</b> The information is saved in the list, which causes it to be stored in the database
     * @return userAppPojo
     */
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

}
