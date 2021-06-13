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
@Table(name = "UserApp")
/**
 * Inheritance means that we can use polymorphic queries to retrieve all entities of the subclass when querying a superclass
 */
@Inheritance(strategy = InheritanceType.JOINED)
/**
 * Abstract class named UserApp (abstract classes work like a class that declares the existence of methods but not their implementation)
 */
public abstract class UserApp {
    /**
     * It is used to define the unique identifier of each Entity
     */
    @Id
    /**
     * It allows to define important aspects about the columns of the database such as the name, the length, etc.
     */
    @Column(name = "username")
    /**
     * Private type attribute with alphanumeric variable String of name username
     */
    private String username;
    /**
     * Defines the column name
     */
    @Column(name = "password")
    /**
     * Private type attribute with alphanumeric variable String of name password
     */
    private String password;
    /**
     * Defines the column name
     */
    @Column(name = "email")
    /**
     * Private type attribute with alphanumeric variable String of name email
     */
    private String email;
    /**
     * Defines the column name
     */
    @Column(name = "role")
    /**
     * Private type attribute with alphanumeric variable String of name role
     */
    private String role;
    /**
     * Empty constructor
     */
    public UserApp(){

    }

    /**
     * Constructor that includes the alphanumeric variables String of name username, password, email, role
     * @param username Registered Username user!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email email of the registered user email!= null, email!=" "
     * @param role Registered role of the user role!= null, role!=" "
     */
    public UserApp(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     * Gets the value of the name attribute username of type String
     * @return username
     */
    public String getUserName() {
        return username;
    }

    /**
     * Update or modify the attribute name
     * @param userName Registered Username username!= null, username!=" "
     */
    public void setUserName(String userName) {
        this.username = userName;
    }
    /**
     * Gets the value of the name attribute password of type String
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Update or modify the attribute name
     * @param password Password of the registered user password!= null, password!=" "
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Gets the value of the email name attribute of type String
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Update or modify the attribute name
     * @param email Password of the registered user password!= null, password!=" "
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Gets the value of the name attribute role of type String
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Update or modify the attribute name
     * @param role Registered User Role role!= null, role!=" "
     */
    public void setRole(String role) {
        this.role = role;
    }

}
