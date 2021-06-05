package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Cases;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CasesRepositoryImpl implements CasesRepository{

    private EntityManager entityManager;

    public CasesRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Cases> findById(Integer id) {
        Cases cases = entityManager.find(Cases.class, id);
        return cases != null ? Optional.of(cases) : Optional.empty();
    }

    @Override
    public List<Cases> findAll() {
        return entityManager.createQuery("from Cases").getResultList();
    }

    @Override
    public Optional<Cases> save(Cases cases) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cases);
            entityManager.getTransaction().commit();
            return Optional.of(cases);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateById(Integer id, String create_at, String type, String description) {
        Cases cases = entityManager.find(Cases.class, id);
        if (cases != null) {
            try {
                entityManager.getTransaction().begin();
                cases.setCreated_at(create_at);
                cases.setType(type);
                cases.setDescription(description);
                entityManager.merge(cases);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
