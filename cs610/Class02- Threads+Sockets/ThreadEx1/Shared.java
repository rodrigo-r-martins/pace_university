public class Shared {

    private static long a = 0;

    public static synchronized void increment() {
        // Since the method: increment is synchronized only one thread at a time can enter to the body of the method.
        // If it wasn't synchronized the value would be different (TEST IT!!! Just delete the word synchronized.)
        a++;
    }

    public static void display() {
        System.out.println("a = " + a);
    }
}
