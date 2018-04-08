package coloca.user.models.destination;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import coloca.user.models.ErrorModel;

public class DestinationModel {
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private List<DestinationResult> list;

    public DestinationModel(String error, List<DestinationResult> list) {
        this.error = error;
        this.list = list;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DestinationResult> getList() {
        return list;
    }

    public void setList(List<DestinationResult> list) {
        this.list = list;
    }
}
