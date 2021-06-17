// Given an array of integers, return a boolean value indicating if number input by user is in array or not.

import java.util.Scanner;

public class FoundNumber {

    static boolean isFound(int[] num, int val) {
        boolean found = false;

        for (int i=0; i<num.length; i++) {
            if (num[i] == val) {
                found = true;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scan.nextInt();

        while (num != -1) {
            System.out.println("Is " + num + " in numbers array? " + isFound(numbers, num));

            System.out.println("Enter a number: ");
            num = scan.nextInt();
        }
    }
}
