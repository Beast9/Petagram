package beast9.com.recyclerview.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ian-Industries on 14/06/2016.
 */
public class Mascota {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int likes = 0;

    public Mascota(String urlFoto, String nombreCompleto, int likes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public Mascota() {

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
