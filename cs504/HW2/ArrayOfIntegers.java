import java.util.Scanner;

public class ArrayOfIntegers {
    public static void main(String[] args) {

        /*
        Design and implement an application that reads an arbitrary number of integers that are in the range of
        0 to 50 inclusive and counts how many occurrences of each are entered.
        After all inputs have been processed, print only the values that have an occurrence of greater than zero.
        Also, print the number of occurrences next to the value.
         */

        Scanner scan = new Scanner(System.in);

        int[] numbers = new int[51];            // 0 to 50 has 51 occurrences
        int n = 0;

        while (n != -1) {
            System.out.println("Enter a value between 0 and 50 [-1 to end]:");
            n = scan.nextInt();
            if (n != -1) {
                if (n >= 0 && n <= 50) {        // evaluating user input
                    numbers[n]++;               // incrementing index of number entered by user
                } else {
                    System.out.println("Invalid number. Try again.");
                }
            }
        }


        // Testing array output
        /*
        for (int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        */

        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] != 0) {              // Only print number of occurrences if value > 0
                if (numbers[i] == 1) {
                    System.out.println("The value of " + i + " has " + numbers[i] + " occurrence");
                } else {
                    System.out.println("The value of " + i + " has " + numbers[i] + " occurrences");
                }
            }
        }
    }
}
