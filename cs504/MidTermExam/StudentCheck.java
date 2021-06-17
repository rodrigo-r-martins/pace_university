public class StudentCheck {
    public static void main(String[] args) {

        // 1) Create an instance of Student array called cs504 with 50 students.
        Student[] cs504 = new Student[50];

        for (int i=0; i<cs504.length; i++) {
            cs504[i] = new Student(90, 91);
            // System.out.println("Student[" + i + "] grade = " + grades[i].getLetterGrade());
        }

        // 2) Count and display the number of students who got grade 'A'.
        int count = 0;
        for (int i=0; i<cs504.length; i++) {
            if (cs504[i].getLetterGrade() == 'A') {
                count++;
            }
        }

        System.out.println("Number of students with grade A = " + count);

        // 3) Create an instance of Student called Bill.
        Student bill = new Student("Bill");

        // 4) Set bill midtermExam to 91.
        bill.setMidTermExam(91);
        bill.setFinalExam(93);

        // 5) If bill's grade equals 'A' print the message: "Grade A. Excellent."
        char billGrade = bill.getLetterGrade();
        if (billGrade == 'A') {
            System.out.println("Grade A. Excellent.");
        }


    }
}
