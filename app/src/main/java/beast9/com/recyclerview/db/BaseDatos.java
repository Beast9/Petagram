package beast9.com.recyclerview.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import beast9.com.recyclerview.pojo.Mascota;

/**
 * Created by Ian-Industries on 23/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotaa = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS+ "(" +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                                        ")";
        String queryCrearTablaRaitingMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS+ "(" +
                                        ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTA + " INTEGER , " +
                                        ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_RAITING + " INTEGER, " +
                                        "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTA + ") " +
                                        "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTAS + "("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+")"+
                                        ")";

        db.execSQL(queryCrearTablaMascotaa);
        db.execSQL(queryCrearTablaRaitingMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext())
        {
            /*
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryRai = "SELECT COUNT("+ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_RAITING+") as rai " +
                                " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS +
                                " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTA + " = " + mascotaActual.getId();

            Cursor registrosRai = db.rawQuery(queryRai,null);
            if (registrosRai.moveToNext())
            {
                mascotaActual.setRaiting(registrosRai.getInt(0));
            }else {
                mascotaActual.setRaiting(0);
            }

            mascotas.add(mascotaActual);
            */
        }

        db.close();

        return mascotas;
    }

    public void insertarDatos(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }


    public void insertarRaitingMAscota(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAITING_MASCOTAS, null, contentValues);
        db.close();
    }


    public int obtenerRaitingMascota(Mascota mascota)
    {
        int rai = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_RAITING+")" +
                        " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS +
                        " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTAS_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext())
        {
            rai = registros.getInt(0);
        }

        db.close();

        return  rai;
    }

}
