/**
 * Package that links co.edu.unbosque with resource and pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * The pojos package is used to show the data that is stored in the tables
 */
public class OfficialPojo {
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
     * Empty constructor
     */
    public OfficialPojo(){

    }

    /**
     * Constructor that includes the 3 alphanumeric variables String of nombre username, password y email
     * @param username Registered Username user!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email email of the registered user email!= null, email!=" "
     */
    public OfficialPojo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Constructor that includes the 4 alphanumeric variables String of nombre username, password, email y name
     * @param username Registered Username user!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email email of the registered user email!= null, email!=" "
     * @param name name with which the animal was registered name!= null, name!=" "
     */
    public OfficialPojo(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }
    /**
     * Gets the value of the name attribute username of type String
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Update or modify the attribute name
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
     * Gets the value of the name attribute of type String
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Update or modify the attribute name
     * @param name name with which the animal was registered name!= null, name!=" "
     */
    public void setName(String name) {
        this.name = name;
    }
}
