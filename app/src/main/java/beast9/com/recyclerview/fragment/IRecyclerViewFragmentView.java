package beast9.com.recyclerview.fragment;

import java.util.ArrayList;

import beast9.com.recyclerview.adapter.MascotaAdapter;
import beast9.com.recyclerview.pojo.Mascota;

/**
 * Created by Ian-Industries on 23/06/2016.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinerLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdapter adaptador);
}
