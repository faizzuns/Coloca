package coloca.user.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 26/03/2018.
 */

public class ErrorModel {
    @SerializedName("msg")
    @Expose
    private String msg;

    public ErrorModel(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
