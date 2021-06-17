import java.util.Scanner;

public class AverageGrade {

	public static void main (String[] args) {

		Scanner scan = new Scanner(System.in);
		int midtermGrade;
		int finalGrade;
		double avg;
		
		System.out.println("Enter midterm grade:");
		midtermGrade = scan.nextInt();
 		// System.out.println("midterm=" + midtermGrade);

		System.out.println("Enter final grade:");
		finalGrade = scan.nextInt();
		// System.out.println("final=" + finalGrade);

		avg = (midtermGrade + finalGrade) / 2.0;
		System.out.println("averageGrade=" + avg);
		
		if (avg >= 90) {
			System.out.println("Pass: A");
		} else if (avg >= 80) {
			System.out.println("Pass: B");
		} else if (avg >= 70) {
			System.out.println("Pass: C");
		} else {
			System.out.println("Fail: F");				
		}

	}

}
