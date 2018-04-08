package coloca.user.models.guide;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllTourGuideModel {
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private List<TourGuideData> list;

    public AllTourGuideModel(String error, List<TourGuideData> list) {
        this.error = error;
        this.list = list;
    }

    public String getError() {
        return error;
    }

    public List<TourGuideData> getList() {
        return list;
    }

    public class TourGuideData {
        @SerializedName("id_guide")
        @Expose
        private int idGuide;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("rating")
        @Expose
        private int rating;
        @SerializedName("img_url")
        @Expose
        private String imgUrl;
        @SerializedName("")
        @Expose
        private List<String> listLanguage;
        @SerializedName("")
        @Expose
        private List<String> listLocation;

        public TourGuideData(int idGuide, String name, int rating, String imgUrl, List<String> listLanguage, List<String> listLocation) {
            this.idGuide = idGuide;
            this.name = name;
            this.rating = rating;
            this.imgUrl = imgUrl;
            this.listLanguage = listLanguage;
            this.listLocation = listLocation;
        }

        public List<String> getListLanguage() {
            return listLanguage;
        }

        public List<String> getListLocation() {
            return listLocation;
        }

        public int getIdGuide() {
            return idGuide;
        }

        public String getName() {
            return name;
        }

        public int getRating() {
            return rating;
        }

        public String getImgUrl() {
            return imgUrl;
        }
    }
}
