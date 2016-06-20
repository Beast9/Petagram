package beast9.com.recyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import beast9.com.recyclerview.R;
import beast9.com.recyclerview.adapter.MascotaAdapter;
import beast9.com.recyclerview.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        inicializarAdaptador();

        return v;
    }


    public void inicializarListaMascota()
    {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.aleman, "Pastor Aleman", 0));
        mascotas.add(new Mascota(R.drawable.labrador, "Labrador", 0));
        mascotas.add(new Mascota(R.drawable.salchicha, "Salchicha", 0));
        mascotas.add(new Mascota(R.drawable.pug, "Pug", 0));
        mascotas.add(new Mascota(R.drawable.rottweiler, "Rottweiler", 0));
        mascotas.add(new Mascota(R.drawable.boxer, "Boxer", 0));
        mascotas.add(new Mascota(R.drawable.husky, "Husky Siveriano", 0));
    }

    public void inicializarAdaptador()
    {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

}
