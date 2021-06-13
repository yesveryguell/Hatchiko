/**
 * Paquete que enlaza co.edu.unbosque con jpa y entities
 */
package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
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
@Table(name = "PetCase")
/**
 * Permiten definir las consultas a nivel de clase de dominio evitando las repeticiones
 */
@NamedQueries({
        @NamedQuery(name = "vetCase.findByType",
                query = "SELECT a FROM PetCase a WHERE a.type = :type")
})
/**
 * Clase publica de nombre PetCase (relacion 1 a 1)
 */
public class PetCase {
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
    @Column(name = "case_id")
    /**
     * Atributo de tipo privado con variable numerica Integer de nombre case_id
     */
    private Integer case_id;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "created_at")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre created_at
     */
    private String created_at;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "type")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre type
     */
    private String type;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "description")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre description
     */
    private String description;
    /**
     * Es una de las anotaciones mas habituales a nivel de JPA y se encarga de generar una relación de muchos a uno
     */
    @ManyToOne
    /**
     * Es una de las anotaciones mas habituales a nivel de JPA y se encarga de generar una relación de muchos a uno
     */
    @JoinColumn(name = "pet_id")
    /**
     * Atributo de tipo privado con variable Pet de nombre pet
     */
    private Pet pet;
    /**
     * Constructor vacio
     */
    public PetCase(){

    }

    /**
     * Constructor 1 que incluye las 4 variables numericas y alfanumerica Integer case_id, String created_at, type y description
     * @param case_id id del caso case_id!= null, case_id!=" "
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     * @param type Tipo de caso type!= null, type!=" "
     * @param description Descripción del caso description!= null, description!=" "
     */
    public PetCase(Integer case_id, String created_at, String type, String description) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    /**
     * Constructor 2 que incluye las 3 variables alfanumerica String created_at, type y description
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     * @param type Tipo de caso type!= null, type!=" "
     * @param description Descripción del caso description!= null, description!=" "
     */
    public PetCase(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }
    /**
     * Obtiene el valor del atributo de nombre case_id de tipo Integer
     * @return case_id
     */
    public Integer getCase_id() {
        return case_id;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param case_id id del caso case_id!= null, case_id!=" "
     */
    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    /**
     * Obtiene el valor del atributo de nombre created_at de tipo String
     * @return created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    /**
     * Obtiene el valor del atributo de nombre type de tipo String
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param type Tipo de caso type!= null, type!=" "
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Obtiene el valor del atributo de nombre description de tipo String
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param description Descripción del caso description!= null, description!=" "
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Obtiene el valor del atributo de nombre pet de tipo String
     * @return pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param pet mascota pet!= null, pet!=" "
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }
}