public class RecursionTest {

    static int factorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 1 || n == 0) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("0!=" + factorial(0));
        System.out.println("5!=" + factorial(5));
        System.out.println("-3!=" + factorial(-3));
        System.out.println("8!=" + factorial(8));
    }
}
