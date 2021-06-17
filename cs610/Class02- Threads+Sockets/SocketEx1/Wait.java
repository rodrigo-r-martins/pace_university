public class Wait {
    // This method lets the CPU switches to other thread.
    public static void holdon () {
        try {
            Thread.sleep(100);
        } catch(Exception e){}
    }
}

