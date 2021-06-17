import java.util.Scanner;

public class TriangleTest {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		Triangle t1 = new Triangle();
		
		System.out.print("Enter t1.side1: ");
		t1.side1 = scan.nextInt();
		System.out.print("Enter t1.side2: ");
		t1.side2 = scan.nextInt();
		System.out.print("Enter t1.side3: ");
		t1.side3 = scan.nextInt();
		
		System.out.println("Is t1 isosceles? " + t1.isIsosceles());
		System.out.println("Is t1 scalene? " + t1.isScalene());
		System.out.println("Is t1 equilateral? " + t1.isEquilateral());

		int t1perimeter = t1.calculatePerimeter();
		System.out.println("t1perimeter=" + t1perimeter);
	}
}
