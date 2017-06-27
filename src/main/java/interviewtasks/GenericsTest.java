package interviewtasks;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {


    // please rewrite code considering generics
    public static <T> List create(T...args){
        List<T> result = new ArrayList<>();
        for (T el:args) {
            result.add(el);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> res = create("Ivan", "Oleg", "John",23);
        for (Object s:res) System.out.println(s);

    }

}
