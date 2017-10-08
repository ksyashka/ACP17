package testtask.distinctwordsintext;

import java.util.ArrayList;
import java.util.HashMap;

public class TextUtils {

    public static ArrayList<String> getDistinctWords(String string){

        if (string == null || "".equals(string)) return new ArrayList<>();

        String[] allWords = getAllWords(string);

        HashMap<String, Integer> map = new HashMap<>();
        for (String s:allWords) {
            map.put(s,1);
        }

        return new ArrayList<String>(map.keySet());
    }

    public static String[] getAllWords(String string){
        String[] allWords=string.
                replace(".","").
                replace(";","").
                replace("!","").
                replace("?","").
                replace(":","").
                replace(",","").
                toLowerCase().
                split(" ");
        return allWords;
    }
}
