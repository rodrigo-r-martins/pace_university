import java.util.Scanner;
import java.lang.Math;

public class CircleArea {

	public static void main(String[] args) {

/* Program returns the area of a circle according the radius typed by user */
		
		Scanner scan = new Scanner(System.in);
		int radius;
		double area;
		
		System.out.println("Enter radius: ");
		radius = scan.nextInt();
		
		area = Math.PI * (radius * radius);
		System.out.println("The area of the circle is: " + area);
	
	}

}