/**
 * Package that connects co.edu.unbosque with services
 */
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

/**
 * annotations to a class will turn it into an EJB bean
 */
@Stateless
/**
 * This class allows the interface to be implemented and stored in the database and the class is initialized OwnerService
 */
public class OwnerService {
    /**
     * Attribute you type OwnerRepository name ownerRepository
     */
    OwnerRepository ownerRepository;

    /**
     * This method is responsible for storing the information that is added to the Owner list in the database
     * <b>pre</b> The information previously added in the forms is saved
     * <b>post</b> The information is saved in the list, which causes it to be stored in the database
     * @return ownerPojo
     */
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
                    owner.getPassword(),
                    owner.getEmail(),
                    owner.getPerson_id(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getNeighborhood()
            ));
        }

        return ownerPojo;

    }

    /**
     * This method is responsible for saving the information that is added to the list of Owners in the database
     * <b>pre</b> Information is added in the corresponding forms
     * <b>post</b> The information is saved and stored in the database
     * @param ownerPojo ownerPojo!= null, ownerPojo!=" "
     * @return persistedOwner
     */
    public Optional<OwnerPojo> saveOwner(OwnerPojo ownerPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner owner = new Owner(ownerPojo.getUsername(), ownerPojo.getPassword(), ownerPojo.getEmail(),
                ownerPojo.getPerson_id(), ownerPojo.getName(), ownerPojo.getAddress(), ownerPojo.getNeighborhood());
        Optional<Owner> persistedOwner = ownerRepository.save(owner);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOwner.isPresent()) {
            return Optional.of(new OwnerPojo(persistedOwner.get().getUserName(),
                    persistedOwner.get().getPassword(),
                    persistedOwner.get().getEmail(),
                    persistedOwner.get().getPerson_id(),
                    persistedOwner.get().getName(),
                    persistedOwner.get().getAddress(),
                    persistedOwner.get().getNeighborhood()));
        } else {
            return Optional.empty();
        }

    }

    /**
     * This method allows us to modify the information that was added in the lists and that was saved in the databases
     * <b>pre</b> You are looking for the information you want to modify
     * <b>post</b> It is modified and the changes are saved
     * @param username username!=null, username!=" "
     * @param ownerPojo ownerPojo!=null, ownerPojo!=" "
     * @return owner
     */
    public Optional<Owner> modifyOwner(String username, OwnerPojo ownerPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        ownerRepository.updateByUsername(username, ownerPojo.getName(), ownerPojo.getAddress(), ownerPojo.getNeighborhood());
        Optional<Owner> owner = ownerRepository.findByUserName(username);

        entityManager.close();
        entityManagerFactory.close();

        return owner;
    }


}
