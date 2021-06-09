package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository{

    private EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Optional<Owner> findById(Integer id) {
        Owner owner = entityManager.find(Owner.class, id);
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

    @Override
    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner").getResultList();
    }

    @Override
    public Optional<Owner> save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateById(Integer id, String name, String address, String neighborhood) {
        Owner owner = entityManager.find(Owner.class, id);
        if (owner != null) {
            try {
                entityManager.getTransaction().begin();
                owner.setName(name);
                owner.setAddress(address);
                owner.setNeighborhood(neighborhood);
                entityManager.merge(owner);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
