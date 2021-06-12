package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.PetCase;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetCaseRepositoryImpl implements PetCaseRepository {

    private EntityManager entityManager;

    public PetCaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<PetCase> findById(Integer id) {
        PetCase aCases = entityManager.find(PetCase.class, id);
        return aCases != null ? Optional.of(aCases) : Optional.empty();
    }

    @Override
    public List<PetCase> findAll() {
        return entityManager.createQuery("from PetCase").getResultList();
    }

    @Override
    public Optional<PetCase> save(PetCase aCases) {
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
        PetCase aCases = entityManager.find(PetCase.class, id);
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
