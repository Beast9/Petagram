package beast9.com.recyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import beast9.com.recyclerview.R;
import beast9.com.recyclerview.adapter.MascotaAdapter;
import beast9.com.recyclerview.adapter.PerfilMascotaAdapter;
import beast9.com.recyclerview.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment {

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public PerfilMascotaFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvPerfilMascotas);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        llm.setOrientation(GridLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        //inicializarAdaptador();

        return v;
    }

    public void inicializarListaMascota()
    {
        /*
        mascotas = new ArrayList<Mascota>();


        mascotas.add(new Mascota(R.drawable.spike, "Pastor Aleman", 54));
        mascotas.add(new Mascota(R.drawable.spike2, "Pastor Aleman", 30));
        mascotas.add(new Mascota(R.drawable.spike3, "Pastor Aleman", 24));
        mascotas.add(new Mascota(R.drawable.spike4, "Pastor Aleman", 5));
        mascotas.add(new Mascota(R.drawable.spike5, "Pastor Aleman", 2));
        mascotas.add(new Mascota(R.drawable.spike6, "Pastor Aleman", 0));

        */

    }

    public void inicializarAdaptador()
    {
        PerfilMascotaAdapter adaptador = new PerfilMascotaAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

}
