package resources.Pojos;

public class CasePOJO {
    private int id;
    private String createdAt;
    private String type;
    private String description;
    private Integer pet_id;
    public CasePOJO(){

    }

    public CasePOJO(String createdAt, String type, String description, Integer pet_id) {
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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
