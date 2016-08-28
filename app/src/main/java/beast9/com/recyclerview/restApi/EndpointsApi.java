package beast9.com.recyclerview.restApi;


import beast9.com.recyclerview.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ian-Industries on 21/08/2016.
 */
public interface EndpointsApi {

    @GET(constantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();
}
