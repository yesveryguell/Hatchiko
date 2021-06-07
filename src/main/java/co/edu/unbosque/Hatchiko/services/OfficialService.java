package co.edu.unbosque.Hatchiko.services;

import co.edu.unbosque.Hatchiko.jpa.entities.Official;
import co.edu.unbosque.Hatchiko.jpa.entities.UserApp;
import co.edu.unbosque.Hatchiko.jpa.repositories.OfficialRepository;
import co.edu.unbosque.Hatchiko.jpa.repositories.OfficialRepositoryImpl;
import co.edu.unbosque.Hatchiko.jpa.repositories.UserAppRepositoryImpl;
import co.edu.unbosque.Hatchiko.resource.pojos.OfficialPojo;
import co.edu.unbosque.Hatchiko.resource.pojos.UserAppPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

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
                   official.getName()
            ));
        }

        return officialPojo;

    }



}
