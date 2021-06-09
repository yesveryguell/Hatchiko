package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepositoryImpl;
import co.edu.unbosque.Hatchiko.jpa.repositories.VetRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.VetRepositoryImpl;
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
    UserAppRepository userAppRepository;


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
                    vet.getUserApp().getUserName(),
                    vet.getName(),
                    vet.getAddress(),
                    vet.getNeighborhood()
            ));
        }

        return vetPojo;

    }

    public Optional<Vet> saveVet(Vet vet1, String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);
        UserApp userApp = userAppRepository.findByUserName(username).get();
        Vet vet = new Vet(vet1.getName(), vet1.getAddress(), vet1.getNeighborhood());
        vet.setUserApp(userApp);
        Optional<Vet> persistedVet = vetRepository.save(vet);

        entityManager.close();

        return persistedVet;

    }

    public void modifyVet(Integer id, Vet vet) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        vetRepository.updateById(id, vet.getName(), vet.getAddress(), vet.getNeighborhood());

        entityManager.close();
        entityManagerFactory.close();
    }

}
