package resources.Pojos;

public class PicturePojo {
    private String description;
    private String namePicture;
    private String date;

    public PicturePojo(String description, String namePicture, String date) {
        this.description = description;
        this.namePicture = namePicture;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNamePicture() {
        return namePicture;
    }

    public void setNamePicture(String namePicture) {
        this.namePicture = namePicture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
