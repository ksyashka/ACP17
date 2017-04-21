package threads;

/**
 * Created by ksyashka on 21.04.2017.
 */
public class CommonResource {

    public static void main(String[] args) {

    }

    class Container {
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
                lock.notifyAll();
            }
        }

        public int getCount() {
            return count;
        }
    }
}
