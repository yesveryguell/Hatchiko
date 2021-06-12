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

@Stateless
public class PetCaseService {
    PetCaseRepository caseRepository;
    PetRepository petRepository;


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

    public void modifyCase(Integer id, PetCase aCases) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new PetCaseRepositoryImpl(entityManager);
        caseRepository.updateById(id, aCases.getCreated_at(), aCases.getType(), aCases.getDescription());

        entityManager.close();
        entityManagerFactory.close();
    }



}
