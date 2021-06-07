package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.PetPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PetService {
    PetRepository petRepository;


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

    public Pet savePet(String microchip, String name, String species, String race, String size, String sex, String picture) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);

        Pet pet = new Pet(microchip, name, species, race, size, sex, picture);
        Pet persistedPet = petRepository.save(pet).get();

        entityManager.close();

        return persistedPet;

    }

    public void modifyPet(int pet_id, String name, String species, String race, String size, String sex, String picture) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        petRepository.updateById(pet_id, name, species, race, size, sex, picture);

        entityManager.close();
        entityManagerFactory.close();
    }


}
