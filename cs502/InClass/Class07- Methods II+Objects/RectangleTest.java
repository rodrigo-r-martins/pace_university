class RectangleTest {

   public static void main(String[] args) {

     Rectangle r1 = new Rectangle();
     r1.length = 10;
     r1.width = 20;
     int r1area;

     r1area = r1.calcArea();

     System.out.println("r1 area=" + r1area);

     Rectangle r2 = new Rectangle();
     r2.length = 5;
     r2.width = 2;
     int r2area;
     r2area = r2.calcArea();

     System.out.println("r2 area=" + r2area);
     


   }

}