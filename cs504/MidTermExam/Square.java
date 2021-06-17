// Inherit Quadrilateral class and implement(override) calcPerimeter of a square.

public class Square extends Quadrilateral {

    public int sides;

    @Override
    public double calcPerimeter() {
        double perimeter = sides * 4.0;
        return perimeter;
    }
}
