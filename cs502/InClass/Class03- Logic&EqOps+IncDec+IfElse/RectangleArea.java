import java.util.Scanner;

public class RectangleArea {

	public static void main (String[] args) {

/* Program outputs the area of a rectangle according the width and length typed by user */
	
		Scanner scan = new Scanner(System.in);
		int width;
		int length;
		int area;

		System.out.println("Enter width: ");
		width = scan.nextInt();
		System.out.println("width=" + width);
		
		System.out.println("Enter length: ");
		length = scan.nextInt();
		System.out.println("length=" + length);
		
		area = width * length;
		System.out.println("area=" + area);
	
	}
}
