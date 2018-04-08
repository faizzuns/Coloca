package coloca.user.models.destination;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationResult {

    @SerializedName("id_destination")
    @Expose
    private int idDestination;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("timezone")
    @Expose
    private int timezone;
    @SerializedName("cost")
    @Expose
    private int cost;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("review")
    @Expose
    private List<Review> review = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public DestinationResult() {
    }

    /**
     *
     * @param imgUrl
     * @param timezone
     * @param idDestination
     * @param name
     * @param province
     * @param rating
     * @param cost
     * @param review
     * @param country
     * @param city
     */
    public DestinationResult(int idDestination, String name, String city, String province, String country, int timezone, int cost, String rating, String imgUrl, List<Review> review) {
        super();
        this.idDestination = idDestination;
        this.name = name;
        this.city = city;
        this.province = province;
        this.country = country;
        this.timezone = timezone;
        this.cost = cost;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.review = review;
    }

    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int idDestination) {
        this.idDestination = idDestination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

}