package beast9.com.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ian-Industries on 14/06/2016.
 */
public class Mascota {

    private int foto;
    private String nombre;
    private int raiting;

    public Mascota(int foto, String nombre, int raiting)
    {
        this.foto = foto;
        this.nombre = nombre;
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }


}
