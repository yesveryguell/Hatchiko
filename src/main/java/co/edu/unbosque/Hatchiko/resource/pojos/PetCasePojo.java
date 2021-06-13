/**
 * Paquete que enlaza co.edu.unbosque con resource y pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;
/**
 * El paquete pojos sirve para mostrar los datos que se almacenan en las tablas, PetCasePojo, muestra la información
 * de la tabla de casos de mascotas
 */
public class PetCasePojo {
    /**
     * Atributo de tipo privado con variable numerica Integer de nombre case_id
     */
    private Integer case_id;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre created_at
     */
    private String created_at;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre type
     */
    private String type;
    /**
     * Atributo de tipo privado con variable alfanumerica String de nombre description
     */
    private String description;
    /**
     * Constructor vacio
     */
    public PetCasePojo(){
    }
    /**
     * Constructor que incluye las 4 variables numericas y alfanumerica Integer case_id, String created_at, type y description
     * @param case_id id del caso case_id!= null, case_id!=" "
     * @param created_at Creacion del caso created_at!= null, created_at!=" "
     * @param type Tipo de caso type!= null, type!=" "
     * @param description Descripción del caso description!= null, description!=" "
     */
    public PetCasePojo(Integer case_id, String created_at, String type, String description) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }
    /**
     * Obtiene el valor del atributo de nombre case_id de tipo Integer
     * @return case_id
     */
    public Integer getCase_id() {
        return case_id;
    }
    /**
     * Actualizar o modificar el nombre del atributo
     * @param case_id id del caso case_id!= null, case_id!=" "
     */
    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
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
