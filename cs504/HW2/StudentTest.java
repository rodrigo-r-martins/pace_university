public class StudentTest {
    public static void main(String[] args) {

        /*
        Create two child classes, UnderGraduateStudent and GraduateStudent that will extend from the Student class.
        Override the char getLetterGrade() method in each of the child classes.
        */

        // Testing class GraduateStudent with constructor GraduateStudent(int, int, int):
        GraduateStudent rod = new GraduateStudent(1, 90, 95);
        System.out.println("Graduate student Rod: ID " + rod.getId());
        System.out.println("avgGrade= " + rod.calcAvg());
        System.out.println("letterGrade= " + rod.getLetterGrade());

        // Testing class GraduateStudent with constructor default GraduateStudent and set methods from class Student:
        GraduateStudent bill = new GraduateStudent();
        bill.setId(2);
        bill.setMidtermExam(80);
        bill.setFinalExam(78);
        System.out.println("\nGraduate student Bill: ID " + bill.getId());
        System.out.println("avgGrade= " + bill.calcAvg());
        System.out.println("letterGrade= " + bill.getLetterGrade());

        // Testing class UnderGraduateStudent with constructor UnderGraduateStudent(int, int, int):
        UnderGraduateStudent bob = new UnderGraduateStudent(1, 70, 68);
        System.out.println("\nUnderGraduate student Bob: ID " + bob.getId());
        System.out.println("avgGrade= " + bob.calcAvg());
        System.out.println("letterGrade= " + bob.getLetterGrade());

        // Testing class UnderGraduateStudent with constructor default UnderGraduateStudent and set methods from class Student:
        GraduateStudent john = new GraduateStudent();
        john.setId(2);
        john.setMidtermExam(82);
        john.setFinalExam(83);
        System.out.println("\nUnderGraduate student John: ID " + john.getId());
        System.out.println("avgGrade= " + john.calcAvg());
        System.out.println("letterGrade= " + john.getLetterGrade());
    }
}
