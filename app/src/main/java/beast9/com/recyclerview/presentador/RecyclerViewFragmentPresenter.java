package beast9.com.recyclerview.presentador;

import android.content.Context;

import java.util.ArrayList;

import beast9.com.recyclerview.adapter.MascotaAdapter;
import beast9.com.recyclerview.db.ConstructorMascotas;
import beast9.com.recyclerview.fragment.IRecyclerViewFragmentView;
import beast9.com.recyclerview.pojo.Mascota;

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
        obtenerContactosBaseDatos();
    }


    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinerLayoutVertical();
    }
}
