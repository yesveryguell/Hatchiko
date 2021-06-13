/**
 * Paquete que enlaza co.edu.unbosque con jpa y entities
 */
package co.edu.unbosque.Hatchiko.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "Vet")
/**
 * Esta anotación especifica una columna de clave principal que se utiliza como clave externa para unirse a otra tabla.
 */
@PrimaryKeyJoinColumn
/**
 * Clase publica de nombre Owner que extiende de la clase madre UserApp (relacion 1 a muchos)
 */
public class Vet extends UserApp{
    /**
     * permite definir aspectos importantes sobre las columnas de la base de datos como lo es el nombre, la longitud, etc
     */
    @Column(name = "name")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre name
     */
    private String name;
    /**
     * Define el nombre address para la columna
     */
    @Column(name = "address")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre address
     */
    private String address;
    /**
     * Define el nombre address para la columna
     */
    @Column(name = "neighborhood")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre neighborhood
     */
    private String neighborhood;
    /**
     * Las relaciones uno a muchos se caracterizan por Entidad donde tenemos un objeto principal y colección
     * de objetos de otra Entidad relacionados directamente. Estas relaciones se definen mediante colecciones
     */
    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    /**
     * Atributo que contiene una variable Lista de nombre visits que nos ayudara a listar las visitas realizadas
     */
    private List<Visit> visits = new ArrayList<>();

    /**
     * Constructor vacio
     */
    public Vet(){

    }

    /**
     * Constructor que incluye las 7 variables alfanumerica String de nombre username, password, email,
     * address, neighborhood  y name
     * @param username Nombre de usuario registrado username!= null, username!=" "
     * @param password Contraseña del usuario registrado password!= null, password!=" "
     * @param email Contraseña del usuario registrado password!= null, password!=" "
     * @param name Nombre del usuario registrado name!= null, name!=" "
     * @param address Direccion del usuario registrado address!= null, address!=" "
     * @param neighborhood Vecindario del usuario registrado neighborhood!= null, neighborhood!=" "
     */
    public Vet(String username, String password, String email, String name, String address, String neighborhood) {
        super(username, password, email, "Vet");
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
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
     * Actualizar o modificar el nombre del atributo
     * @param neighborhood Vecindario del usuario registrado neighborhood!= null, neighborhood!=" "
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    /**
     * Obtiene el valor del atributo de nombre visits de tipo List
     * @return visits
     */
    public List<Visit> getVisits() {
        return visits;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param visit visitas visit!= null, visit!=" "
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setVet(this);
    }
}
