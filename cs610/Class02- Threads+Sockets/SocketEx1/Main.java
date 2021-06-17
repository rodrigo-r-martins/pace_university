public class Main {
    public static void main(String[] args) {
        BoundedBuffer buf = new BoundedBuffer();
        Producer m1 = new Producer(buf);
        Consumer m2 = new Consumer(buf);
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        t1.start();
        t2.start();
    }
}

