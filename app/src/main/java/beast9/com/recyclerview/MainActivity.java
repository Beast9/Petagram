package beast9.com.recyclerview;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();

        inicializarAdaptador();

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
        MascotaAdapter adaptador = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adaptador);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.top5:
                Intent i = new Intent(MainActivity.this,TopActivity.class);
                startActivity(i);
                break;

            case R.id.settings:break;
        }

        return super.onOptionsItemSelected(item);
    }


}
