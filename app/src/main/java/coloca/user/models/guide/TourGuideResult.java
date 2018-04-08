package coloca.user.models.guide;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 18/03/2018.
 */

public class TourGuideResult {
    @SerializedName("")
    @Expose
    private int id;
    @SerializedName("")
    @Expose
    private String imgUrl;
    @SerializedName("")
    @Expose
    private String name;
    @SerializedName("")
    @Expose
    private String email;
    @SerializedName("")
    @Expose
    private String phone;
    @SerializedName("")
    @Expose
    private List<String> location;
    @SerializedName("")
    @Expose
    private List<String> language;

    public TourGuideResult(int id, String imgUrl, String name) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public TourGuideResult(int id, String imgUrl, String name, List<String> location, List<String> language) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.location = location;
        this.language = language;
    }

    public TourGuideResult(int id, String imgUrl, String name, String email, String phone, List<String> location, List<String> language) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.language = language;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getLocation() {
        return location;
    }

    public List<String> getLanguage() {
        return language;
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
