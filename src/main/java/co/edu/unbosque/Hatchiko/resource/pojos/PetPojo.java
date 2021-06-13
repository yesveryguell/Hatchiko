/**
 * Paquete que enlaza co.edu.unbosque con resource y pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas, PetPojo, muestra la información
 * de la tabla de mascotas
 */
public class PetPojo {
    /**
     * Atributo de tipo privado con variable numerica Integer de nombre pet_id
     */
    private int pet_id;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre microchip
     */
    private String microchip;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre name
     */
    private String name;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre species
     */
    private String species;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre race
     */
    private String race;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre size
     */
    private String size;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre sex
     */
    private String sex;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre picture
     */
    private String picture;
    /**
     * Constructor vacio
     */
    public PetPojo() {
    }

    /**
     * Constructor que incluye las 8 variables alfanumericas y numericas Integer pet_id, String microchip, name, species, race, size, sex, picture
     * @param pet_id id de la mascota pet_id!= null, pet_id!=" "
     * @param microchip Microchip con el que fue registrado el animal microchip!= null, microchip!=" "
     * @param name nombre con el que fue registrado el animal name!= null, name!=" "
     * @param race raza con la que fue registrado el animal race!= null, race!=" "
     * @param size tamaño con el que fue registrado el animal size!= null, size!=" "
     * @param sex sexo con el que fue registrado el animal sex!= null, sex!=" "
     * @param picture imagen con el que fue registrado el animal picture!= null, picture!=" "
     */
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
    /**
     * Obtiene el valor del atributo de nombre Pet_id de tipo Integer
     * @return getPet_id
     */
    public int getPet_id() {
        return pet_id;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param pet_id id del animal pet_id!= null, pet_id!=" "
     */
    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }
    /**
     * Obtiene el valor del atributo de nombre microchip de tipo String
     * @return microchip
     */
    public String getMicrochip() {
        return microchip;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param microchip Microchip con el que fue registrado el animal microchip!= null, microchip!=" "
     */
    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }
    /**
     * Obtiene el valor del atributo de nombre name de tipo String
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param name nombre con el que fue registrado el animal name!= null, name!=" "
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Obtiene el valor del atributo de nombre species de tipo String
     * @return species
     */
    public String getSpecies() {
        return species;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param species especie con la que fue registrado el animal species!= null, species!=" "
     */
    public void setSpecies(String species) {
        this.species = species;
    }
    /**
     * Obtiene el valor del atributo de nombre race de tipo String
     * @return race
     */
    public String getRace() {
        return race;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param race raza con la que fue registrado el animal race!= null, race!=" "
     */
    public void setRace(String race) {
        this.race = race;
    }
    /**
     * Obtiene el valor del atributo de nombre size de tipo String
     * @return size
     */
    public String getSize() {
        return size;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param size tamaño con el que fue registrado el animal size!= null, size!=" "
     */
    public void setSize(String size) {
        this.size = size;
    }
    /**
     * Obtiene el valor del atributo de nombre sex de tipo String
     * @return sex
     */
    public String getSex() {
        return sex;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param sex sexo con el que fue registrado el animal sex!= null, sex!=" "
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * Obtiene el valor del atributo de nombre picture de tipo String
     * @return picture
     */
    public String getPicture() {
        return picture;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param picture imagen con el que fue registrado el animal picture!= null, picture!=" "
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
