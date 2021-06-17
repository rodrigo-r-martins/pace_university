/************************************************************************
 *
 *  Pace University
 *  Fall 2020
 *  Algorithms and Computing Theory
 *
 *  Course: CS 608
 *  Team members: Rodrigo Martins, Adam Caragine
 *  Other collaborators: None
 *  References:
 *      1) https://gist.github.com/metajungle/62bddff55708bf7a3da7
 *      2) https://stackoverflow.com/questions/27321456/pivot-as-the-median-of-three-random-numbers
 *      3) https://en.wikipedia.org/wiki/Quicksort
 *      4) https://stackoverflow.com/questions/62215962/implementing-quicksort-using-median-of-three-random-elements-of-an-array-as-pivo
 *
 *
 *  Assignment: #4
 *  Problem: Quick Sort
 *  Description: In this problem we have to measure and compare the running time of Quick Sort by creating two methods for different use of the pivot, and Insertion Sort.
 *
 *  Input: n -> The number of numbers in the array
 *  Output:
 *      - running time of each of two methods of Quick Sort algorithm
 *      - running time of Insertion Sort algorithm
 *
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  int n;       -> Variable used to store the input size
 *  int[] arr;   -> Store the array of integers created of size n
 *
 *
 *  Visible methods:
 *
 *  public static int getRandomNumber(int min, int max);
 *  public static int[] getArrIncOrder(int n);
 *  public static int[] getArrDecOrder(int n);
 *  public static int[] getArrRandomNumbers(int n);
 *  public static void insertionSort(int[] arr);
 *  public static void quickSort_pivot_firstPos(int[] arr, int low, int high);
 *  public static int partition_pivot_firstPos(int[] arr, int low, int high);
 *  public static void quickSort_pivot_medianPos(int[] arr, int low, int high);
 *  public static int partition_pivot_medianPos(int[] arr, int low, int high);
 *  private static void swap(int[] arr, int i, int j);
 *  private static int find_median(int a, int b, int c);
 *  private static int indexOf(int[] arr, int value);
 *
 *
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *   1) public static void insertionSort(int[] arr);
 *
 *   2)
 *      a)  public static void quickSort_pivot_firstPos(int[] arr, int low, int high);
 *          public static int partition_pivot_firstPos(int[] arr, int low, int high);
 *
 *      b)  public static void quickSort_pivot_medianPos(int[] arr, int low, int high);
 *          public static int partition_pivot_medianPos(int[] arr, int low, int high);
 *
 *   3)
 *      Running times:
 *
 *                      increasing_order    decreasing_order    random
 *   ----------------------------------------------------------------------
 *   Insertion Sort:    278900              23482200            12367000
 *   Quick Sort (a):    32811400            30068600            1529200
 *   Quick Sort (b):    1545600             1105920             1426000
 *
 *
 *   4)
 *      Running times:
 *
 *                      increasing_order    decreasing_order    random
 *   ----------------------------------------------------------------------
 *   Insertion Sort:    O(n)                O(n^2)              O(n^2)
 *   Quick Sort (a):    O(n^2)              O(n^2)              O(n log n)
 *   Quick Sort (b):    O(n log n)          O(n log n)          O(n log n)
 *
 *
 *   5)
 *      For Insertion Sort row, we hypothesize that the running times will be O(n) for an array that is in increasing order, and O(n^2) for decreasing order and random order.
 *      When matched with the running times from question 3, this seems to be confirmed because the run time is much smaller for increasing order (278900) than it is for decreasing order (23482200) and random order (12367000). Also, we see that decreasing order (23482200) and random order (12367000) can certainly both be O(n^2), as they are both very similar in run times (8 digits each). Now, we want to compare the increasing order run time for insertion sort (278900) with the increasing order times of our two quick sort methods. In question 4, we claim that Insertion Sort should be O(n), while Quick Sort (a) should be O(n^2) and Quick Sort (b) should be O(n log n).
 *      Looking at the numbers, this too seems to be proven correct, as Insertion Sort has the smallest time (278900), Quick Sort (b) has a time that is larger than insertion sort (1545600) which matches O(n log n) theory, and Quick Sort (a) has the largest time by far (32811400) because it is O(n^2).
 *
 *      For Quick Sort (a), we hypothesize that the running times will be O(n^2) for an array that is in increasing or decreasing order, and O(n log n) if it is in random order.
 *      When matched with the running times from question 3, this seems to be confirmed because the run time of increasing order (32811400) and decreasing order (30068600) are both very similar (both 8 digits). Also, the run time of Quick Sort (a) with random order is 1529200, which is much smaller than the increasing and decreasing times, so this supports O(n log n) growth, which is much smaller than O(n^2). To confirm that it is O(n log n) and not O(n) however, we must again look at the increasing times for all 3 methods.

 *      For Quick Sort (b), we hypothesize that the running times will be O(n log n) for all 3 methods. Based on the run times from question 3, we see that this is very accurate because the times are 1545600 for increasing order, 1105920 for decreasing order, and 1426000 for random order. All these times are very similar (7 digits starting with 1). To make sure that these times are O(n log n) and not O(n) however, we can compare them to the time of Insertion Sort increasing order (278900) and see that the Quick Sort (b) times are much larger, which also supports a growth factor of O(n log n).
 *
 *      For complete analysis, we should also compare the decreasing order times and random times of all methods together. For decreasing order, we have a run time of 23482200 for Insertion Sort, 30068600 for Quick Sort (a) and 1105920 for Quick Sort (b). In question 4, we claimed these times would be O(n^2), O(n^2) and O(n log n) respectively. This matches the numbers well, because the run times that are O(n^2) are 30068600 and 23482200, both very similar (8 digits). The time for Quick Sort (b) (1105920) is much smaller, as should be expected for a time that runs at O(n log n) compared to O(n^2).
 *
 *      Also, we should compare the run times for the random order array for all methods. Here we see a run time of 1236700 for Insertion Sort, 1529200 for Quick Sort (a) and 1426000 for Quick Sort (b). In Question 4, we claimed that these times would be O(n^2), O(n log n) and O(n log n) respectively. Therefore, the time for Insertion Sort (12367000) should be much larger than those of Quick Sort (a) (1529200) and Quick Sort (b) (1426000), which they are. Also, the times for Quick Sort (a) and Quick Sort (b) should be very similar, since they both grow at O(n log n). This is also true, as they are both 7 digits starting with 1.
 *
 *      In conclusion, all of our Big-O conjectures are consistent with the running times measured in our experiment.
 *
 *
 *
 *   Extra Credit)
 *
 *
 *
 *************************************************************************/

public class Assignment_4 {

    // USEFUL METHODS
    public static int getRandomNumber(int min, int max) {
        // Function used to generate random numbers from min to max
        return (int)(Math.random() * (max-min+1) + min);
    }

    public static int[] getArrIncOrder(int n) {
        // Function used to generate an array with numbers sorted in increasing order
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] getArrDecOrder(int n) {
        // Function used to generate an array with numbers sorted in decreasing order
        int[] arr = new int[n];
        for (int i=n-1, j=0; i>=0; i--, j++) {
            arr[j] = i;
        }
        return arr;
    }

    public static int[] getArrRandomNumbers(int n) {
        // Function used to generate an array with random numbers (not sorted)
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            // random numbers from 0 to n+5000 to avoid repetition
            int rand = getRandomNumber(0,n);
            arr[i] = rand;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int find_median(int a, int b, int c) {
        int median;
        if (a > b) {
            if (a < c) {
                median = a;
            } else if (b > c) {
                median = b;
            } else {
                median = c;
            }
        } else {
            if (a > c) {
                median = a;
            } else if (b < c) {
                median = b;
            } else {
                median = c;
            }
        }
        return median;
    }

    private static int indexOf(int[] arr, int value) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // SORTING METHODS
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int key = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > key) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }

    public static void quickSort_pivot_firstPos(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_pos = partition_pivot_firstPos(arr, low, high);
            quickSort_pivot_firstPos(arr, low, pivot_pos - 1);
            quickSort_pivot_firstPos(arr, pivot_pos + 1, high);
        }
    }

    public static int partition_pivot_firstPos(int[] arr, int low, int high) {
        int pivot = arr[low];
        int pivotIndex = low+1;
        for (int j=low+1; j<=high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, pivotIndex, j);
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex-1, low);
        return pivotIndex-1;
    }

    public static void quickSort_pivot_medianPos(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_pos = partition_pivot_medianPos(arr, low, high);
            quickSort_pivot_medianPos(arr, low, pivot_pos - 1);
            quickSort_pivot_medianPos(arr, pivot_pos + 1, high);
        }
    }

    public static int partition_pivot_medianPos(int[] arr, int low, int high) {
        int first = arr[getRandomNumber(low, high)];
        int second = arr[getRandomNumber(low, high)];
        int third = arr[getRandomNumber(low, high)];
        int median = find_median(first, second, third);
        int medianIndex = indexOf(arr, median);
        swap(arr, low, medianIndex);
        int pivot = arr[low];
        int pivotIndex = low;
        for (int i=low+1; i<high+1; i++) {
            if (arr[i] < pivot) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        swap(arr, low, pivotIndex);
        return pivotIndex;
    }


    public static void main(String[] args) {
        // Sorting n = 10000 numbers
        int n = 10000;
        int[] arr;

        /*
        Three types of input:
        1) already sorted in increasing order
        2) already sorted in decreasing order
        3) input with numbers generated at random
         */


        // =-=-=-=- WORKING WITH INSERTION SORT =-=-=-=-
        System.out.println("=-=-=- INSERTION SORT =-=-=-");

            // 1) already sorted in increasing order
        arr = getArrIncOrder(n);
        long startTime = System.nanoTime();
        insertionSort(arr);
        System.out.println("Already sorted (inc) = " + (System.nanoTime() - startTime) + " nanosecs");

            // 2) already sorted in decreasing order
        arr = getArrDecOrder(n);
        startTime = System.nanoTime();
        insertionSort(arr);
        System.out.println("Already sorted (dec) = " + (System.nanoTime() - startTime) + " nanosecs");

            // 3) input with numbers generated at random
        arr = getArrRandomNumbers(n);
        startTime = System.nanoTime();
        insertionSort(arr);
        System.out.println("Random numbers = " + (System.nanoTime() - startTime) + " nanosecs\n");


        // =-=-=- WORKING WITH QUICK SORT - METHOD 1: Pivot being the first element =-=-=-
        System.out.println("=-=-=- QUICK SORT - METHOD 1: Pivot being the first element =-=-=-");

            // 1) already sorted in increasing order
        arr = getArrIncOrder(n);
        startTime = System.nanoTime();
        quickSort_pivot_firstPos(arr, 0, arr.length-1);
        System.out.println("Already sorted (inc) = " + (System.nanoTime() - startTime) + " nanosecs");

            // 2) already sorted in decreasing order
        arr = getArrDecOrder(n);
        startTime = System.nanoTime();
        quickSort_pivot_firstPos(arr, 0, arr.length-1);
        System.out.println("Already sorted (dec) = " + (System.nanoTime() - startTime) + " nanosecs");

            // 3) input with numbers generated at random
        arr = getArrRandomNumbers(n);
        startTime = System.nanoTime();
        quickSort_pivot_firstPos(arr, 0, arr.length-1);
        System.out.println("Random numbers = " + (System.nanoTime() - startTime) + " nanosecs\n");


        // =-=-=- WORKING WITH QUICK SORT - METHOD 2: Pivot being median of three random indexes =-=-=-
        System.out.println("=-=-=- QUICK SORT - METHOD 2: Pivot being median of three random indexes =-=-=-");

        // 1) already sorted in increasing order
        arr = getArrIncOrder(n);
        startTime = System.nanoTime();
        quickSort_pivot_medianPos(arr, 0, arr.length-1);
        System.out.println("Already sorted (inc) = " + (System.nanoTime() - startTime) + " nanosecs");

        // 2) already sorted in decreasing order
        arr = getArrDecOrder(n);
        startTime = System.nanoTime();
        quickSort_pivot_medianPos(arr, 0, arr.length-1);
        System.out.println("Already sorted (dec) = " + (System.nanoTime() - startTime) + " nanosecs");

        // 3) input with numbers generated at random
        arr = getArrRandomNumbers(n);
        startTime = System.nanoTime();
        quickSort_pivot_medianPos(arr, 0, arr.length-1);
        System.out.println("Random numbers = " + (System.nanoTime() - startTime) + " nanosecs\n");
    }
}
