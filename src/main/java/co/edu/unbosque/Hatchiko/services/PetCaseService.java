/**
 * Package that connects co.edu.unbosque with services
 */
package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetCaseRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetCaseRepositoryImpl;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.PetCasePojo;


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
 * This class allows the interface to be implemented and stored in the database and the class is initialized PetCaseService
 */
public class PetCaseService {
    /**
     * Attribute you type PetCaseRepository name caseRepository
     */
    PetCaseRepository caseRepository;
    /**
     * Attribute you type PetRepository name petRepository
     */
    PetRepository petRepository;

    /**
     * This method is responsible for storing the information that is added to the Pet Case list in the database
     * <b>pre</b> The information previously added in the forms is saved
     * <b>post</b> The information is saved in the list, which causes it to be stored in the database
     * @return casePojo
     */
    public List<PetCasePojo> listCase() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new PetCaseRepositoryImpl(entityManager);
        List<PetCase> aCases = caseRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetCasePojo> casePojo = new ArrayList<>();
        for (PetCase case1 : aCases) {
            casePojo.add(new PetCasePojo(
                   case1.getCase_id(),
                    case1.getCreated_at(),
                    case1.getType(),
                    case1.getDescription()
            ));
        }

        return casePojo;

    }

    /**
     * This method is responsible for saving the information that is added to the list of Pet Case in the database
     * <b>pre</b> Information is added in the corresponding forms
     * <b>post</b> The information is saved and stored in the database
     * @param PetCasePojo PetCasePojo!= null, PetCasePojo!=" "
     * @param pet_id pet_id!= null, pet_id!=" "
     * @return persistedCase
     */
    public Optional<PetCase> savePetCase(PetCasePojo PetCasePojo, Integer pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new PetCaseRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        Optional<Pet> pet = petRepository.findById(pet_id);
        PetCase petCase = new PetCase(PetCasePojo.getCreated_at(), PetCasePojo.getType(), PetCasePojo.getDescription());
        pet.ifPresent(a -> {
            a.addPetCase(petCase);
            petRepository.save(a);
        });
        Optional<PetCase> persistedCase = caseRepository.save(petCase);

        entityManager.close();

        return persistedCase;

    }

    /**
     * This method allows us to modify the information that was added in the lists and that was saved in the databases
     * <b>pre</b> You are looking for the information you want to modify
     * <b>post</b> It is modified and the changes are saved
     * @param id id!= null, id!=" "
     * @param aCases aCases!= null, aCases!=" "
     */
    public void modifyCase(Integer id, PetCase aCases) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new PetCaseRepositoryImpl(entityManager);
        caseRepository.updateById(id, aCases.getCreated_at(), aCases.getType(), aCases.getDescription());

        entityManager.close();
        entityManagerFactory.close();
    }



}
