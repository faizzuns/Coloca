package coloca.user.models.guide;

/**
 * Created by User on 18/03/2018.
 */

public class TourGuideResult {
    private int id;
    private String imgUrl;
    private String name;
    private String location;
    private String language;

    public TourGuideResult(int id, String imgUrl, String name) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public TourGuideResult(int id, String imgUrl, String name, String location, String language) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.location = location;
        this.language = language;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
