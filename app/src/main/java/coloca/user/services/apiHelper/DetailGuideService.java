package coloca.user.services.apiHelper;

import coloca.user.models.guide.AllTourGuideModel;
import coloca.user.models.guide.TourGuideModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DetailGuideService {
    @GET("account/guide/id/{id_guide}")
    Call<AllTourGuideModel> callDetailGuide(@Path("id_guide") int id);
}
