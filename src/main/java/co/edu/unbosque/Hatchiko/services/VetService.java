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

@Stateless
public class VetService {

    VetRepository vetRepository;

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

    public Optional<Vet> modifyVet(String username, VetPojo vetPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        vetRepository.updateByUsername(username, vetPojo.getName(), vetPojo.getAddress(), vetPojo.getNeighborhood());

        Optional<Vet> vet = vetRepository.findByUserName(username);
        entityManager.close();
        entityManagerFactory.close();

        return vet;
    }

}
