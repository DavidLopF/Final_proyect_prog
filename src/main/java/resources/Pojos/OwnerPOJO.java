package resources.Pojos;

public class OwnerPOJO {

    private String name;
    private Integer person_id;
    private String address;
    private String neigboorhood;

    public OwnerPOJO(String name, Integer person_id, String address, String neigboorhood) {
        this.name = name;
        this.person_id = person_id;
        this.address = address;
        this.neigboorhood = neigboorhood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeigboorhood() {
        return neigboorhood;
    }

    public void setNeigboorhood(String neigboorhood) {
        this.neigboorhood = neigboorhood;
    }
}
