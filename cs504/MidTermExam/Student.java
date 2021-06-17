// Given class Student to use in StudentTest class

public class Student {

    String name;
    int midTermExam;
    int finalExam;

    Student() {}
    Student(int midTermExam, int finalExam) {
        this.midTermExam = midTermExam;
        this.finalExam = finalExam;
    }
    Student(String name) {
        this.name = name;
    }

    public void setMidTermExam(int midTermExam) {
        this.midTermExam = midTermExam;
    }

    public int getMidTermExam() {
        return midTermExam;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calcAverage() {
        double avg = (midTermExam + finalExam) / 2.0;
        return avg;
    }

    public double calcAverage(int midTermExam, int finalExam) {
        double avg = (midTermExam + finalExam) / 2.0;
        return avg;
    }

    public char getLetterGrade() {
        if (calcAverage() >= 90 && calcAverage() <= 100) {
            return 'A';
        } else if (calcAverage() >= 80) {
            return 'B';
        } else if (calcAverage() >= 70) {
            return 'C';
        } else {
            return 'F';
        }
    }
}
