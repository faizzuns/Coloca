package coloca.user.services.apiHelper;

import coloca.user.models.route.RouteModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RouteService {
    @GET("place/route")
    Call<RouteModel> callRoute(@Query("origin") String origin, @Query("dest") String dest);
}
