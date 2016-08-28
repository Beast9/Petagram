package beast9.com.recyclerview.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import beast9.com.recyclerview.adapter.MascotaAdapter;
import beast9.com.recyclerview.db.ConstructorMascotas;
import beast9.com.recyclerview.fragment.IRecyclerViewFragmentView;
import beast9.com.recyclerview.pojo.Mascota;
import beast9.com.recyclerview.restApi.EndpointsApi;
import beast9.com.recyclerview.restApi.adapter.RestApiAdapter;
import beast9.com.recyclerview.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ian-Industries on 23/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context)
    {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
    }


    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMediosRecientes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserealizadorMediaResent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionResApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG);
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });

    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarGridLayoutVertical();
    }
}
