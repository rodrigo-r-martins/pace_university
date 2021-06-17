public class PointTest {
    public static void main(String[] args) {
        Point[] line = new Point[4];
        line[0] = new Point(1, 1);
        line[1] = new Point(2, 2);
        line[2] = new Point(3, 3);
        line[3] = new Point(4, 4);

        for (int i=0; i<line.length; i++) {
            System.out.print(line[i].getX() + " ");
            System.out.println(line[i].getY());
        }

    }
}
