/**
 * Package that connects co.edu.unbosque with services
 */
package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.jpa.repositories.*;
import co.edu.unbosque.Hatchiko.resource.pojos.PetPojo;

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
 * This class allows the interface to be implemented and stored in the database and the class is initialized PetService
 */
public class PetService {
    /**
     * Attribute you type PetRepository name petRepository
     */
    PetRepository petRepository;
    /**
     * Attribute you type OwnerRepository name ownerRepository
     */
    OwnerRepository ownerRepository;
    /**
     * This method is responsible for storing the information that is added to the Pet list in the database
     * <b>pre</b> The information previously added in the forms is saved
     * <b>post</b> The information is saved in the list, which causes it to be stored in the database
     * @return petPojo
     */
    public List<PetPojo> listPet() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPojo> petPojo = new ArrayList<>();
        for (Pet pet : pets) {
            petPojo.add(new PetPojo(
                    pet.getPet_id(),
                    pet.getMicrochip(),
                    pet.getName(),
                    pet.getSpecies(),
                    pet.getRace(),
                    pet.getSize(),
                    pet.getSex(),
                    pet.getPicture()
            ));
        }

        return petPojo;

    }

    /**
     * This method is responsible for saving the information that is added to the list of Pet in the database
     * <b>pre</b> Information is added in the corresponding forms
     * <b>post</b> The information is saved and stored in the database
     * @param petPojo petPojo!= null, petPojo!=" "
     * @param username username!= null, username!=" "
     * @return persistedPet
     */
    public Optional<Pet> savePet(PetPojo petPojo, String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Optional<Owner> owner = ownerRepository.findByUserName(username);
        Pet pet = new Pet(petPojo.getMicrochip(), petPojo.getName(), petPojo.getSpecies(), petPojo.getRace(), petPojo.getSize(), petPojo.getSex(), petPojo.getPicture());
        owner.ifPresent(a -> {
            a.addPet(pet);
            ownerRepository.save(a);
        });
        Optional<Pet> persistedPet = petRepository.save(pet);

        entityManager.close();

        return persistedPet;

    }

    /**
     * This method allows us to modify the information that was added in the lists and that was saved in the databases
     * <b>pre</b> You are looking for the information you want to modify
     * <b>post</b> It is modified and the changes are saved
     * @param pet_id pet_id!= null, pet_id!=" "
     * @param petPojo petPojo!= null, petPojo!=" "
     * @return pet
     */
    public Optional<Pet> modifyPet(int pet_id, PetPojo petPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        petRepository.updateById(pet_id, petPojo.getName(), petPojo.getSpecies(), petPojo.getRace(), petPojo.getSize(), petPojo.getSex(), petPojo.getPicture());

        Optional<Pet> pet = petRepository.findById(pet_id);
        entityManager.close();
        entityManagerFactory.close();

        return pet;
    }


}
