package resources.Pojos;

public class PetCasePOJO {
    private String created_id;
    private String type;
    private String description;
    private Integer pet_id;

    public PetCasePOJO(String created_id, String type, String description, Integer pet_id) {
        this.created_id = created_id;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
    }

    public String getCreated_id() {
        return created_id;
    }

    public void setCreated_id(String created_id) {
        this.created_id = created_id;
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

    public Integer getPet_id() {
        return pet_id;
    }

    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }
}
