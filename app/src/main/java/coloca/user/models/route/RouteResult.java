package coloca.user.models.route;

/**
 * Created by User on 21/03/2018.
 */

public class RouteResult {
    private String iconAwal;
    private String iconAkhir;
    private String txtAwal;
    private String txtAkhir;

    public RouteResult(String iconAwal, String iconAkhir, String txtAwal, String txtAkhir) {
        this.iconAwal = iconAwal;
        this.iconAkhir = iconAkhir;
        this.txtAwal = txtAwal;
        this.txtAkhir = txtAkhir;
    }

    public String getIconAkhir() {
        return iconAkhir;
    }

    public String getTxtAwal() {
        return txtAwal;
    }

    public String getIconAwal() {
        return iconAwal;
    }

    public String getTxtAkhir() {
        return txtAkhir;
    }
}
