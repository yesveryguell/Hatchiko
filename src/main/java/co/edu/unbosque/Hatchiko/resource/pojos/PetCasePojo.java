package co.edu.unbosque.Hatchiko.resource.pojos;

public class PetCasePojo {

    private Integer case_id;
    private String created_at;
    private String type;
    private String description;

    public PetCasePojo(){
    }

    public PetCasePojo(Integer case_id, String created_at, String type, String description) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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
