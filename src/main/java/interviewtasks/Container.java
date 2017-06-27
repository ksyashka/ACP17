package interviewtasks;

// some threads invoke 'inc', others invoke 'decr'
// 1. Make this class thread safe
// 2. Add conditions
//    thread cannot invoke increment while count doesn't equals 0
//    thread cannot invoke decrement while count equal 0
class Container {

    private int count;
    Object lock = new Object();


    public void inc() {// monitor this
        synchronized (lock) {
            while (count != 0)
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        count++;
    }

    public void decr() {
        synchronized (lock) {
            while (count != 0)
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        count--;
    }
}
