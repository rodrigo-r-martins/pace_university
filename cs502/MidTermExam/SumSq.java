import java.util.Scanner;

public class SumSq {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scan.nextInt();
        int answer = 0;

        for (int x=num; x>0; x--) {
            answer = answer + (x*x);
            System.out.println(x + "*" + x + " = " + x*x);
        }
        System.out.println("Sum of all squares = " + answer);
    }
}
