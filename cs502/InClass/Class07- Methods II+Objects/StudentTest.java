public class StudentTest {

   public static void main(String[] args) {
     Student joe = new Student();

     joe.midtermExam = 100;
     joe.finalExam = 50;

     double joeAvg = joe.calcAvg();
     System.out.println("joe avg=" + joeAvg);

     Student jill = new Student();
     jill.midtermExam = 30;
     jill.finalExam = 40;

     double jillAvg = jill.calcAvg();
     System.out.println("jill avg=" + jillAvg);

     jill = joe;
     System.out.println("jill avg after assignment=" + jill.calcAvg());


   }

}