package threads;

public class MyMonitorThread extends Thread {

    private Thread subject;

    public MyMonitorThread(Thread subject) {
        this.subject = subject;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try{
                Thread.sleep(99999);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.err.printf("id %s, name %s, state %s\n",
                    subject.getId(), subject.getName(), subject.getState());
        }
    }


}
