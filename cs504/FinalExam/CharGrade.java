/*
Creating a method that return a letter grade according number of right answers of given char array of answers.
I must compare student char array of grades to the given final_answers inside method.
There're 20 questions. For each correct answer add 5 points of total 100.
Grades:
90-100 = A
80-89  = B
70-79  = C
0-69   = F
 */

public class CharGrade {

    static char getLetterGrade(char[] grades) {
        char[] final_answers = {'A','D','C','A','B','A','A','D','C','C','B','A','A','A','D','C','A','D','C','A'};
        int finalGrade = 0;
        int correct = 0;        // Just to check how many correct
        int incorrect = 0;      // Just to check how many incorrect
        char letterGrade;
        for (int i=0; i<grades.length; i++) {
            if (final_answers[i] == grades[i]) {
                finalGrade += 5;
                correct++;
            } else {
                incorrect++;
            }
        }
        if (finalGrade >= 90 && finalGrade <= 100) {
            letterGrade = 'A';
        } else if (finalGrade >= 80) {
            letterGrade = 'B';
        } else if (finalGrade >= 70) {
            letterGrade = 'C';
        } else {
            letterGrade = 'F';
        }
        System.out.println("correct=" + correct + "   incorrect=" + incorrect);
        return letterGrade;
    }

    public static void main(String[] args) {

        char[] studentA = {'A','D','C','A','B','A','A','D','C','C','B','A','A','A','D','A','A','D','C','A'};
        char[] studentB = {'B','A','A','A','B','A','A','A','C','C','B','A','A','A','D','C','A','D','C','A'};

        System.out.println("StudentA letterGrade = " + getLetterGrade(studentA));
        System.out.println("StudentB letterGrade = " + getLetterGrade(studentB));
    }
}
