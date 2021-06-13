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

@Stateless
public class PetService {
    PetRepository petRepository;
    OwnerRepository ownerRepository;

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
