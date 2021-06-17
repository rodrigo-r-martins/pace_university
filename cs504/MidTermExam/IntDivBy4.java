/*
User will enter an integer and the output will be the sum of all integers between 0 and the output integer (inclusive)
that are divisible by 4.
 */

import java.util.Scanner;

public class IntDivBy4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = scan.nextInt();

        int sum=0;
        for (int i=0; i<=n; i++) {
            if (i%4==0) {
                sum += i;
            }
        }
        System.out.println("Sum of all numbers div by 4 = " + sum);
    }
}
