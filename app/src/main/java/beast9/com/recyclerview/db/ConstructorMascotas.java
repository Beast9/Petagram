package beast9.com.recyclerview.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import beast9.com.recyclerview.R;
import beast9.com.recyclerview.pojo.Mascota;

/**
 * Created by Ian-Industries on 23/06/2016.
 */
public class ConstructorMascotas {

    private static final int RAITING = 1;
    private Context context;

    public ConstructorMascotas(Context context)
    {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos()
    {
        /*ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.aleman, "Pastor Aleman", 6));
        mascotas.add(new Mascota(R.drawable.labrador, "Labrador", 12));
        mascotas.add(new Mascota(R.drawable.salchicha, "Salchicha", 65));
        mascotas.add(new Mascota(R.drawable.pug, "Pug", 34));
        mascotas.add(new Mascota(R.drawable.rottweiler, "Rottweiler", 45));
        mascotas.add(new Mascota(R.drawable.boxer, "Boxer", 7));
        mascotas.add(new Mascota(R.drawable.husky, "Husky Siveriano", 23));

        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarDatos(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarDatos(BaseDatos db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pastor Aleman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.aleman);
        db.insertarDatos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Labrador");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.labrador);
        db.insertarDatos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Salchicha");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.salchicha);
        db.insertarDatos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pug");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pug);
        db.insertarDatos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rottweiler");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.rottweiler);
        db.insertarDatos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Boxer");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.aleman);
        db.insertarDatos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Husky Siveriano");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.husky);
        db.insertarDatos(contentValues);
    }


    public void darRaitingMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_RAITING, RAITING);
        db.insertarRaitingMAscota(contentValues);
    }

    public int obtenerRaitinMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRaitingMascota(mascota);
    }

}
