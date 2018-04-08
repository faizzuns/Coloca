package coloca.user.services.apiHelper;

import coloca.user.models.destination.AllPlaceModel;
import coloca.user.models.destination.DestinationModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceService {
    @GET("place")
    Call<AllPlaceModel> callPlace(@Query("search") String keyword, @Query("limit") int limit, @Query("offset") int offset);
}
