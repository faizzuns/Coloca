package coloca.user.models.guide;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TourGuideModel {
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private TourGuideResult tourGuideResult;

    public TourGuideModel(String error, TourGuideResult tourGuideResult) {
        this.error = error;
        this.tourGuideResult = tourGuideResult;
    }

    public String getError() {
        return error;
    }

    public TourGuideResult getTourGuideResult() {
        return tourGuideResult;
    }
}
