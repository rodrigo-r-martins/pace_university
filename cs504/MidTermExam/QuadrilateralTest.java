// Testing classes Square and Rectangle that inherits Quadrilateral and overrides its method calcPerimeter()

public class QuadrilateralTest {
    public static void main(String[] args) {

        Square square = new Square();
        square.sides = 4;
        System.out.println("Perimeter of square = " + square.calcPerimeter());

        Rectangle rect = new Rectangle();
        rect.side1 = 4;
        rect.side2 = 2;
        System.out.println("Perimeter of rectangle = " + rect.calcPerimeter());
    }
}
