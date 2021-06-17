public class Producer implements Runnable {
    private BoundedBuffer buf;

    public Producer(BoundedBuffer buf) {
        this.buf = buf;
    }

    public void run() {
        for(int i = 0; i <= 100; i++)
            buf.insert(i);
    }
}

