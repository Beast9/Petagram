package beast9.com.recyclerview.restApi.deserealizador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

import beast9.com.recyclerview.pojo.Mascota;
import beast9.com.recyclerview.restApi.JsonKeys;
import beast9.com.recyclerview.restApi.model.MascotaResponse;

/**
 * Created by Ian-Industries on 23/08/2016.
 */
public class MascotaDeserealizador implements JsonDeserializer<MascotaResponse>{
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(DeserealizarContactoDeJson(mascotaResponseData));

        return mascotaResponse;
    }


    private ArrayList<Mascota> DeserealizarContactoDeJson(JsonArray mascotaResponseData)
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int i = 0; i < mascotaResponseData.size(); i++)
        {
            //desearealizar todos los json para estraer sus valores
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            JsonObject userJson      = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id                = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombre_completo   = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson         = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto               = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes            = likesJson.getAsJsonObject(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            //hacemos el objeto llenando todos sus datos
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setNombreCompleto(nombre_completo);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setLikes(likes);

            //metemos el objeto en el arrayList de objetos
            mascotas.add(mascotaActual);
        }

        return mascotas;
    }
}
