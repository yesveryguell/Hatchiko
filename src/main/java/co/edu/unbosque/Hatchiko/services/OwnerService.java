package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class OwnerService {

    OwnerRepository ownerRepository;
    UserAppRepository userAppRepository;


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
                    owner.getUserApp().getUserName(),
                    owner.getPerson_id(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getNeighborhood()
            ));
        }

        return ownerPojo;

    }

    public Optional<Owner> saveOwner(Owner owner1, String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);
        UserApp userApp = userAppRepository.findByUserName(username).get();
        Owner owner = new Owner(owner1.getPerson_id(), owner1.getName(), owner1.getAddress(), owner1.getNeighborhood());
        owner.setUserApp(userApp);
        Optional<Owner> persistedOwner = ownerRepository.save(owner);

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
