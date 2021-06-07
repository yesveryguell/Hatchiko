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

    public Pet savePet(Pet pet1) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);

        Pet pet = new Pet(pet1.getMicrochip(), pet1.getName(), pet1.getSpecies(), pet1.getRace(), pet1.getSize(), pet1.getSex(), pet1.getPicture());
        Pet persistedPet = petRepository.save(pet).get();

        entityManager.close();

        return persistedPet;

    }

    public void modifyPet(int pet_id, Pet pet) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        petRepository.updateById(pet_id, pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(), pet.getSex(), pet.getRace());

        entityManager.close();
        entityManagerFactory.close();
    }


}
