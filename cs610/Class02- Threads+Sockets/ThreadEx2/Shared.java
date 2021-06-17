public class Shared {

    private static long a = 0, before = 0, after = 0;
    private static Object obj = new Object();

    public static void increment() {
        before++;
        synchronized (obj) {
            a++;
        }
        after++;
    }

    public static void display() {
        System.out.println("before = " + before);
        System.out.println("a = " + a);
        System.out.println("after = " + after++);
    }
}

