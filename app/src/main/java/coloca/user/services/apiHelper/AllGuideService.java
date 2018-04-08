package coloca.user.services.apiHelper;

import coloca.user.models.guide.AllTourGuideModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AllGuideService {
    @GET("account/guide")
    Call<AllTourGuideModel> callAllGuide(@Query("name") String name, @Query("city") String city, @Query("limit") int limit, @Query("offset") int offset);
}
