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
@Table(name = "PetCase")
/**
 * They allow to define the queries at the domain class level avoiding repetitions
 */
@NamedQueries({
        @NamedQuery(name = "vetCase.findByType",
                query = "SELECT a FROM PetCase a WHERE a.type = :type")
})
/**
 * Public class named PetCase (1 to 1 relationship)
 */
public class PetCase {
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
    @Column(name = "case_id")
    /**
     * Private type attribute with Integer numeric variable named case_id
     */
    private Integer case_id;
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
     *  To indicate that the given column is owned by another entity.
     */
    @JoinColumn(name = "pet_id")
    /**
     * Private type attribute with Pet variable of name pet
     */
    private Pet pet;
    /**
     * Empty constructor
     */
    public PetCase(){

    }

    /**
     * Constructor 1 that includes the 4 numeric and alphanumeric variables Integer case_id, String created_at, type y description
     * @param case_id case id case_id!= null, case_id!=" "
     * @param created_at Case creation created_at!= null, created_at!=" "
     * @param type Case type type!= null, type!=" "
     * @param description Case description description!= null, description!=" "
     */
    public PetCase(Integer case_id, String created_at, String type, String description) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    /**
     * Constructor 2 that includes the 3 alphanumeric variables String created_at, type y description
     * @param created_at Case creation created_at!= null, created_at!=" "
     * @param type Case type type!= null, type!=" "
     * @param description Case description description!= null, description!=" "
     */
    public PetCase(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }
    /**
     * Gets the value of the case_id name attribute of type Integer
     * @return case_id
     */
    public Integer getCase_id() {
        return case_id;
    }

    /**
     * Update or modify the attribute name
     * @param case_id id del caso case_id!= null, case_id!=" "
     */
    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
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
     * Gets the value of the pet name attribute of type String
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