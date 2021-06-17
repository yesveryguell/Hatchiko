/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
/**
 * The public class PetCaseRepositoryImpl that implements the PetCaseRepository interface is initialized
 */
public class PetCaseRepositoryImpl implements PetCaseRepository {

    /**
     * EntityManager type attribute named entityManager
     */
    private EntityManager entityManager;

    /**
     * Constructor of the class that contains the previously created attribute
     * @param entityManager entityManager!=null, entityManager!=" "
     */
    public PetCaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param id id!= null, id!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to search the list of pet cases by id.
     */
    public Optional<PetCase> findById(Integer id) {
        PetCase aCases = entityManager.find(PetCase.class, id);
        return aCases != null ? Optional.of(aCases) : Optional.empty();
    }

    public List<PetCase> findId(Integer id) {
        String query = "from PetCase where case_id = '" + id + "'";
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @return
     */
    @Override
    /**
     * This method allows us to search and find the data that has been entered into the list of pet case
     */
    public List<PetCase> findAll() {
        return entityManager.createQuery("from PetCase").getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param aCases aCases!= null, aCases!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to save pet cases information in the database
     */
    public Optional<PetCase> save(PetCase aCases) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aCases);
            entityManager.getTransaction().commit();
            return Optional.of(aCases);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param id id!= null, id!= " "
     * @param create_at create_at!= null, create_at!= " "
     * @param type type!= null, type!= " "
     * @param description description!= null, description!= " "
     */
    @Override
    /**
     * This method allows us to update the list of pet cases by id
     */
    public void updateById(Integer id, LocalDate create_at, String type, String description) {
        PetCase aCases = entityManager.find(PetCase.class, id);
        if (aCases != null) {
            try {
                entityManager.getTransaction().begin();
                aCases.setCreated_at(create_at);
                aCases.setType(type);
                aCases.setDescription(description);
                entityManager.merge(aCases);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
