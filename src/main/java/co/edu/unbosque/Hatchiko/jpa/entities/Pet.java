/**
 * Paquete que enlaza co.edu.unbosque con jpa y entities
 */
package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * El paquete Entities se encarga de crear las tablas correspondientes en las bases de datos
 */

/**
 * Anotación se debe definir a nivel de clase y sirve únicamente para indicarle a JPA que esa clase es una Entity
 */
@Entity
/**
 * Anotación se utiliza para indicar la tabla contra la que mapea la entidad
 */
@Table(name = "Pet")
/**
 * Permiten definir las consultas a nivel de clase de dominio evitando las repeticiones
 */
@NamedQueries({
        @NamedQuery(name = "UserApp.findByPetId",
                query = "SELECT a FROM Pet a WHERE a.pet_id = :pet_id")
})
/**
 * Clase publica de nombre Pet (relacion 1 a muchos)
 */
public class Pet {
    /**
     * Sirve para definir el identificador único de cada Entidad
     */
    @Id
    /**
     * Indica a JPA que regla de autogeneración de la lleve primaria vamos a utilizar
     */
    @GeneratedValue
    /**
     * permite definir aspectos importantes sobre las columnas de la base de datos como lo es el nombre, la longitud, etc
     */
    @Column(name = "pet_id")
    /**
     * Atributo de tipo privado con variable numerica Integer de nombre pet_id
     */
    private Integer pet_id;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "microchip", unique = true)
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre microchip
     */
    private String microchip;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "name")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre name
     */
    private String name;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "species")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre species
     */
    private String species;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "race")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre race
     */
    private String race;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "size")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre size
     */
    private String size;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "sex")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre sex
     */
    private String sex;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "picture")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre picture
     */
    private String picture;
    /**
     * Es una de las anotaciones mas habituales a nivel de JPA y se encarga de generar una relación de muchos a uno
     */
    @ManyToOne
    /**
     * Es una de las anotaciones mas habituales a nivel de JPA y se encarga de generar una relación de muchos a uno
     */
    @JoinColumn(name = "username")
    /**
     * Atributo de tipo privado con variable Owner de nombre owner
     */
    private Owner owner;
    /**
     * Las relaciones uno a muchos se caracterizan por Entidad donde tenemos un objeto principal y colección
     * de objetos de otra Entidad relacionados directamente. Estas relaciones se definen mediante colecciones
     */
    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    /**
     * Atributo que contiene una variable Lista de nombre visits que nos ayudara a listar las visitas a las mascotas registradas
     */
    private List<Visit> visits = new ArrayList<>();
    /**
     * Las relaciones uno a muchos
     */
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    /**
     * Atributo que contiene una variable Lista de nombre petCases que nos ayudara a listar los casos ingresados
     */
    private List<PetCase> petCases = new ArrayList<>();
    /**
     * Constructor vacio
     */
    public Pet(){

    }

    /**
     * Constructor que incluye las 7 variables alfanumerica String microchip, name, species, race, size, sex, picture
     * @param microchip Microchip con el que fue registrado el animal microchip!= null, microchip!=" "
     * @param name nombre con el que fue registrado el animal name!= null, name!=" "
     * @param race raza con la que fue registrado el animal race!= null, race!=" "
     * @param size tamaño con el que fue registrado el animal size!= null, size!=" "
     * @param sex sexo con el que fue registrado el animal sex!= null, sex!=" "
     * @param picture imagen con el que fue registrado el animal picture!= null, picture!=" "
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
     * Obtiene el valor del atributo de nombre Pet_id de tipo Integer
     * @return getPet_id
     */
    public Integer getPet_id() {
        return pet_id;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param pet_id id del animal pet_id!= null, pet_id!=" "
     */
    public void setPet_id(Integer pet_id) {
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

    /**
     * Obtiene el valor del atributo de nombre owner de tipo Owner
     * @return owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param owner dueño del animal owner!= null, owner!=" "
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Obtiene el valor del atributo de nombre visits de tipo Lista
     * @return visits
     */
    public List<Visit> getVisits() {
        return visits;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param visit lista de visitas visit!= null, visit!=" "
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setPet(this);
    }

    /**
     * Obtiene el valor del atributo de nombre petCases de tipo Lista
     * @return petCases
     */
    public List<PetCase> getPetCases() {
        return petCases;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param petCase lista de visitas a los casos petCase!= null, petCase!=" "
     */
    public void addPetCase(PetCase petCase) {
        petCases.add(petCase);
        petCase.setPet(this);
    }
}
