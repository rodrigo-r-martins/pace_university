public class Consumer implements Runnable {
    private BoundedBuffer buf;

    public Consumer(BoundedBuffer buf) {
        this.buf = buf;
    }

    public void run() {
        for(int i = 0; i <= 100; i++) {
            int e = buf.remove();
            System.out.print(e + ", ");
        }
    }
}

