package beast9.com.recyclerview.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import beast9.com.recyclerview.restApi.EndpointsApi;
import beast9.com.recyclerview.restApi.constantesRestApi;
import beast9.com.recyclerview.restApi.deserealizador.MascotaDeserealizador;
import beast9.com.recyclerview.restApi.model.MascotaResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ian-Industries on 22/08/2016.
 */
public class RestApiAdapter {

    public EndpointsApi establecerConexionResApiInstagram(Gson gson)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(constantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserealizadorMediaResent()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserealizador());

        return gsonBuilder.create();
    }
}
