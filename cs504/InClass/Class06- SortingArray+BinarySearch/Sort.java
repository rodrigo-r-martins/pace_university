public class Sort {

    public int[] myArray;

    public void printArray(int[] myArray) {

        System.out.print("[");
        for (int i=0;i<myArray.length; i++) {
            System.out.print(myArray[i] + ", ");
        }
        System.out.println("\b\b]");
    }

    // insertion sort
    public void insertionSort(int[] myArray) {
        int temp;
        for (int i=1; i<myArray.length; i++) {
            for (int j=i; j>0; j--) {
                if (myArray[j-1] > myArray[j]) {
                    // swap the value in array position
                    temp = myArray[j];
                    myArray[j] = myArray[j-1];
                    myArray[j-1] = temp;
                } // end if myArray[j-1] > myArray[j]
            }
        }
    }

    // selection sort
    public void selectionSort(int[] myArray) {
        int index;
        int temp;
        for (int i=0; i<myArray.length-1; i++) {
            index = i;
            for (int j=i+1; j<myArray.length; j++) {
                if (myArray[index] > myArray[j]) {
                    index = j;
                }
            }
            temp = myArray[index];          // index can be equal j at this moment
            myArray[index] = myArray[i];
            myArray[i] = temp;
        }
    }
}
