import java.util.Scanner;

public class GradesTest {
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// ARRAY - EXAMPLE1
		System.out.print("Enter the number of grades to input: ");
		int numGrades = scan.nextInt();

		int[] myArr = new int[numGrades];
		for (int i=0; i<myArr.length; i++) {
			System.out.print("Enter grade[" + i + "]: ");
			myArr[i] = scan.nextInt();
		}


		// USING DEFAULT CONSTRUCTOR
		Grades grds = new Grades();
		grds.setValues(myArr);
		grds.getValues();
		System.out.print("myArr values = ");
		for (int i=0; i<myArr.length; i++) {
			System.out.print(myArr[i] + " ");
		}
		System.out.println("\nmyArr highestValue = " + grds.highest());
		System.out.println("myArr lowestValue = " + grds.lowest());
		System.out.println("myArr numOfGrades = " + grds.numOfGrades());
		System.out.println("myArr averageGrades = " + grds.average());
		System.out.println("myArr numOfFailingGrades = " + grds.numOfFailingGrades(70));
		grds.histogram();


		// ARRAY - EXAMPLE2
		System.out.print("Enter the number of grades to input: ");
		numGrades = scan.nextInt();

		int[] myNewArr = new int[numGrades];
		for (int i=0; i<myNewArr.length; i++) {
			System.out.print("Enter grade[" + i + "]: ");
			myNewArr[i] = scan.nextInt();
		}


		// USING CONSTRUCTOR Grades(int[] myArr)
		Grades newGrds = new Grades(myNewArr);
		newGrds.getValues();
		System.out.print("myNewArr values = ");
		for (int i=0; i<myNewArr.length; i++) {
			System.out.print(myNewArr[i] + " ");
		}
		System.out.println("\nmyNewArr highestValue = " + newGrds.highest());
		System.out.println("myNewArr lowestValue = " + newGrds.lowest());
		System.out.println("myNewArr numOfGrades = " + newGrds.numOfGrades());
		System.out.println("myNewArr averageGrades = " + newGrds.average());
		System.out.println("myNewArr numOfFailingGrades = " + newGrds.numOfFailingGrades(70));
		newGrds.histogram();				
	}
}