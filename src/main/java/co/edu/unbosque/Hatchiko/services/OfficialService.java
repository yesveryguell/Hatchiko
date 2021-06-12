package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;
import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.repositories.*;
import co.edu.unbosque.Hatchiko.resource.pojos.OfficialPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.OwnerPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public List<OfficialPojo> listOfficial() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        List<Official> officials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OfficialPojo> officialPojo = new ArrayList<>();
        for (Official official : officials) {
            officialPojo.add(new OfficialPojo(
                    official.getUserName(),
                    official.getPassword(),
                    official.getEmail(),
                    official.getName()
            ));
        }

        return officialPojo;

    }

    public Optional<OfficialPojo> saveOfficial(OfficialPojo officialPojo) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Official official = new Official(officialPojo.getUsername(), officialPojo.getPassword(), officialPojo.getEmail(), officialPojo.getName());

        Optional<Official> persistedOfficial = officialRepository.save(official);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedOfficial.isPresent()) {
            return Optional.of(new OfficialPojo(persistedOfficial.get().getUserName(),
                    persistedOfficial.get().getPassword(),
                    persistedOfficial.get().getEmail(),
                    persistedOfficial.get().getName()));
        } else {
            return Optional.empty();
        }

    }


}
