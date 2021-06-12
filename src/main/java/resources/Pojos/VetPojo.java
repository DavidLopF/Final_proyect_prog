package resources.Pojos;

public class VetPojo {

    private String userName;
    private String name;
    private String addreess;
    private String neighborhood;
    private Integer vetId;

    public VetPojo(String userName, String name, String addreess, String neighborhood) {
        this.userName = userName;
        this.name = name;
        this.addreess = addreess;
        this.neighborhood = neighborhood;
    }

    public VetPojo(String userName, String name, String addreess, String neighborhood, Integer vetId) {
        this.userName = userName;
        this.name = name;
        this.addreess = addreess;
        this.neighborhood = neighborhood;
        this.vetId = vetId;
    }

    public VetPojo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddreess() {
        return addreess;
    }

    public void setAddreess(String addreess) {
        this.addreess = addreess;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getVetId() {
        return vetId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }
}
