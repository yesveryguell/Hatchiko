/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
/**
 * The public class OwnerRepositoryImpl that implements the OwnerRepository interface is initialized
 */
public class OwnerRepositoryImpl implements OwnerRepository{
    /**
     * EntityManager type attribute named entityManager
     */
    private EntityManager entityManager;

    /**
     * Constructor of the class that contains the previously created attribute
     * @param entityManager entityManager!=null, entityManager!=" "
     */
    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param userName username!= null, username!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to search the list of owners by username.
     */
    public Optional<Owner> findByUserName(String userName) {
        Owner owner = entityManager.find(Owner.class, userName);
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @return
     */
    @Override
    /**
     * This method allows us to search and find the data that has been entered into the list of owners
     */
    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner").getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param owner owner!= null, owner!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to save owners information in the database
     */
    public Optional<Owner> save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param username username!= null, username!= " "
     * @param name name!= null, name!= " "
     * @param address address!= null, address!= " "
     * @param neighborhood neighborhood!= null, neighborhood!= " "
     */
    @Override
    /**
     * This method allows us to update the list of owners by username
     */
    public void updateByUsername(String username, String name, String address, String neighborhood) {
        Owner owner = entityManager.find(Owner.class, username);
        if (owner != null) {
            try {
                entityManager.getTransaction().begin();
                owner.setName(name);
                owner.setAddress(address);
                owner.setNeighborhood(neighborhood);
                entityManager.merge(owner);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
