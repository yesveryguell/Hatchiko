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
@Table(name = "Vet")
/**
 * This annotation specifies a primary key column that is used as a foreign key to join another table.
 */
@PrimaryKeyJoinColumn
/**
 * Public class named Owner that extends from the parent class UserApp (relation 1 to many)
 */
public class Vet extends UserApp{
    /**
     * It allows to define important aspects about the columns of the database such as the name, the length, etc.
     */
    @Column(name = "name")
    /**
     * Private type attribute with alphanumeric variable String of name name
     */
    private String name;
    /**
     * Defines the column name
     */
    @Column(name = "address")
    /**
     * Private type attribute with alphanumeric variable String of name address
     */
    private String address;
    /**
     * Defines the column name
     */
    @Column(name = "neighborhood")
    /**
     * Attribute of private type with alphanumeric variable String of name neighborhood
     */
    private String neighborhood;
    /**
     * One to many relationships are characterized by Entity where we have a main object and collection
     * of objects of another Entity directly related. These relationships are defined by collections
     */
    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    /**
     * Attribute that contains a variable List of visits name that will help us to list the visits made
     */
    private List<Visit> visits = new ArrayList<>();

    /**
     * Empty constructor
     */
    public Vet(){

    }

    /**
     * Constructor that includes the 6 alphanumeric variables String of nombre username, password, email,
     * address, neighborhood  y name
     * @param username registered username username!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email Registered User Email email!= null, email!=" "
     * @param name Registered user name name!= null, name!=" "
     * @param address Registered user address address!= null, address!=" "
     * @param neighborhood Registered User Neighborhood neighborhood!= null, neighborhood!=" "
     */
    public Vet(String username, String password, String email, String name, String address, String neighborhood) {
        super(username, password, email, "Vet");
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
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
     * @param name Registered user name name!= null, name!=" "
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the value of the name attribute address of type String
     * @return address
     */

    public String getAddress() {
        return address;
    }

    /**
     * Update or modify the attribute name
     * @param address Registered user address address!= null, address!=" "
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the value of the neighborhood name attribute of type String
     * @return neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Update or modify the attribute name
     * @param neighborhood Registered User Neighborhood neighborhood!= null, neighborhood!=" "
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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
     * @param visit visits visit!= null, visit!=" "
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setVet(this);
    }
}
