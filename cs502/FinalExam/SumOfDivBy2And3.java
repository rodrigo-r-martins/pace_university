import java.util.Scanner;

public class SumOfDivBy2And3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number:");
        int num = scan.nextInt();

        int sum = 0;

        for (int i=num; i>=0; i--) {
            if (i >= 2) {
                if (i%2==0 || i%3==0) {
                    System.out.println(i);
                    sum += i;
                }
            }
        }
        System.out.println("Sum of divisible by 2 or 3 = " + sum);
    }
}
