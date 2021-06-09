package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.VetCase;
import co.edu.unbosque.Hatchiko.jpa.repositories.CasesRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.CasesRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.VetCasePojo;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VetCaseService {
    CasesRepository caseRepository;


    public List<VetCasePojo> listCase() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new CasesRepositoryImpl(entityManager);
        List<VetCase> aCases = caseRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VetCasePojo> casePojo = new ArrayList<>();
        for (VetCase case1 : aCases) {
            casePojo.add(new VetCasePojo(
                   case1.getCase_id(),
                    case1.getCreated_at(),
                    case1.getType(),
                    case1.getDescription()
            ));
        }

        return casePojo;

    }

    public VetCase saveCase(VetCase aCases) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new CasesRepositoryImpl(entityManager);

        VetCase case1 = new VetCase(aCases.getCase_id(), aCases.getCreated_at(), aCases.getType(), aCases.getDescription());
        VetCase persistedCase = caseRepository.save(case1).get();

        entityManager.close();

        return persistedCase;

    }

    public void modifyCase(Integer id, VetCase aCases) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        caseRepository = new CasesRepositoryImpl(entityManager);
        caseRepository.updateById(id, aCases.getCreated_at(), aCases.getType(), aCases.getDescription());

        entityManager.close();
        entityManagerFactory.close();
    }



}
