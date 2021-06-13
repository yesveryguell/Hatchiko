/**
 * Paquete que enlaza co.edu.unbosque con resource y pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;

import javax.persistence.Column;

/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas, PetCasePojo, muestra la información
 * de la tabla de casos de mascotas
 */
public class VisitPojo {
    /**
     * Atributo de tipo privado con variable numerica Integer de nombre visit_id
     */
    private int visit_id;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre created_at
     */
    private String created_at;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre type
     */
    private String type;
    @Column(name = "description")
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre description
     */
    private String description;
    /**
     * Constructor vacio
     */
    public VisitPojo() {
    }

    /**
     * Constructor que incluye las 4 variables numericas y alfanumericas Integer visit_idString created_at, type, description
     * @param visit_id id de visitas visit_id!= null, visit_id!=" "
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     * @param type Tipo de caso type!= null, type!=" "
     * @param description Descripción del caso description!= null, description!=" "
     */
    public VisitPojo(int visit_id, String created_at, String type, String description) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    /**
     * Constructor que incluye las 3 variables alfanumerica String created_at, type, description
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     * @param type Tipo de caso type!= null, type!=" "
     * @param description Descripción del caso description!= null, description!=" "
     */
    public VisitPojo(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }
    /**
     * Obtiene el valor del atributo de nombre visit_id de tipo Integer
     * @return visit_id
     */
    public Integer getVisit_id() {
        return visit_id;
    }

    /**
     * Actualizar o modificar el nombre del atributo
     * @param visit_id id de las visitas visit_id!= null, visit_id!=" "
     */
    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }
    /**
     * Obtiene el valor del atributo de nombre created_at de tipo String
     * @return created_at
     */
    public String getCreated_at() {
        return created_at;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    /**
     * Obtiene el valor del atributo de nombre type de tipo String
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param type Tipo de caso type!= null, type!=" "
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Obtiene el valor del atributo de nombre description de tipo String
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param description Descripción del caso description!= null, description!=" "
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
