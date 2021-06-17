public class TriangleC {
    private int side1;
    private int side2;
    private int side3;

    TriangleC() {
        side1 = 0;
        side2 = 0;
        side3 = 0;
    }

    TriangleC(int s1, int s2, int s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public void setSides(int s1, int s2, int s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public void printTriangle() {
        System.out.println("Side1 = " + side1);
        System.out.println("Side2 = " + side2);
        System.out.println("Side3 = " + side3);
    }

    public int perimeter() {
        int trianglePerimeter = side1 + side2 + side3;
        return trianglePerimeter;
    }

    public char checkTriangle() {
        if (side1 == side2 && side2 == side3) {
            return 'E';
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            return 'I';
        } else {
            return 'S';
        }
    }
}
