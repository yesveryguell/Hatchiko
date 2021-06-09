package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;
import co.edu.unbosque.Hatchiko.jpa.entities.Owner;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.repositories.*;
import co.edu.unbosque.Hatchiko.resource.pojos.OfficialPojo;

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
    UserAppRepository userAppRepository;

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
                   official.getName()
            ));
        }

        return officialPojo;

    }

    public Optional<Official> saveOfficial(Official official, String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hatchiko");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        userAppRepository = new UserAppRepositoryImpl(entityManager);
        UserApp userApp = userAppRepository.findByUserName(username).get();
        Official official1 = new Official(official.getName());
        official1.setUserApp(userApp);
        Optional<Official> persistedOfficial = officialRepository.save(official1);

        entityManager.close();

        return persistedOfficial;

    }



}
