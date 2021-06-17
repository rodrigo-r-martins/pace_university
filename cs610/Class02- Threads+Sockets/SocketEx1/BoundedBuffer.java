public class BoundedBuffer {

    private static final int BUFFER_SIZE = 5;
    private int count; // number of items in the buffer
    private int in; // points to the next free position
    private int out; // points to the next full position
    private int[] buffer;
    private Object myObect = new Object();

    public BoundedBuffer() {
        // buffer is initially empty
        count = 0;
        in = 0;
        out = 0;
        buffer = new int[BUFFER_SIZE];
    }

    // producers calls this method
    public void insert(int item) {
        while (count == BUFFER_SIZE) {
            Wait.holdon();
        }
        synchronized (myObect) {
            // add an item to the buffer
            ++count;
            buffer[in] = item;
        }
        in = (in + 1) % BUFFER_SIZE;
    }

    // consumers calls this method
    public int remove() {
        int item;
        while (count == 0) {
            Wait.holdon();
        }
        synchronized (myObect) {
            --count;
            item = buffer[out];
        }
        out = (out + 1) % BUFFER_SIZE;
        return item;
    }
}

