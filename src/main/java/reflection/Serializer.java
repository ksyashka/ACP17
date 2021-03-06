package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Serializer {

    /*
{"id":1,"model":"R2D2","price":10000,"commands":["sing","dance","clean"],"cat":{"name":"Vasia"}}
     */

    public String convertObjectToJSON(Object object) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Class cl = object.getClass();

        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields) {
            String fieldName = f.getName();
            sb.append(addQuotes(fieldName)).append(":");
            try {
                Method getFieldValue = cl.getMethod("get" + stringWithFirstUpperCaseLetter(fieldName));
                if (f.getType().isArray()) {
                    sb.append(arrayToString((Object[]) getFieldValue.invoke(object)));
                } else if (!f.getType().isPrimitive() && !(String.class == f.getType()))
                    sb.append(convertObjectToJSON(getFieldValue.invoke(object)));
                else sb.append(addQuotes(getFieldValue.invoke(object)));
                sb.append(",");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.substring(0, sb.length() - 1) + "}";
    }

    /*
{"id":1,"model":"R2D2","price":10000,"commands":["sing","dance","clean"],"cat":{"name":"Vasia"}}
     */
    public Object convertJSONToObject(String json, Class cl) {

        json = json.substring(1, json.length() - 1);
        String[] lines = json.split(",");

        Map<String, String> keyValuesMap = new HashMap<>();
        String previousKeyValue = null;
        for (int i = 0; i < lines.length; i++) {
            String[] keyValue = lines[i].split(":");
            if (keyValue.length == 1) keyValuesMap.put(previousKeyValue,
                    (keyValuesMap.get(previousKeyValue) + "," + deleteQuotes(keyValue[0])));
            else if (keyValue.length == 2) {
                keyValuesMap.put(deleteQuotes(keyValue[0]), deleteQuotes(keyValue[1]));
                previousKeyValue = deleteQuotes(keyValue[0]);
            }
        }
        try {
            Object instance = cl.newInstance();

            for (String key : keyValuesMap.keySet()) {
                Field field = cl.getDeclaredField(key);
                Class<?> fieldType = field.getType();
                Method setMethod = cl.getMethod("set" + stringWithFirstUpperCaseLetter(key), fieldType);
                if (String.class == fieldType) {
                    setMethod.invoke(instance, keyValuesMap.get(key));
                } else if (int.class == fieldType || Integer.class == fieldType) {
                    setMethod.invoke(instance, Integer.parseInt(keyValuesMap.get(key)));
                } else if (double.class == fieldType || Double.class == fieldType) {
                    setMethod.invoke(instance, Double.parseDouble(keyValuesMap.get(key)));
                } else if (fieldType.isArray()) {
                    setMethod.invoke(instance, (Object) stringToArray(keyValuesMap.get(key)));
                }
            }
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Object[] stringToArray(String str) {
        return str.substring(1, str.length() - 1).split(",");

    }

    private static String deleteQuotes(String value) {
        return value.replace("\"", "");
    }

    private static String addQuotes(Object value) {
        if (value == null) return "";
        if (String.class == value.getClass())
            return "\"" + value + "\"";
        else return value.toString();
    }

    private static String arrayToString(Object[] objects) {
        String result = "[";
        for (Object o : objects) {
            result += addQuotes(o.toString()) + ",";
        }
        return result.substring(0, result.length() - 1) + "]";
    }

    private String stringWithFirstUpperCaseLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private List<String> findClasses(String json){
        Stack<Integer> stack = new Stack();
        int first, last;
        for (int i = 0; i< json.length(); i++){
            if(json.charAt(i)=='{')
                stack.push(i);
            if(json.charAt(i)=='}')
                if (stack.size()>1) stack.peek();
                if (stack.size()==1) {
                    last=i; first = stack.peek();
                }
        }
        //String jsonWithoutClasses = json.substring();

        return null;
    }
}
