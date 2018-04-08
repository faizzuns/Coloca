package coloca.user.models.destination;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 18/03/2018.
 */

public class DestinationResult {
    @SerializedName("")
    @Expose
    private int id;
    @SerializedName("")
    @Expose
    private String imgUrl;
    @SerializedName("")
    @Expose
    private String city;
    @SerializedName("")
    @Expose
    private String province;
    @SerializedName("")
    @Expose
    private String country;
    @SerializedName("")
    @Expose
    private String timezone;
    @SerializedName("")
    @Expose
    private String destinationName;
    @SerializedName("")
    @Expose
    private int estimateCost;
    @SerializedName("")
    @Expose
    private int rating;

    public DestinationResult(int id, String imgUrl, String destinationName) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.destinationName = destinationName;
    }

    public DestinationResult(int id, String imgUrl, String city, String province, String country, String timezone, String destinationName, int estimateCost, int rating) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.city = city;
        this.province = province;
        this.country = country;
        this.timezone = timezone;
        this.destinationName = destinationName;
        this.estimateCost = estimateCost;
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getTimezone() {
        return timezone;
    }

    public int getEstimateCost() {
        return estimateCost;
    }

    public int getRating() {
        return rating;
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

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
}
