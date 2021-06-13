/**
 * Package that links co.edu.unbosque with resource and pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas, PetCasePojo, muestra la información
 * de la tabla de casos de mascotas
 */
public class VetPojo {
    /**
     * Private type attribute with alphanumeric variable String of name username
     */
    private String username;
    /**
     * Private type attribute with alphanumeric variable String of name password
     */
    private String password;
    /**
     * Private type attribute with alphanumeric variable String of name email
     */
    private String email;
    /**
     * Private type attribute with alphanumeric variable String of name name
     */
    private String name;
    /**
     * Private type attribute with alphanumeric variable String of name address
     */
    private String address;
    /**
     * Attribute of private type with alphanumeric variable String of name neighborhood
     */
    private String neighborhood;
    /**
     * Empty constructor
     */
    public VetPojo() {
    }

    /**
     * Constructor that includes the 3 alphanumeric variables String of name username, password, email
     * @param username registered username username!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email Registered User Email email!= null, email!=" "
     */
    public VetPojo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Constructor 1 that includes the 7 alphanumeric String variables of nombre username, password, email, person_id,
     * address, neighborhood  y name
     * @param username registered username username!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email Registered User Email email!= null, email!=" "
     * @param name Registered user name name!= null, name!=" "
     * @param address Registered user address address!= null, address!=" "
     * @param neighborhood Registered User Neighborhood neighborhood!= null, neighborhood!=" "
     */
    public VetPojo(String username, String password, String email, String name, String address, String neighborhood) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    /**
     * Gets the value of the name attribute username of type String
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *  Update or modify the attribute name
     * @param username Registered Username username!= null, username!=" "
     */
    public void setUsername(String username) {
        this.username = username;
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
     *      */
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
     *      */
    public void setEmail(String email) {
        this.email = email;
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
}
