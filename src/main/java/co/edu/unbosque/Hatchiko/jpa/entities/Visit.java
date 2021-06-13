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
@Table(name = "Visit")
/**
 * Permiten definir las consultas a nivel de clase de dominio evitando las repeticiones
 */
@NamedQueries({
        @NamedQuery(name = "Visit.findByVisitId",
                query = "SELECT a FROM Visit a WHERE a.visit_id = :visit_id")
})
/**
 * Clase publica de nombre Pet (relacion 1 a muchos)
 */
public class Visit {
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
    @Column(name = "visit_id")
    /**
     * Atributo de tipo privado con variable numerica Integer de nombre visit_id
     */
    private Integer visit_id;
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
    @JoinColumn(name = "username")
    /**
     * Atributo de tipo privado con variable Vet de nombre vet
     */
    private Vet vet;
    /**
     * Relación uno a muchos
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
    public Visit(){

    }

    /**
     * Constructor que incluye las 3 variables alfanumerica String created_at, type, description
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     * @param type Tipo de caso type!= null, type!=" "
     * @param description Descripción del caso description!= null, description!=" "
     */
    public Visit(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }
    /**
     * Obtiene el valor del atributo de nombre visit_id de tipo Integer
     * @return visit_id
     */
    public Integer getVisit_id() {
        return visit_id;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param visit_id id de las visitas visit_id!= null, visit_id!=" "
     */
    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
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
     * Obtiene el valor del atributo de nombre vet de tipo Vet
     * @return vet
     */
    public Vet getVet() {
        return vet;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param vet veterinaria vet!= null, vet!=" "
     */
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    /**
     * Obtiene el valor del atributo de nombre pet de tipo Pet
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
