/**
 * Package that links co.edu.unbosque with jpa and entities
 */
package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
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
@Table(name = "Visit")
/**
 * They allow to define the queries at the domain class level avoiding repetitions
 */
@NamedQueries({
        @NamedQuery(name = "Visit.findByVisitId",
                query = "SELECT a FROM Visit a WHERE a.visit_id = :visit_id")
})
/**
 * Public class named Pet (relation 1 to many)
 */
public class Visit {
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
    @Column(name = "visit_id")
    /**
     * Private type attribute with Integer numeric variable named visit_id
     */
    private Integer visit_id;
    /**
     * Defines the column name
     */
    @Column(name = "created_at")
    /**
     * Private type attribute with alphanumeric variable String of name created_at
     */
    private String created_at;
    /**
     * Defines the column name
     */
    @Column(name = "type")
    /**
     * Private type attribute with alphanumeric variable String of name type
     */
    private String type;
    /**
     * Defines the column name
     */
    @Column(name = "description")
    /**
     * Private type attribute with alphanumeric variable String of name description
     */
    private String description;
    /**
     * It is one of the most common annotations at the JPA level and is responsible for generating a many-to-one relationship
     */
    @ManyToOne
    /**
     * To indicate that the given column is owned by another entity.
     */
    @JoinColumn(name = "username")
    /**
     * Attribute of private type with variable Vet of name vet
     */
    private Vet vet;
    /**
     * one to one relationship
     */
    @ManyToOne
    /**
     * To indicate that the given column is owned by another entity.
     */
    @JoinColumn(name = "pet_id")
    /**
     * Private type attribute with Pet variable of name pet
     */
    private Pet pet;
    /**
     * Empty constructor
     */
    public Visit(){

    }

    /**
     * Constructor that includes the 3 alphanumeric variables String created_at, type, description
     * @param created_at Case creation created_at!= null, created_at!=" "
     * @param type Case type type!= null, type!=" "
     * @param description Case description description!= null, description!=" "
     */
    public Visit(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }
    /**
     * Gets the value of the name attribute visit_id of type Integer
     * @return visit_id
     */
    public Integer getVisit_id() {
        return visit_id;
    }

    /**
     * Update or modify the attribute name
     * @param visit_id id of the visits visit_id!= null, visit_id!=" "
     */
    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }
    /**
     *Gets the value of the name attribute created_at of type String
     * @return created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * Update or modify the attribute name
     * @param created_at Case creation created_at!= null, created_at!=" "
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    /**
     * Gets the value of the name attribute type of type String
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Update or modify the attribute name
     * @param type Case type type!= null, type!=" "
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Gets the value of the name attribute description of type String
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Update or modify the attribute name
     * @param description Case description description!= null, description!=" "
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Gets the value of the vet name attribute of type Vet
     * @return vet
     */
    public Vet getVet() {
        return vet;
    }

    /**
     * Update or modify the attribute name
     * @param vet vet vet!= null, vet!=" "
     */
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    /**
     * Gets the value of the pet name attribute of type Pet
     * @return pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Update or modify the attribute name
     * @param pet pet pet!= null, pet!=" "
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
