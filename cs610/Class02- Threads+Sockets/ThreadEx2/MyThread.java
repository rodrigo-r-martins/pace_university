public class MyThread implements Runnable {

    public void run() {
        for(long i = 1; i <= 1000000; i++) {
            Shared.increment();
        }
    }
}

