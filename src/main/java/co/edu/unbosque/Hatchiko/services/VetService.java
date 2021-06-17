/**
 * Package that connects co.edu.unbosque with services
 */
package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepositoryImpl;
import co.edu.unbosque.Hatchiko.jpa.repositories.VetRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.VetRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.VetPojo;

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
 * This class allows the interface to be implemented and stored in the database and the class is initialized VetService
 */
public class VetService {
    /**
     * Attribute you type VetRepository name vetRepository
     */
    VetRepository vetRepository;
    /**
     * This method is responsible for storing the information that is added to the vet list in the database
     * <b>pre</b> The information previously added in the forms is saved
     * <b>post</b> The information is saved in the list, which causes it to be stored in the database
     * @return vetPojo
     */
    public List<VetPojo> listVet() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        List<Vet> vets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VetPojo> vetPojo = new ArrayList<>();
        for (Vet vet : vets) {
            vetPojo.add(new VetPojo(
                    vet.getUserName(),
                    vet.getPassword(),
                    vet.getEmail(),
                    vet.getName(),
                    vet.getAddress(),
                    vet.getNeighborhood()
            ));
        }

        return vetPojo;

    }

    public List<VetPojo> listVet(String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        List<Vet> vets = vetRepository.findUserName(username);

        entityManager.close();
        entityManagerFactory.close();

        List<VetPojo> vetPojo = new ArrayList<>();
        for (Vet vet : vets) {
            vetPojo.add(new VetPojo(
                    vet.getUserName(),
                    vet.getPassword(),
                    vet.getEmail(),
                    vet.getName(),
                    vet.getAddress(),
                    vet.getNeighborhood()
            ));
        }

        return vetPojo;

    }

    /**
     * This method is responsible for saving the information that is added to the list of vet in the database
     * <b>pre</b> Information is added in the corresponding forms
     * <b>post</b> The information is saved and stored in the database
     * @param vetPojo vetPojo!= null, vetPojo!=" "
     * @return persistedVet
     */
    public Optional<VetPojo> saveVet(VetPojo vetPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);

        Vet vet = new Vet(vetPojo.getUsername(), vetPojo.getPassword(), vetPojo.getEmail(), vetPojo.getName(), vetPojo.getAddress(), vetPojo.getNeighborhood());

        Optional<Vet> persistedVet = vetRepository.save(vet);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedVet.isPresent()) {
            return Optional.of(new VetPojo(persistedVet.get().getUserName(),
                    persistedVet.get().getPassword(),
                    persistedVet.get().getEmail(),
                    persistedVet.get().getName(),
                    persistedVet.get().getAddress(),
                    persistedVet.get().getNeighborhood()));
        } else {
            return Optional.empty();
        }

    }

    /**
     * This method allows us to modify the information that was added in the lists and that was saved in the databases
     * <b>pre</b> You are looking for the information you want to modify
     * <b>post</b> It is modified and the changes are saved
     * @param username username!= null, username!=" "
     * @param vetPojo vetPojo!= null, vetPojo!=" "
     * @return vet
     */
    public Optional<Vet> modifyVet(String username, VetPojo vetPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        vetRepository.updateByUsername(username, vetPojo.getAddress(), vetPojo.getNeighborhood());

        Optional<Vet> vet = vetRepository.findByUserName(username);
        entityManager.close();
        entityManagerFactory.close();

        return vet;
    }

}
