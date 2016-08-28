package beast9.com.recyclerview.restApi;

/**
 * Created by Ian-Industries on 21/08/2016.
 */
public final class constantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "49670417.cd1974a.017c618e5bbb4dbb8f600e7e6b713c89";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN ;
    //https://api.instagram.com/v1/users/self/?access_token=ACCESS-TOKEN
}
