package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.Vet;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.OwnerRepositoryImpl;
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
                    vet.getName(),
                    vet.getAddress(),
                    vet.getNeighborhood()
            ));
        }

        return vetPojo;

    }

    public Vet saveVet(String userName, String name, String address, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);

        Vet vet = new Vet(userName, name, address, neighborhood);
        Vet peristedVet = vetRepository.save(vet).get();

        entityManager.close();

        return peristedVet;

    }

    public void modifyVet(Integer id,String userName, String name, String address, String neighborhood) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        vetRepository.updateById(id, name, address, neighborhood);

        entityManager.close();
        entityManagerFactory.close();
    }





}
