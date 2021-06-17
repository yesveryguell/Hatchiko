/**
 * Package that links co.edu.unbosque with resource and pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas, PetCasePojo, muestra la información
 * de la tabla de casos de mascotas
 */
public class VisitPojo {
    /**
     * Private type attribute with Integer numeric variable named visit_id
     */
    private int visit_id;
    /**
     * Private type attribute with alphanumeric variable String of name created_at
     */
    private String created_at;
    /**
     * Private type attribute with alphanumeric variable String of name type
     */
    private String type;
    @Column(name = "description")
    /**
     * Private type attribute with alphanumeric variable String of name description
     */
    private String description;
    /**
     * Empty constructor
     */

    private Integer year;

    private Integer month;

    private Integer day;

    public VisitPojo() {
    }

    /**
     * Constructor 1 that includes the 4 numeric and alphanumeric variables Integer visit_idString created_at, type, description
     *
     * @param visit_id    visitor id visit_id!= null, visit_id!=" "
     * @param created_at  Case creation created_at!= null, created_at!=" "
     * @param type        Case type type!= null, type!=" "
     * @param description Case description description!= null, description!=" "
     */
    public VisitPojo(int visit_id, String created_at, String type, String description) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    /**
     * Constructor 2 that includes the 3 alphanumeric variables String created_at, type y description
     *
     * @param created_at  Case creation created_at!= null, created_at!=" "
     * @param type        Case type type!= null, type!=" "
     * @param description Case description description!= null, description!=" "
     */
    public VisitPojo(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public VisitPojo(int visit_id, String type, String description, Integer year, Integer month, Integer day) {
        this.visit_id = visit_id;
        this.type = type;
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Gets the value of the name attribute visit_id of type Integer
     *
     * @return visit_id
     */
    public Integer getVisit_id() {
        return visit_id;
    }

    /**
     * Update or modify the attribute name
     *
     * @param visit_id visitor id visit_id!= null, visit_id!=" "
     */
    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    /**
     * Gets the value of the name attribute created_at of type String
     *
     * @return created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * Update or modify the attribute name
     *
     * @param created_at Case creation created_at!= null, created_at!=" "
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * Gets the value of the name attribute type of type String
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Update or modify the attribute name
     *
     * @param type Case type type!= null, type!=" "
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the value of the name attribute description of type String
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Update or modify the attribute name
     *
     * @param description Case description description!= null, description!=" "
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
