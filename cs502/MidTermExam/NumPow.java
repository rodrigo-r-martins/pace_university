import java.util.Scanner;

public class NumPow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter base number: ");
        int base = scan.nextInt();
        System.out.println("Enter exponential number: ");
        int exp = scan.nextInt();

        int value = 1;

        for (int x = 0; x < exp; x++) {
            value *= base;
        }
        System.out.println(base + "pow" + exp + " = " + value);
    }
}
