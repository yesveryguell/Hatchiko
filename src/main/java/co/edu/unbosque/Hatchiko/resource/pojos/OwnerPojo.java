/**
 * Paquete que enlaza co.edu.unbosque con resource y pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas, OwnerPojo, muestra la información
 * de la tabla de propietario
 */
public class OwnerPojo {
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
     * Atributo de tipo privado con variable numerica Long de nombre person_id
     */
    private Long person_id;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre name
     */
    private String name;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre address
     */
    private String address;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre neighborhood
     */
    private String neighborhood;
    /**
     * Constructor vacio
     */
    public OwnerPojo() {
    }

    /**
     * Constructor que incluye las 3 variables alfanumerica String de nombre username, password, email
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Email del usuario registrado email!= null, email!=" "
     */
    public OwnerPojo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Constructor 1 que incluye las 7 variables alfanumerica String de nombre username, password, email, person_id,
     * address, neighborhood  y name
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Email del usuario registrado email!= null, email!=" "
     * @param person_id id del usuario registrado person_id!= null, person_id!=" "
     * @param name Nombre del usuario registrado name!= null, name!=" "
     * @param address Direccion del usuario registrado address!= null, address!=" "
     * @param neighborhood Vecindario del usuario registrado neighborhood!= null, neighborhood!=" "
     */
    public OwnerPojo(String username, String password, String email, Long person_id, String name, String address, String neighborhood) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.person_id = person_id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
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
     * Obtiene el valor del atributo de nombre person_id de tipo Long
     * @return person_id
     */
    public Long getPerson_id() {
        return person_id;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param person_id id del usuario registrado person_id!= null, person_id!=" "
     */
    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
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
    /**
     * Obtiene el valor del atributo de nombre address de tipo String
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param address Direccion del usuario registrado address!= null, address!=" "
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Obtiene el valor del atributo de nombre neighborhood de tipo String
     * @return neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }
    /**
     * Obtiene el valor del atributo de nombre pets de tipo List
     * @return pets
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
