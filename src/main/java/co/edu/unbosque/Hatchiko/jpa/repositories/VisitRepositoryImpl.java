/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
/**
 * The public class VisitRepositoryImpl that implements the VisitRepository interface is initialized
 */
public class VisitRepositoryImpl implements VisitRepository{
    /**
     * EntityManager type attribute named entityManager
     */
    private EntityManager entityManager;
    /**
     * Constructor of the class that contains the previously created attribute
     * @param entityManager entityManager!=null, entityManager!=" "
     */
    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param id id!=null, id!=" "
     * @return
     */
    @Override
    /**
     * This method allows us to search the list of visits by id.
     */
    public Optional<Visit> findById(Integer id) {
        Visit visit = entityManager.find(Visit.class, id);
        return visit != null ? Optional.of(visit) : Optional.empty();
    }
    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @return
     */
    @Override
    /**
     * This method allows us to search and find the data that has been entered into the list of visits
     */
    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit ").getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param visit visit!= null, visit!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to save visits information in the database
     */
    public Optional<Visit> save(Visit visit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass
     * @param id id!= null, id!= " "
     * @param created_at created_at!= null, created_at!= " "
     * @param type type!= null, type!= " "
     * @param description description!= null, description!= " "
     */
    @Override
    /**
     * This method allows us to update the list of visits by id
     */
    public void updateById(Integer id, String created_at, String type, String description) {
        Visit visit = entityManager.find(Visit.class, id);
        if (visit != null) {
            try {
                entityManager.getTransaction().begin();
                visit.setCreated_at(created_at);
                visit.setType(type);
                visit.setDescription(description);
                entityManager.merge(visit);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
