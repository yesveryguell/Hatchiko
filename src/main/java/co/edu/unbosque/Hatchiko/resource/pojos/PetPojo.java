/**
 * Package that links co.edu.unbosque with resource and pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * The pojos package is used to show the data that is stored in the tables, PetPojo, shows the information of the pets table
 */
public class PetPojo {
    /**
     * Attribute of private type with numeric variable Integer of name pet_id
     */
    private int pet_id;
    /**
     * Private type attribute with alphanumeric variable String of name microchip
     */
    private String microchip;
    /**
     * Private type attribute with alphanumeric variable String of name name
     */
    private String name;
    /**
     * Attribute of private type with alphanumeric variable String of name species
     */
    private String species;
    /**
     * Attribute of private type with alphanumeric variable String of name race
     */
    private String race;
    /**
     * Attribute of private type with alphanumeric variable String of name size
     */
    private String size;
    /**
     * Attribute of private type with alphanumeric variable String of name sex
     */
    private String sex;
    /**
     * Private type attribute with alphanumeric variable String of name picture
     */
    private String picture;

    private String owner;
    /**
     * Empty constructor
     */
    public PetPojo() {
    }

    /**
     * Constructor that includes the 7 numeric and alphanumeric variables Integer pet_id, String microchip, name, species, race, size, sex, picture
     * @param pet_id pet id pet_id!= null, pet_id!=" "
     * @param microchip Microchip with which the animal was registered microchip!= null, microchip!=" "
     * @param name name with which the animal was registered name!= null, name!=" "
     * @param race breed with which the animal was registered race!= null, race!=" "
     * @param size size with which the animal was registered size!= null, size!=" "
     * @param sex sex with which the animal was registered sex!= null, sex!=" "
     * @param picture image with which the animal was registered picture!= null, picture!=" "
     */
    public PetPojo(int pet_id, String microchip, String name, String species, String race, String size, String sex, String picture, String owner) {
        this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner = owner;
    }

    public PetPojo(int pet_id, String microchip, String name, String species, String race, String size, String sex, String picture) {
        this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public PetPojo(String name, String species, String race, String size, String sex) {
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
    }

    public PetPojo(String picture) {
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
