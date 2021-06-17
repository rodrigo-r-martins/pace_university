// Inherit Quadrilateral class and implement(override) calcPerimeter of a rectangle.

public class Rectangle extends Quadrilateral {
    public int side1;
    public int side2;

    @Override
    public double calcPerimeter() {
        double perimeter = (side1 * 2.0) + (side2 + 2.0);
        return perimeter;
    }
}
