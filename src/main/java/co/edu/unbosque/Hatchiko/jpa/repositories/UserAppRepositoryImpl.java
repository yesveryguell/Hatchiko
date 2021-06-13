/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
/**
 * The public class UserAppRepositoryImpl that implements the UserAppRepository interface is initialized
 */
public class UserAppRepositoryImpl implements UserAppRepository{
    /**
     * EntityManager type attribute named entityManager
     */
    private EntityManager entityManager;

    /**
     * Constructor of the class that contains the previously created attribute
     * @param entityManager entityManager!=null, entityManager!=" "
     */
    public UserAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param userName username!= null, username!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to search the list of user app by username.
     */
    public Optional<UserApp> findByUserName(String userName) {
        UserApp userApp = entityManager.find(UserApp.class, userName);
        return userApp != null ? Optional.of(userApp) : Optional.empty();
    }
    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @return
     */
    @Override
    /**
     * This method allows us to search and find the data that has been entered into the list of user app
     */
    public List<UserApp> findAll() {
        return entityManager.createQuery("from UserApp ").getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param userApp userApp!= null, userApp!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to save user app information in the database
     */
    public Optional<UserApp> save(UserApp userApp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userApp);
            entityManager.getTransaction().commit();
            return Optional.of(userApp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
