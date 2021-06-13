/**
 * Package that connects co.edu.unbosque with services
 */
package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.jpa.entities.Visit;
import co.edu.unbosque.Hatchiko.jpa.repositories.*;
import co.edu.unbosque.Hatchiko.resource.pojos.VisitPojo;

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
 * This class allows the interface to be implemented and stored in the database and the class is initialized VisitService
 */
public class VisitService {
    /**
     * Attribute you type VisitRepository name visitRepository
     */
    VisitRepository visitRepository;
    /**
     * Attribute you type VetRepository name vetRepository
     */
    VetRepository vetRepository;
    /**
     * Attribute you type PetRepository name petRepository
     */
    PetRepository petRepository;

    /**
     * This method is responsible for storing the information that is added to the visit list in the database
     * <b>pre</b> The information previously added in the forms is saved
     * <b>post</b> The information is saved in the list, which causes it to be stored in the database
     * @return visitPojo
     */
    public List<VisitPojo> listVisit() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPojo> visitPojo = new ArrayList<>();
        for (Visit visit : visits) {
            visitPojo.add(new VisitPojo(
                   visit.getVisit_id(),
                    visit.getCreated_at(),
                    visit.getType(),
                    visit.getDescription()
            ));
        }

        return visitPojo;

    }

    /**
     * This method is responsible for saving the information that is added to the list of visits in the database
     * <b>pre</b> Information is added in the corresponding forms
     * <b>post</b> The information is saved and stored in the database
     * @param visitPojo visitPojo!= null, visitPojo!=" "
     * @param username username!= null, username!=" "
     * @param pet_id pet_id!= null, pet_id!=" "
     * @return persistedVisit
     */
    public Optional<Visit> saveVisit(VisitPojo visitPojo, String username, Integer pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        vetRepository = new VetRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        Optional<Vet> vet = vetRepository.findByUserName(username);
        Optional<Pet> pet = petRepository.findById(pet_id);
        Visit visit = new Visit(visitPojo.getCreated_at(), visitPojo.getType(), visitPojo.getDescription());
        vet.ifPresent(a -> {
            a.addVisit(visit);
            vetRepository.save(a);
        });
        pet.ifPresent(a -> {
            a.addVisit(visit);
            petRepository.save(a);
        });
        Optional<Visit> persistedVisit = visitRepository.save(visit);

        entityManager.close();

        return persistedVisit;

    }

    /**
     * This method allows us to modify the information that was added in the lists and that was saved in the databases
     * <b>pre</b> You are looking for the information you want to modify
     * <b>post</b> It is modified and the changes are saved
     * @param id id!= null, id!=" "
     * @param visit visit!= null, visit!=" "
     */
    public void modifyVisit(Integer id,Visit visit) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        visitRepository.updateById(id, visit.getCreated_at(), visit.getType(), visit.getDescription());

        entityManager.close();
        entityManagerFactory.close();
    }



}
