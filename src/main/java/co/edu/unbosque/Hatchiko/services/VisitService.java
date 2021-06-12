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

@Stateless
public class VisitService {
    VisitRepository visitRepository;
    VetRepository vetRepository;
    PetRepository petRepository;


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

    public void modifyVisit(Integer id,Visit visit) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        visitRepository.updateById(id, visit.getCreated_at(), visit.getType(), visit.getDescription());

        entityManager.close();
        entityManagerFactory.close();
    }



}
