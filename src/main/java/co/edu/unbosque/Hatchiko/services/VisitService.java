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

    public Visit saveVisit(Visit visit1) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);

        Visit visit = new Visit(visit1.getCreated_at(), visit1.getType(), visit1.getDescription());
        Visit persistedVisit = visitRepository.save(visit).get();

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
