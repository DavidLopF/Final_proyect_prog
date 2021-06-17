package resources.Pojos;

public class VisitPOJO {

    private int visitId;
    private String createAt;
    private String type;
    private String descripcion;
    private int pet_id;
    private String vet_id;

    public VisitPOJO(int visitId, String createAt, String type, String descripcion, int pet_id, String vet_id) {
        this.visitId = visitId;
        this.createAt = createAt;
        this.type = type;
        this.descripcion = descripcion;
        this.pet_id = pet_id;
        this.vet_id = vet_id;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getVet_id() {
        return vet_id;
    }

    public void setVet_id(String vet_id) {
        this.vet_id = vet_id;
    }
}
