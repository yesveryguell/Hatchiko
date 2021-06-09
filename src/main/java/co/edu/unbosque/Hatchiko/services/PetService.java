package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Pet;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.PetRepositoryImpl;
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

    public Optional<Pet> savePet(Pet pet1, Integer id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Optional<Owner> owner = ownerRepository.findById(id);
        Pet pet = new Pet(pet1.getMicrochip(), pet1.getName(), pet1.getSpecies(), pet1.getRace(), pet1.getSize(), pet1.getSex(), pet1.getPicture());
        owner.ifPresent(a -> {
            a.addPet(pet);
            ownerRepository.save(a);
        });
        Optional<Pet> persistedPet = petRepository.save(pet);

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
