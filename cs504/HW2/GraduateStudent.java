public class GraduateStudent extends Student {

    GraduateStudent() {}

    GraduateStudent(int myId, int midterm, int finale) {
        setId(myId);
        setMidtermExam(midterm);
        setFinalExam(finale);
    }

    @Override
    public char getLetterGrade() {
        char letterGrade = ' ';
        if (calcAvg() >= 90 && calcAvg() <= 100) {
            letterGrade = 'A';
        } else if (calcAvg() >= 80) {
            letterGrade = 'B';
        } else if (calcAvg() >= 70) {
            letterGrade = 'C';
        } else {
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
