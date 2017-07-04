package multithreads;

public class EggVoice extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);        //Приостанавливает поток на 1 секунду
            } catch (InterruptedException e) {
            }
            System.out.println("Egg!");
        }

    }
}
