package coloca.user.models.route;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import coloca.user.R;

public class RouteResult {

    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("transport_type")
    @Expose
    private int transportType;
    @SerializedName("transport_name")
    @Expose
    private String transportName;
    @SerializedName("dest")
    @Expose
    private String dest;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("cost")
    @Expose
    private String cost;

    /**
     * No args constructor for use in serialization
     *
     */
    public RouteResult() {
    }

    /**
     *
     * @param distance
     * @param dest
     * @param origin
     * @param cost
     * @param transportName
     * @param transportType
     */
    public RouteResult(String origin, int transportType, String transportName, String dest, String distance, String cost) {
        super();
        this.origin = origin;
        this.transportType = transportType;
        this.transportName = transportName;
        this.dest = dest;
        this.distance = distance;
        this.cost = cost;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getTransportType() {
        return transportType;
    }

    public void setTransportType(int transportType) {
        this.transportType = transportType;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getIconAwal(){return "http://1.bp.blogspot.com/-s0M7sTp5Ilo/U2YhWZ9qLjI/AAAAAAAAA2s/h6yqW10rGdA/s1600/Trayek+06+angkot+bogor.png";}

    public String getIconAkhir() {return "http://1.bp.blogspot.com/-s0M7sTp5Ilo/U2YhWZ9qLjI/AAAAAAAAA2s/h6yqW10rGdA/s1600/Trayek+06+angkot+bogor.png";}


}