package beast9.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import beast9.com.recyclerview.R;
import beast9.com.recyclerview.pojo.Mascota;

/**
 * Created by Ian-Industries on 17/06/2016.
 */
public class PerfilMascotaAdapter extends RecyclerView.Adapter<PerfilMascotaAdapter.PerfilMascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Context context;

    public PerfilMascotaAdapter(ArrayList<Mascota> mascotas, Context context)
    {
        this.mascotas = mascotas;
        this.context = context;
    }

    public static class PerfilMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoMascota;
        private TextView tvRai;


        public PerfilMascotaViewHolder(View itemView) {
            super(itemView);
            fotoMascota = (ImageView)itemView.findViewById(R.id.imgFotoPerfil);
            tvRai = (TextView)itemView.findViewById(R.id.tvRaiPerfil);

        }
    }

    @Override
    public PerfilMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil_mascota, parent, false);
        return new PerfilMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilMascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        //holder.fotoMascota.setImageResource(mascota.getUrlFoto());
        holder.tvRai.setText(String.valueOf(mascota.getLikes()));


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}
