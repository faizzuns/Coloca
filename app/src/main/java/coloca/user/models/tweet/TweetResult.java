package coloca.user.models.tweet;

/**
 * Created by User on 18/03/2018.
 */

public class TweetResult {
    private int id;
    private String username;
    private String time;
    private String tweet;

    public TweetResult(int id, String username, String time, String tweet) {
        this.id = id;
        this.username = username;
        this.time = time;
        this.tweet = tweet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
