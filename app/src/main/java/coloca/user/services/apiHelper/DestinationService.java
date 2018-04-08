package coloca.user.services.apiHelper;

import coloca.user.models.destination.DestinationModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DestinationService {
    @GET("place/id/{id_destination}")
    Call<DestinationModel> callDestination(@Path("id_destination") int id);
}
