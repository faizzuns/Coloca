package coloca.user.models.guide;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 18/03/2018.
 */

public class TourGuideResult {
    @SerializedName("id_guide")
    @Expose
    private int idGuide;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("")
    @Expose
    private List<String> listLanguage;
    @SerializedName("")
    @Expose
    private List<String> listLocation;

    public TourGuideResult(int idGuide, String email, String name, int rating, String imgUrl, String phone, List<String> listLanguage, List<String> listLocation) {
        this.idGuide = idGuide;
        this.email = email;
        this.name = name;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.phone = phone;
        this.listLanguage = listLanguage;
        this.listLocation = listLocation;
    }

    public List<String> getListLocation() {
        return listLocation;
    }

    public List<String> getListLanguage() {
        return listLanguage;
    }

    public int getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(int idGuide) {
        this.idGuide = idGuide;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
