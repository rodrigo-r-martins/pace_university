import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 3 sides of a triangle: ");
        int side1 = scan.nextInt();
        int side2 = scan.nextInt();
        int side3 = scan.nextInt();

        if (side1 == side2 && side2 == side3) {
            System.out.println("It's an equilateral triangle");
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            System.out.println("It's an isosceles triangle");
        } else {
            System.out.println("Neither of them. It's a scalene triangle");
        }
    }
}
