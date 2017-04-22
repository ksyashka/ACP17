package threads;

import java.util.ArrayList;
import java.util.List;

public class CommonResource {

    public static void main(String[] args) {

        Container container = new Container();
        List<Thread> threads = new ArrayList<>();

        int operationCurrent = 10000;

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < operationCurrent; j++)
                        container.inc();
                }
            });
            thread1.start();
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < operationCurrent; j++)
                        container.dec();
                }
            });
            thread2.start();

            threads.add(thread1);
            threads.add(thread2);
        }
        for (Thread t:threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(container.getCount());

    }

    public static class Container {
        private volatile int count;
        private Object lock = new Object();

        public void inc() {
            synchronized (lock) {
                while (count != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(count);
                lock.notifyAll();
            }
        }

        public void dec() {
            synchronized (lock) {
                while (count != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(count);
                lock.notifyAll();
            }
        }

        public int getCount() {
            return count;
        }
    }
}
