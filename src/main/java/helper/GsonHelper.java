package helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {

    public static Gson getGson() throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy HH:mm");
        Gson oGson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
        return oGson;
    }
}
