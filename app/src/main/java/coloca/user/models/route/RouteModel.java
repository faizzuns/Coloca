package coloca.user.models.route;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RouteModel {
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private List<RouteResult> list;

    public RouteModel(String error, List<RouteResult> list) {
        this.error = error;
        this.list = list;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<RouteResult> getList() {
        return list;
    }

    public void setList(List<RouteResult> list) {
        this.list = list;
    }
}
