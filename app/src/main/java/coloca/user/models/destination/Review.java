package coloca.user.models.destination;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("polaritas")
    @Expose
    private String polaritas;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("tweet")
    @Expose
    private String tweet;
    @SerializedName("tweetbersih")
    @Expose
    private String tweetbersih;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     * No args constructor for use in serialization
     *
     */
    public Review() {
    }

    /**
     *
     * @param username
     * @param polaritas
     * @param tweetbersih
     * @param tweet
     * @param screenName
     * @param date
     */
    public Review(String date, String polaritas, String screenName, String tweet, String tweetbersih, String username) {
        super();
        this.date = date;
        this.polaritas = polaritas;
        this.screenName = screenName;
        this.tweet = tweet;
        this.tweetbersih = tweetbersih;
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPolaritas() {
        return polaritas;
    }

    public void setPolaritas(String polaritas) {
        this.polaritas = polaritas;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getTweetbersih() {
        return tweetbersih;
    }

    public void setTweetbersih(String tweetbersih) {
        this.tweetbersih = tweetbersih;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}