public class Student {
    private int id;
    private int midtermExam;
    private int finalExam;


    // CONSTRUCTORS
    Student() {
        id = 0;
        midtermExam = 0;
        finalExam = 0;
    }

    Student(int myId, int midterm, int finale) {
        id = myId;
        midtermExam = midterm;
        finalExam = finale;
    }


    // SETTERS AND GETTERS
    public void setId (int myId) {
        id = myId;
    }

    public int getId() {
        return id;
    }

    public void setMidtermExam(int midterm) {
        midtermExam = midterm;
    }

    public int getMidtermExam() {
        return midtermExam;
    }

    public void setFinalExam(int finale) {
        finalExam = finale;
    }

    public int getFinalExam() {
        return finalExam;
    }


    // METHODS
    public double calcAvg() {
        double avg;
        avg = (midtermExam + finalExam) / 2.0;
        return avg;
    }

    public char getLetterGrade() {
        char letterGrade = ' ';
        return letterGrade;
    }
}
