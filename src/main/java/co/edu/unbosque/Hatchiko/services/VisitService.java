package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Visit;
import co.edu.unbosque.Hatchiko.jpa.repositories.VisitRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.VisitRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.VisitPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VisitService {
    VisitRepository visitRepository;


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

    public Visit saveVisit(String created_at, String type, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);

        Visit visit = new Visit(created_at, type, description);
        Visit persistedVisit = visitRepository.save(visit).get();

        entityManager.close();

        return persistedVisit;

    }

    public void modifyVisit(Integer id,String created_at, String type, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        visitRepository.updateById(id, created_at, type, description);

        entityManager.close();
        entityManagerFactory.close();
    }



}
