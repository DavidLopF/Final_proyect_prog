package resources.Pojos;

public class PetPOJO {
    private int id;
    private String owner;
    private long microship;
    private String name;
    private String specie;
    private String race;
    private String size;
    private String sex;
    private String url;

    private String image;

    public PetPOJO(int id, String owner, long microship, String name, String specie, String race, String size, String sex, String url) {
        this.id = id;
        this.owner = owner;
        this.microship = microship;
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getMicroship() {
        return microship;
    }

    public void setMicroship(long microship) {
        this.microship = microship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
