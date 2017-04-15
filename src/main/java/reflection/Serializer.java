package reflection;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Serializer {

    /*
{
  "id": 1,
  "model": "R2D2",
  "price": 10000,
  "commands": [
    "sing",
    "dance",
    "clean"
  ]
}
     */

    public String convertObjectToJSON(Object object){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Class cl = object.getClass();

        Field[] fields = cl.getDeclaredFields();

        for (Field f:fields) {
            String fieldName = f.getName();
            String firstUpperCaseLetter = fieldName.substring(0, 1).toUpperCase();
            sb.append(addQuotes(fieldName)).append(":");
            try {
                Method getFieldValue = cl.getMethod("get"+firstUpperCaseLetter+fieldName.substring(1));
                if (f.getType().isArray()){
                    sb.append(arrayToString((Object[])getFieldValue.invoke(object)));
                }
                else if (!f.getType().isPrimitive() && ! (String.class == f.getType()))sb.append(convertObjectToJSON(getFieldValue.invoke(object)));
                else sb.append(getFieldValue.invoke(object));
                sb.append(",");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.substring(0,sb.length()-1)+"}";
    }

    public Object convertJSONToObject(String json){
        return null;
    }

    private static String deleteQuotes(String value){
        return value.replace("\"","");
    }

    private static String addQuotes(Object value) {
        if (String.class == value.getClass())
            return "\""+value+"\"";
        else return value.toString();
    }

    private static String arrayToString(Object[] objects){
        String result = "[";
        for (Object o:objects){
            result += addQuotes(o.toString())+", ";
        }
        return result.substring(0,result.length()-2)+"]";
    }
}
