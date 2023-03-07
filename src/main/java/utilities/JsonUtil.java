package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {
    private JsonUtil() {
    }
    private static final Logger LOGGER=Logger.getLogger(JsonUtil.class.getName());
    //объект в Json
    //по ощущениям, крайне опасная штука потенциально...
    public static String objectToJson(Object o) {
        try {
            return new GsonBuilder().setPrettyPrinting().create().toJson(o);
        }
        catch (Exception e){
            LOGGER.log(Level.SEVERE, "Ошибка преобразования в JSON");
            return null;
        }
    }
    //и еще более опасная....
    public static Object jsonToObject(String json,Class clazz) {
        try {
            return new Gson().fromJson(json, clazz);
        }
        catch (Exception e){
            LOGGER.log(Level.SEVERE, "Ошибка преобразования");
            return null;
        }
    }
    //коллекцию в json
    public static String listToJson(List<?> l) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(l);
    }
    //json обратно в коллекцию
    public static List<?> jsonToList(String json, Type type) {
        try {
            return new Gson().fromJson(json, type);
        }
        catch (Exception e){
            LOGGER.log(Level.SEVERE, "Ошибка преобразования");
            return null;
        }
    }
}
