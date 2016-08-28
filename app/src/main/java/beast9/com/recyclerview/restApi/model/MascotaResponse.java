package beast9.com.recyclerview.restApi.model;

import java.util.ArrayList;

import beast9.com.recyclerview.pojo.Mascota;

/**
 * Created by Ian-Industries on 21/08/2016.
 */
public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
