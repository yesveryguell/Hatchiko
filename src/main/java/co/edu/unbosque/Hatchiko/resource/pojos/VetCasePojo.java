package co.edu.unbosque.Hatchiko.resource.pojos;

public class VetCasePojo {

    private Integer case_id;
    private String crated_at;
    private String type;
    private String description;

    public VetCasePojo(){
    }

    public VetCasePojo(Integer case_id, String crated_at, String type, String description) {
        this.case_id = case_id;
        this.crated_at = crated_at;
        this.type = type;
        this.description = description;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public String getCrated_at() {
        return crated_at;
    }

    public void setCrated_at(String crated_at) {
        this.crated_at = crated_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
