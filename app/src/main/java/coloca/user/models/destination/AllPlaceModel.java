package coloca.user.models.destination;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import coloca.user.models.ErrorModel;

public class AllPlaceModel {
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private List<PlaceData> list;

    public AllPlaceModel(String error, List<PlaceData> list) {
        this.error = error;
        this.list = list;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<PlaceData> getList() {
        return list;
    }

    public void setList(List<PlaceData> list) {
        this.list = list;
    }

    public class PlaceData{
        @SerializedName("id_destination")
        @Expose
        private int id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("img_url")
        @Expose
        private String imgUrl;

        public PlaceData(int id, String name, String imgUrl) {
            this.id = id;
            this.name = name;
            this.imgUrl = imgUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
