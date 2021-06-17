// Creating a bubble sort algorithm that can sort an array of int

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int temp;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void printArr(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(i + ",");
        }
        System.out.println("\b");
    }

    public static void main(String[] args) {

        int[] arr = {0,2,4,6,8,1,7,5,9,3};

        bubbleSort(arr);
        printArr(arr);

    }
}
