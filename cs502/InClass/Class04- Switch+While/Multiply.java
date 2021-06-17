import java.util.Random;
import java.util.Scanner;

public class Multiply {

  public static void main(String[] args) {

    Random  myRandomNumber = new Random();
    int myOneDigitNumber = Math.abs( myRandomNumber.nextInt() % 10 );
    int mySecDigitNumber = Math.abs( myRandomNumber.nextInt() % 10 );

    Scanner scan = new Scanner(System.in);
    int input;
    int answer;

    // System.out.println("one digit=" + myOneDigitNumber);

    System.out.println("What is " + myOneDigitNumber + " * " + mySecDigitNumber + " or -1 to quit?");
    input = scan.nextInt();
    answer = myOneDigitNumber * mySecDigitNumber;

    while (input != -1) {

    	if (input == answer) {
      		System.out.println("Correct");
                myOneDigitNumber = Math.abs( myRandomNumber.nextInt() % 10 );
                mySecDigitNumber = Math.abs( myRandomNumber.nextInt() % 10 );
                answer = myOneDigitNumber * mySecDigitNumber;
    	}  else {
      		System.out.println("InCorrect");
    	}

        System.out.println("What is " + myOneDigitNumber + " * " + mySecDigitNumber + " or -1 to quit?");
    	input = scan.nextInt();
   } // end while input != -1


  }

}