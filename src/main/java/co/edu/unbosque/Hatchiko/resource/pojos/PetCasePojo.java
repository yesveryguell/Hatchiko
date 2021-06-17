/**
 * Package that links co.edu.unbosque with resource and pojos
 */
package co.edu.unbosque.Hatchiko.resource.pojos;

import java.time.LocalDate;

/**
 * The pojos package serves to show the data that is stored in the tables, PetCasePojo, shows the information of the pet
 * cases table
 */
public class PetCasePojo {
    /**
     * Private type attribute with Integer numeric variable named case_id
     */
    private Integer case_id;
    /**
     * Private type attribute with alphanumeric variable String of name created_at
     */
    private String created_at;
    /**
     * Private type attribute with alphanumeric variable String of name type
     */
    private String type;
    /**
     * Private type attribute with alphanumeric variable String of name description
     */
    private String description;

    private Integer year;

    private Integer month;

    private Integer day;

    /**
     * Empty constructor
     */
    public PetCasePojo(){
    }
    /**
     * Constructor that includes the 4 numeric and alphanumeric variables Integer case_id, String created_at, type y description
     * @param case_id case id case_id!= null, case_id!=" "
     * @param created_at Case creation created_at!= null, created_at!=" "
     * @param type Case type type!= null, type!=" "
     * @param description Case description description!= null, description!=" "
     */
    public PetCasePojo(Integer case_id, String created_at, String type, String description) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }
    /**
     * Constructor that includes the 4 numeric and alphanumeric variables Integer case_id, String created_at, type y description
     * @param created_at Case creation created_at!= null, created_at!=" "
     * @param type Case type type!= null, type!=" "
     * @param description Case description description!= null, description!=" "
     */
    public PetCasePojo(String created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public PetCasePojo(Integer case_id, String type, String description, Integer year, Integer month, Integer day) {
        this.case_id = case_id;
        this.type = type;
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Gets the value of the case_id name attribute of type Integer
     * @return case_id
     */
    public Integer getCase_id() {
        return case_id;
    }

    /**
     * Update or modify the attribute name
     * @param case_id id del caso case_id!= null, case_id!=" "
     */
    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    /**
     *Gets the value of the name attribute created_at of type String
     * @return created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * Update or modify the attribute name
     * @param created_at Case creation created_at!= null, created_at!=" "
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    /**
     * Gets the value of the name attribute type of type String
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Update or modify the attribute name
     * @param type Case type type!= null, type!=" "
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Gets the value of the name attribute description of type String
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Update or modify the attribute name
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
