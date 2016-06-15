package beast9.com.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ian-Industries on 14/06/2016.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

     ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas)
    {
        this.mascotas = mascotas;
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
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.fotoMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRai.setText(String.valueOf(mascota.getRaiting()));
        holder.btnRai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setRaiting(mascota.getRaiting() + 1);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}
