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
@Table(name = "Official")
/**
 * This annotation specifies a primary key column that is used as a foreign key to join another table.
 */
@PrimaryKeyJoinColumn
/**
 * Public class with Official name that extends from the parent class UserApp (relationship 1 to 1)
 */
public class Official extends UserApp {
    /**
     * It allows to define important aspects about the columns of the database such as the name, the length, etc.
     */
    @Column(name = "name")
    /**
     * Private type attribute with alphanumeric variable String of name name
     */
    private String name;

    /**
     * Empty constructor
     */
    public Official(){

    }

    /**
     * Constructor that includes the 4 alphanumeric variables String of name username, password, email y name
     * @param username Registered Username user!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email email of the registered user email!= null, email!=" "
     * @param name Registered user name!= null, name!=" "
     */
    public Official(String username, String password, String email, String name) {
        super(username, password, email, "Official");
        this.name = name;
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
     * @param name Registered user name!= null, name!=" "
     */
    public void setName(String name) {
        this.name = name;
    }


}
