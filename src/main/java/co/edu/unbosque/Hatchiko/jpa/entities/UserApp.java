/**
 * Paquete que enlaza co.edu.unbosque con jpa y entities
 */
package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
/**
 * El paquete Entities se encarga de crear las tablas correspondientes en las bases de datos
 */

/**
 * Anotación se debe definir a nivel de clase y sirve únicamente para indicarle a JPA que esa clase es una Entity
 */
@Entity
/**
 * Anotación se utiliza para indicar la tabla contra la que mapea la entidad
 */
@Table(name = "UserApp")
/**
 * La herencia significa que podemos usar consultas polimórficas para recuperar todas las entidades de la subclase al consultar una superclase
 */
@Inheritance(strategy = InheritanceType.JOINED)
/**
 * Clase abstracta de nombre UserApp (clases abstractas funcionan como una clase que declara la existencia de métodos pero no su implementación)
 */
public abstract class UserApp {
    /**
     * Sirve para definir el identificador único de cada Entidad
     */
    @Id
    /**
     * permite definir aspectos importantes sobre las columnas de la base de datos como lo es el nombre, la longitud, etc
     */
    @Column(name = "username")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre username
     */
    private String username;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "password")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre password
     */
    private String password;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "email")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre email
     */
    private String email;
    /**
     * Define el nombre de la columna
     */
    @Column(name = "role")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre role
     */
    private String role;
    /**
     * Constructor vacio
     */
    public UserApp(){

    }

    /**
     * Constructor que incluye las  variables alfanumerica String de nombre username, password, email, role
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Contraseña del usuario registrado password!= null, password!=" "
     * @param role Rol del usuario registrado role!= null, role!=" "
     */
    public UserApp(String username, String password, String email, String role) {
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
