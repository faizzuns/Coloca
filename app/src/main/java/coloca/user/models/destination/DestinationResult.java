package coloca.user.models.destination;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 18/03/2018.
 */

public class DestinationResult {
    private int id;
    private int imgUrl;
    private String destinationName;

    public DestinationResult(int id, int imgUrl, String destinationName) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.destinationName = destinationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
}
