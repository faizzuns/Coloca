package coloca.user.services.apiHelper;

import coloca.user.models.destination.AllPlaceModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TopTenService {
    @GET("place/top10")
    Call<AllPlaceModel> callTopTen();
}
