/**
 * Package that links co.edu.unbosque with jpa and entities
 */
package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * The Entities package is responsible for creating the corresponding tables in the databases
 */

/**
 * Annotation must be defined at the class level and only serves to tell JPA that that class is an Entity
 */
@Entity
/**
 * Annotation is used to indicate the table against which the entity maps
 */
@Table(name = "Pet")
/**
 * They allow to define the queries at the domain class level avoiding repetitions
 */
@NamedQueries({
        @NamedQuery(name = "UserApp.findByPetId",
                query = "SELECT a FROM Pet a WHERE a.pet_id = :pet_id")
})
/**
 * Public class named Pet (relation 1 to many)
 */
public class Pet {
    /**
     * It is used to define the unique identifier of each Entity
     */
    @Id
    /**
     * Tell JPA which autogeneration rule of the primary lead we are going to use
     */
    @GeneratedValue
    /**
     * It allows to define important aspects about the columns of the database such as the name, the length, etc.
     */
    @Column(name = "pet_id")
    /**
     * Attribute of private type with numeric variable Integer of name pet_id
     */
    private Integer pet_id;
    /**
     * Defines the column name
     */
    @Column(name = "microchip", unique = true)
    /**
     * Private type attribute with alphanumeric variable String of name microchip
     */
    private String microchip;
    /**
     * Defines the column name
     */
    @Column(name = "name")
    /**
     * Private type attribute with alphanumeric variable String of name name
     */
    private String name;
    /**
     * Defines the column name
     */
    @Column(name = "species")
    /**
     * Attribute of private type with alphanumeric variable String of name species
     */
    private String species;
    /**
     * Defines the column name
     */
    @Column(name = "race")
    /**
     * Attribute of private type with alphanumeric variable String of name race
     */
    private String race;
    /**
     * Defines the column name
     */
    @Column(name = "size")
    /**
     * Attribute of private type with alphanumeric variable String of name size
     */
    private String size;
    /**
     * Defines the column name
     */
    @Column(name = "sex")
    /**
     * Attribute of private type with alphanumeric variable String of name sex
     */
    private String sex;
    /**
     * Defines the column name
     */
    @Column(name = "picture")
    /**
     * Private type attribute with alphanumeric variable String of name picture
     */
    private String picture;
    /**
     * It is one of the most common annotations at the JPA level and is responsible for generating a many-to-one relationship
     */
    @ManyToOne
    /**
     * To indicate that the given column is owned by another entity.
     */
    @JoinColumn(name = "username")
    /**
     * Attribute of private type with variable Owner named owner
     */
    private Owner owner;
    /**
     * One to many relationships are characterized by Entity where we have a main object and collection
     * of objects of another Entity directly related. These relationships are defined by collections
     */
    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    /**
     * Attribute that contains a variable List of visits name that will help us to list visits to registered pets
     */
    private List<Visit> visits = new ArrayList<>();
    /**
     * One-to-many relationships
     */
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    /**
     * Attribute that contains a variable List of name petCases that will help us to list the entered cases
     */
    private List<PetCase> petCases = new ArrayList<>();
    /**
     * Empty constructor
     */
    public Pet(){

    }

    /**
     * Constructor that includes the 6 alphanumeric String variables microchip, name, species, race, size, sex, picture
     * @param microchip Microchip with which the animal was registered microchip!= null, microchip!=" "
     * @param name name with which the animal was registered name!= null, name!=" "
     * @param race breed with which the animal was registered race!= null, race!=" "
     * @param size size with which the animal was registered size!= null, size!=" "
     * @param sex sex with which the animal was registered sex!= null, sex!=" "
     * @param picture image with which the animal was registered picture!= null, picture!=" "
     */
    public Pet(String microchip, String name, String species, String race, String size, String sex, String picture) {
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    /**
     * Gets the value of the name attribute Pet_id of type Integer
     * @return getPet_id
     */
    public Integer getPet_id() {
        return pet_id;
    }

    /**
     * Update or modify the attribute name
     * @param pet_id animal id pet_id!= null, pet_id!=" "
     */
    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    /**
     * Gets the value of the microchip name attribute of type String
     * @return microchip
     */
    public String getMicrochip() {
        return microchip;
    }

    /**
     * Update or modify the attribute name
     * @param microchip Microchip with which the animal was registered microchip!= null, microchip!=" "
     */
    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    /**
     * Gets the value of the name attribute of type String
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Update or modify the attribute name
     * @param name name with which the animal was registered name!= null, name!=" "
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the name attribute species of type String
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Update or modify the attribute name
     * @param species species with which the animal was registered species!= null, species!=" "
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Gets the value of the race name attribute of type String
     * @return race
     */
    public String getRace() {
        return race;
    }

    /**
     * Update or modify the attribute name
     * @param race breed with which the animal was registered race!= null, race!=" "
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Gets the value of the name attribute size of type String
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * Update or modify the attribute name
     * @param size size with which the animal was registered size!= null, size!=" "
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets the value of the sex name attribute of type String
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Update or modify the attribute name
     * @param sex sex with which the animal was registered sex!= null, sex!=" "
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets the value of the picture name attribute of type String
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Update or modify the attribute name
     * @param picture image with which the animal was registered picture!= null, picture!=" "
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * Gets the value of the owner name attribute of type Owner
     * @return owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Update or modify the attribute name
     * @param owner animal owner owner!= null, owner!=" "
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Gets the value of the visits name attribute of type List
     * @return visits
     */
    public List<Visit> getVisits() {
        return visits;
    }

    /**
     * Update or modify the attribute name
     * @param visit visiting list visit!= null, visit!=" "
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setPet(this);
    }

    /**
     * Gets the value of the name attribute petCases of type List
     * @return petCases
     */
    public List<PetCase> getPetCases() {
        return petCases;
    }

    /**
     * Update or modify the attribute name
     * @param petCase list of visits to cases petCase!= null, petCase!=" "
     */
    public void addPetCase(PetCase petCase) {
        petCases.add(petCase);
        petCase.setPet(this);
    }
}
