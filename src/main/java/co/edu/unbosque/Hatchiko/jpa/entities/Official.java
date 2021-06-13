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
@Table(name = "Official")
/**
 * Esta anotación especifica una columna de clave principal que se utiliza como clave externa para unirse a otra tabla.
 */
@PrimaryKeyJoinColumn
/**
 * Clase publica de nombre Official que extiende de la clase madre UserApp (relacion 1 a 1)
 */
public class Official extends UserApp {
    /**
     * permite definir aspectos importantes sobre las columnas de la base de datos como lo es el nombre, la longitud, etc
     */
    @Column(name = "name")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre name
     */
    private String name;

    /**
     * Constructor vacio
     */
    public Official(){

    }

    /**
     * Constructor que incluye las 4 variables alfanumerica String de nombre username, password, email y name
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Email del usuario registrado email!= null, email!=" "
     * @param name Nombre del usuario registrado name!= null, name!=" "
     */
    public Official(String username, String password, String email, String name) {
        super(username, password, email, "Official");
        this.name = name;
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
