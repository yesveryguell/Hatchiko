/**
 * Paquete que enlaza co.edu.unbosque con resource y pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas, UserAppPojo
 */
public class UserAppPojo {
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre username
     */
    private String username;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre password
     */
    private String password;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre email
     */
    private String email;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre role
     */
    private String role;
    /**
     * Constructor vacio
     */
    public UserAppPojo() {
    }
    /**
     * Constructor que incluye las  variables alfanumerica String de nombre username, password, email, role
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Contraseña del usuario registrado password!= null, password!=" "
     * @param role Rol del usuario registrado role!= null, role!=" "
     */
    public UserAppPojo(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    /**
     * Obtiene el valor del atributo de nombre username de tipo String
     * @return username
     */
    public String getUserName() {
        return username;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param userName Nombre de usuario registrado username!= null, username!=" "
     */
    public void setUserName(String userName) {
        this.username = userName;
    }
    /**
     * Obtiene el valor del atributo de nombre password de tipo String
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Obtiene el valor del atributo de nombre email de tipo String
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param email Contraseña del usuario registrado password!= null, password!=" "
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Obtiene el valor del atributo de nombre role de tipo String
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param role Rol del usuario registrado role!= null, role!=" "
     */
    public void setRole(String role) {
        this.role = role;
    }

}
