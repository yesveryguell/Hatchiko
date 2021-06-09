package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.VetCase;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CasesRepositoryImpl implements CasesRepository{

    private EntityManager entityManager;

    public CasesRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<VetCase> findById(Integer id) {
        VetCase aCases = entityManager.find(VetCase.class, id);
        return aCases != null ? Optional.of(aCases) : Optional.empty();
    }

    @Override
    public List<VetCase> findAll() {
        return entityManager.createQuery("from VetCase").getResultList();
    }

    @Override
    public Optional<VetCase> save(VetCase aCases) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aCases);
            entityManager.getTransaction().commit();
            return Optional.of(aCases);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateById(Integer id, String create_at, String type, String description) {
        VetCase aCases = entityManager.find(VetCase.class, id);
        if (aCases != null) {
            try {
                entityManager.getTransaction().begin();
                aCases.setCreated_at(create_at);
                aCases.setType(type);
                aCases.setDescription(description);
                entityManager.merge(aCases);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
