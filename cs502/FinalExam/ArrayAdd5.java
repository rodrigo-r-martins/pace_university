public class ArrayAdd5 {

    static void copyPlus5(int[] myArray, int[] copyArray) {
        for (int i=0; i<myArray.length; i++) {
            copyArray[i] = myArray[i] + 5;
        }
    }

    public static void main(String[] args) {
        int[] grades = {80, 81, 73, 58, 45, 90, 76};
        int[] gradesCopy = new int[grades.length];

        // Copying values greater than 60
        for (int i=0; i<gradesCopy.length; i++) {
            if (grades[i] > 60) {
                gradesCopy[i] = grades[i];
            }
        }

        for (int i=0; i<gradesCopy.length; i++) {
            System.out.println(gradesCopy[i]);
        }


        // Copying values and adding 5 to each of them
        int[] copyGrades = new int[grades.length];
        copyPlus5(grades, copyGrades);

        for (int i=0; i<copyGrades.length; i++) {
            System.out.println(copyGrades[i]);
        }
    }
}
