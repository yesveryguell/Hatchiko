package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitRepositoryImpl implements VisitRepository{

    private EntityManager entityManager;

    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Visit> findById(Integer id) {
        Visit visit = entityManager.find(Visit.class, id);
        return visit != null ? Optional.of(visit) : Optional.empty();
    }

    @Override
    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit ").getResultList();
    }

    @Override
    public Optional<Visit> save(Visit visit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateById(Integer id, String created_at, String type, String description) {
        Visit visit = entityManager.find(Visit.class, id);
        if (visit != null) {
            try {
                entityManager.getTransaction().begin();
                visit.setCreated_at(created_at);
                visit.setType(type);
                visit.setDescription(description);
                entityManager.merge(visit);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
