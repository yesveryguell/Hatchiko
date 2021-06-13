/**
 * Package that links co.edu.unbosque with resource and pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 *The pojos package serves to show the data that is stored in the tables, UserAppPojo
 */
public class UserAppPojo {
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
     * Private type attribute with alphanumeric variable String of name role
     */
    private String role;
    /**
     * Empty constructor
     */
    public UserAppPojo() {
    }
    /**
     * Constructor that includes the alphanumeric variables String of name username, password, email, role
     * @param username Registered Username user!= null, username!=" "
     * @param password Password of the registered user password!= null, password!=" "
     * @param email email of the registered user email!= null, email!=" "
     * @param role Registered role of the user role!= null, role!=" "
     */
    public UserAppPojo(String username, String password, String email, String role) {
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
