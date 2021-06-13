/**
 * Paquete que enlaza co.edu.unbosque con resource y pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas
 */
public class OfficialPojo {
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
     * Atributo de tipo privado con variable alfanumerica String de nombre name
     */
    private String name;

    /**
     * Constructor vacio
     */
    public OfficialPojo(){

    }

    /**
     * Constructor que incluye las 3 variables alfanumerica String de nombre username, password y email
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Email del usuario registrado email!= null, email!=" "
     */
    public OfficialPojo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Constructor 1 que incluye las 4 variables alfanumerica String de nombre username, password, email y name
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Email del usuario registrado email!= null, email!=" "
     * @param name Nombre del usuario registrado name!= null, name!=" "
     */
    public OfficialPojo(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }
    /**
     * Obtiene el valor del atributo de nombre username de tipo String
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param username Nombre de usuario registrado username!= null, username!=" "
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @param email Email del usuario registrado email!= null, email!=" "
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Obtiene el valor del atributo de nombre name de tipo String
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param name Nombre del usuario registrado name!= null, name!=" "
     */
    public void setName(String name) {
        this.name = name;
    }
}
