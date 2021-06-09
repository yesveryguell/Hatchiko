package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OfficialRepositoryImpl implements OfficialRepository{

    private EntityManager entityManager;

    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Official> findById(Integer id) {
        Official official = entityManager.find(Official.class, id);
        return official != null ? Optional.of(official) : Optional.empty();
    }

    @Override
    public List<Official> findAll() {
        return entityManager.createQuery("from Official").getResultList();
    }

    @Override
    public Optional<Official> save(Official official) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(official);
            entityManager.getTransaction().commit();
            return Optional.of(official);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateById(Integer id, String name) {
        Official official = entityManager.find(Official.class, id);
        if (official != null) {
            try {
                entityManager.getTransaction().begin();
                official.setName(name);
                entityManager.merge(official);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
