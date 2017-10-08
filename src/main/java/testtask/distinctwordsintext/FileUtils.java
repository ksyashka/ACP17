package testtask.distinctwordsintext;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    public static String readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        StringBuilder sb = new StringBuilder();
        while (br.ready()){
            sb.append(br.readLine()).append("\n");
        }
        return sb.toString();
    }
}