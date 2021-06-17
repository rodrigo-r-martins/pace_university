public class Student {

   int midtermExam;
   int finalExam;

    double calcAvg() {
	double retVal;
        retVal = (midtermExam + finalExam) / 2.0;
        return retVal;
    }

    char calcLetterGrade() {
       double avg = calcAvg();
       char letterGrade;

       if (avg >= 90)
          letterGrade = 'A';
       else if (avg >= 80)
          letterGrade = 'B';
       else if (avg >= 70)
          letterGrade = 'C';
       else
          letterGrade = 'F';

       return letterGrade;
    }
}