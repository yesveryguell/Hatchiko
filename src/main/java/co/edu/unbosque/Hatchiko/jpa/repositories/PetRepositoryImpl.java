/**
 * Package that connects co.edu.unbosque with jpa and repositories
 */
package co.edu.unbosque.Hatchiko.jpa.repositories;

import co.edu.unbosque.Hatchiko.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
/**
 * The public class PetRepositoryImpl that implements the PetRepository interface is initialized
 */
public class PetRepositoryImpl implements PetRepository{
    /**
     * EntityManager type attribute named entityManager
     */
    private EntityManager entityManager;
    /**
     * Constructor of the class that contains the previously created attribute
     * @param entityManager entityManager!=null, entityManager!=" "
     */
    public PetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param id id!= null, id!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to search the list of pets by id.
     */
    public Optional<Pet> findById(Integer id) {
        Pet pet = entityManager.find(Pet.class, id);
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    @Override
    public List<Pet> findByIdList(Integer id) {
        String query = "from Pet where pet_id = " + id;
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pet> findByIdMicrochip(String microchip) {
        String query = "from Pet where microchip = " + "'" + microchip + "'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pet> findByName(String name) {
        String query = "from Pet where name = " + "'" + name + "'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pet> findBySpecie(String specie) {
        String query = "from Pet where species = " + "'" + specie + "'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pet> findByRace(String race) {
        String query = "from Pet where race = " + "'" + race + "'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pet> findBySize(String size) {
        String query = "from Pet where size = " + "'" + size + "'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pet> findBySex(String sex) {
        String query = "from Pet where sex = " + "'" + sex + "'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pet> findByPets(Integer id, String microchip, String name, String specie, String race, String size, String sex) {
        return null;
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @return
     */
    @Override
    /**
     * This method allows us to search and find the data that has been entered into the list of pets
     */
    public List<Pet> findAll() {
        return entityManager.createQuery("from Pet").getResultList();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param pet pet!= null, pet!= " "
     * @return
     */
    @Override
    /**
     * This method allows us to save pets information in the database
     */
    public Optional<Pet> save(Pet pet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     * informs the compiler that the element is meant to override an element declared in a superclass.
     * @param id id!= null, id!= " "
     * @param name name!= null, name!= " "
     * @param species species!= null, species!= " "
     * @param race race!= null, race!= " "
     * @param size size!= null, size!= " "
     * @param sex sex!= null, sex!= " "
     * @param picture picture!= null, picture!= " "
     */
    @Override
    /**
     * This method allows us to update the list of pets by id
     */
    public void updateById(Integer id, String name, String species, String race, String size, String sex, String picture) {
        Pet pet = entityManager.find(Pet.class, id);
        if (pet != null) {
            try {
                entityManager.getTransaction().begin();
                pet.setName(name);
                pet.setSpecies(species);
                pet.setRace(race);
                pet.setSize(size);
                pet.setSex(sex);
                pet.setPicture(picture);
                entityManager.merge(pet);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
