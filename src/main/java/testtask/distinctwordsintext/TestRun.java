package testtask.distinctwordsintext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestRun {
    public static void main(String[] args) throws IOException {
        String text = FileUtils.readFile("C:\\Users\\ksyashka\\IdeaProjects\\ACP17\\src\\main\\java\\testtask\\distinctwordsintext\\text.txt");
        ArrayList<String> result = TextUtils.getDistinctWords(text);
        for (String s:result) {
            System.out.println(s);
        }
    }
}
