package beast9.com.recyclerview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import beast9.com.recyclerview.db.ConstructorMascotas;
import beast9.com.recyclerview.pojo.Mascota;
import beast9.com.recyclerview.R;

/**
 * Created by Ian-Industries on 14/06/2016.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

     ArrayList<Mascota> mascotas;
    Context context;



    public MascotaAdapter(ArrayList<Mascota> mascotas, Context context)
    {
        this.mascotas = mascotas;
        this.context = context;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoMascota;
        private ImageButton btnRai;
        private TextView tvNombre;
        private TextView tvRai;
        private ImageView fotoHueso;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            fotoMascota = (ImageView)itemView.findViewById(R.id.imgFoto);
            btnRai = (ImageButton)itemView.findViewById(R.id.imageButton);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvRai = (TextView)itemView.findViewById(R.id.tvRai);
            fotoHueso = (ImageView)itemView.findViewById(R.id.imgHueso);
        }
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.fotoMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRai.setText(String.valueOf(mascota.getRaiting()));

        holder.btnRai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mascota.setRaiting(mascota.getRaiting() + 1);

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(context);
                constructorMascotas.darRaitingMascota(mascota);

                holder.tvRai.setText(String.valueOf(constructorMascotas.obtenerRaitinMascota(mascota)));
                //notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}
