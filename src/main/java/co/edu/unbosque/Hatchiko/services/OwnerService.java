package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OwnerService {

    OwnerRepository ownerRepository;


    public List<OwnerPojo> listOwner() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPojo> ownerPojo = new ArrayList<>();
        for (Owner owner : owners) {
            ownerPojo.add(new OwnerPojo(
                    owner.getUserName(),
                    owner.getPerson_id(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getNeighborhood()
            ));
        }

        return ownerPojo;

    }

    public Owner saveOwner(OwnerPojo owner1) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Owner owner = new Owner(owner1.getUsername(), owner1.getPerson_id(), owner1.getName(), owner1.getAddress(), owner1.getNeighborhood());
        Owner persistedOwner = ownerRepository.save(owner).get();

        entityManager.close();

        return persistedOwner;

    }

    public void modifyOwner(Integer personID, Owner owner) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        ownerRepository.updateById(personID, owner.getName(), owner.getAddress(), owner.getNeighborhood());

        entityManager.close();
        entityManagerFactory.close();
    }


}
