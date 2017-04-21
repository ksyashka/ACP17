package threads;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yuriy on 21.04.2017.
 */
public class _02ThreadJoin {

    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Yuriy\\IdeaProjects\\ACP17");
        File[] files = folder.listFiles();

        List<Thread> threads = new ArrayList<>();
        List<AsynchFileSearchTask> tasks = new ArrayList<>();
        List<File> results = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                AsynchFileSearchTask task = new AsynchFileSearchTask(file, ".java");
                Thread thread = new Thread(task);
                threads.add(thread);
                tasks.add(task);
                thread.start();
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (AsynchFileSearchTask task : tasks) {
            results.addAll(task.getRes());

        }

        results.forEach(System.out::println);
        System.out.println(results.size());
    }

}

class AsynchFileSearchTask implements Runnable {

    private File root;
    private String keyWord;
    private List<File> searchResult;

    public AsynchFileSearchTask(File root, String keyWord) {
        this.root = root;
        this.keyWord = keyWord;
        searchResult = new ArrayList<File>();
    }

    public void run() {
        recSearch(root);
    }

    private void recSearch(File dir) {

        if (dir == null) {
            return;
        }
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }



        Arrays.stream(files)
                .forEach((file) -> {
                    if (file.isDirectory()) {
                        recSearch(file);
                    } else if (file.getName().contains(keyWord)) {
                        searchResult.add(file);
                    }
                });
    }

    public List<File> getRes() {
        return searchResult;
    }
}
