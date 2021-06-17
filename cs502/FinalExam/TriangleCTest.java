public class TriangleCTest {
    public static void main(String[] args) {
        TriangleC t1 = new TriangleC();
        t1.setSides(8, 8, 8);
        System.out.println("T1 Perimeter = " + t1.perimeter());
        System.out.println("T1 Type = " + t1.checkTriangle());

        TriangleC t2 = new TriangleC(5, 6, 6);
        t2.printTriangle();
        System.out.println("T2 Type = " + t2.checkTriangle());
    }
}
