/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * The public class OfficialRepositoryImpl that implements the OfficialRepository interface is initialized
 */
public class OfficialRepositoryImpl implements OfficialRepository{
    /**
     * EntityManager type attribute named entityManager
     */
    private EntityManager entityManager;

    /**
     * Constructor of the class that contains the previously created attribute
     * @param entityManager entityManager!=null, entityManager!=" "
     */
    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @return
     */
    @Override
    /**
     * This method allows us to search and find the data that has been entered into the list of officers
     */
    public List<Official> findAll() {
        return entityManager.createQuery("from Official").getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param official official!= null, official!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to save official information in the database
     */
    public Optional<Official> save(Official official) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(official);
            entityManager.getTransaction().commit();
            return Optional.of(official);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param username username!= null, username!= " "
     * @param name name!= null, name!= " "
     */
    @Override
    /**
     * This method allows us to update the list of officers by username
     */
    public void updateByUsername(String username, String name) {
        Official official = entityManager.find(Official.class, username);
        if (official != null) {
            try {
                entityManager.getTransaction().begin();
                official.setName(name);
                entityManager.merge(official);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
