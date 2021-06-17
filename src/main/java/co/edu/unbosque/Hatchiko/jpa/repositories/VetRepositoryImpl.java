/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
/**
 * The public class VetRepositoryImpl that implements the VetRepository interface is initialized
 */
public class VetRepositoryImpl implements VetRepository{
    /**
     * EntityManager type attribute named entityManager
     */
    private EntityManager entityManager;
    /**
     * Constructor of the class that contains the previously created attribute
     * @param entityManager entityManager!=null, entityManager!=" "
     */
    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param userName username!= null, username!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to search the list of vet by username.
     */
    public Optional<Vet> findByUserName(String userName) {
        Vet vet = entityManager.find(Vet.class, userName);
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    @Override
    public List<Vet> findUserName(String username) {
        String query = "from Vet where username = '" + username + "'";
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @return
     */
    @Override
    /**
     * This method allows us to search and find the data that has been entered into the list of vet
     */
    public List<Vet> findAll() {
        return entityManager.createQuery("from Vet").getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param vet vet!= null, vet!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to save vet information in the database
     */
    public Optional<Vet> save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param username username!= null, username!= " "
     * @param address address!= null, address!= " "
     * @param neighborhood neighborhood!= null, neighborhood!= " "
     */
    @Override
    /**
     * This method allows us to update the list of vets by username
     */
    public void updateByUsername(String username,String address, String neighborhood) {
        Vet vet = entityManager.find(Vet.class, username);
        if (vet != null) {
            try {
                entityManager.getTransaction().begin();
                vet.setAddress(address);
                vet.setNeighborhood(neighborhood);
                entityManager.merge(vet);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
