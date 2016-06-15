package beast9.com.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ian-Industries on 15/06/2016.
 */
public class TopActivity extends AppCompatActivity implements Serializable{


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarTop);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaMascotas = (RecyclerView)findViewById(R.id.rvTop);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);


        inicializarListaMascota();

        inicializarAdaptador();
    }


    public void inicializarListaMascota()
    {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.husky, "Husky Siveriano", 0));
        mascotas.add(new Mascota(R.drawable.boxer, "Boxer", 0));
        mascotas.add(new Mascota(R.drawable.aleman, "Pastor Aleman", 0));
        mascotas.add(new Mascota(R.drawable.labrador, "Labrador", 0));

    }

    public void inicializarAdaptador()
    {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adaptador);
    }



}
