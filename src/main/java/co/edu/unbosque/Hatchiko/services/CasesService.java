package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Cases;
import co.edu.unbosque.Hatchiko.jpa.repositories.CasesRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.CasesRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.CasesPojo;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CasesService {
    CasesRepository caseRepository;


    public List<CasesPojo> listCase() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new CasesRepositoryImpl(entityManager);
        List<Cases> cases = caseRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<CasesPojo> casePojo = new ArrayList<>();
        for (Cases case1 : cases) {
            casePojo.add(new CasesPojo(
                   case1.getCase_id(),
                    case1.getCreated_at(),
                    case1.getType(),
                    case1.getDescription()
            ));
        }

        return casePojo;

    }

    public Cases saveCase(Integer case_id, String created_at, String type, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new CasesRepositoryImpl(entityManager);

        Cases case1 = new Cases(case_id, created_at, type, description);
        Cases persistedCase = caseRepository.save(case1).get();

        entityManager.close();

        return persistedCase;

    }

    public void modifyCase(Integer id, String created_at, String type, String description) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new CasesRepositoryImpl(entityManager);
        caseRepository.updateById(id, created_at, type, description);

        entityManager.close();
        entityManagerFactory.close();
    }





}
