/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.time.LocalDate;
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

    @Override
    public List<Visit> findByVet(String vet) {
        String query = "from Visit where vet = '" + vet + "' order by created_at desc";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Visit> findByDate(String username, String date1, String date2) {

        int d = 0;
        int d2 = 0;

        String[] dates1 = date1.split("-");
        String[] dates2 = date2.split("-");

        for (int i = 0; i < dates1.length; i++) {
            d += Integer.parseInt(dates1[i]);
        }
        for (int i = 0; i < dates2.length; i++) {
            d2 += Integer.parseInt(dates2[i]);
        }

        if(d > d2){
            String query = "from Visit where vet = '" + username + "'and created_at >= '" + date2 + "' and created_at <= '" + date1 + "' order by created_at desc";
            return entityManager.createQuery(query).getResultList();
        }else{
            String query = "from Visit where vet = '" + username + "'and created_at >= '" + date1 + "' and created_at <= '" + date2 + "' order by created_at desc";
            return entityManager.createQuery(query).getResultList();
        }
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

        return entityManager.createQuery("from Visit order by created_at desc").getResultList();
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
    public void updateById(Integer id, LocalDate created_at, String type, String description) {
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
