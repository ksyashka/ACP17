
package reflection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by ksyashka on 15.04.2017.
 */

public class GsonSerializer {

    // any Object to json
    public static String convertObjectToJson(Object objects) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(objects);
    }

}

