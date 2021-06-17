import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Sorting {

    /*
    Sorting algorithms used in class:
     */

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > key) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void treeSort(int[] arr) {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int j : arr) {
            tree.insert(j);
        }
        System.out.print("[");
        tree.printTree();
        System.out.print("\b\b]\n");
    }

    // QuickSort uses two functions: quickSort and partition
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pi = (low-1);
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                pi++;
                int temp = arr[pi];
                arr[pi] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[pi+1];
        arr[pi+1] = arr[high];
        arr[high] = temp;
        return pi+1;
    }

    // MergeSort uses two functions: mergeSort and merge
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = mid - low + 1;
        int right = high - mid;
        int[] leftArr = new int[left];
        int[] rightArr = new int[right];

        for (int i = 0; i < left; i++) {
            leftArr[i] = arr[low+i];
        }
        for (int j = 0; j < right; j++) {
            rightArr[j] = arr[mid+j+1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int k = low; k < high+1; k++) {
            if (leftIndex < leftArr.length && rightIndex < rightArr.length) {
                if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                    arr[k] = leftArr[leftIndex];
                    leftIndex++;
                } else {
                    arr[k] = rightArr[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArr.length) {
                arr[k] = leftArr[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArr.length) {
                arr[k] = rightArr[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] sortedArray = new int[arr.length];
        int[] count = new int[max+1];
        Arrays.fill(count, 0);
        for (int number : arr) {
            count[number]++;
        }   // count[i] array now contains the number of elements equal to i.
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }   // count[i] now contains the number of elements less than or equal to i.
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int numberOfDigits = String.valueOf(max).length();
        int exp = 1;
        while (numberOfDigits > 0) {
            radix_countingSort(arr, exp, max);
            exp *= 10;
            numberOfDigits--;
        }
    }

    private static void radix_countingSort(int[] arr, int exp, int max) {
        int n = arr.length;
        int[] output = new int[n + 1];
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        for (int number : arr) {
            count[(number / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        LinkedList<Float>[] buckets = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (float number : arr) {
            buckets[(int) (n * number)].add(number);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float number : buckets[i]) {
                arr[index++] = number;
            }
        }
    }

    public static void main(String[] args) {
        // Selection Sort
        int[] arr1 = { 12, 11, 13, 5, 6, 7, 15, 8, 2, 1, 4, 9, 10, 14, 3 };
        selectionSort(arr1);
        System.out.println("selectionSort: " + Arrays.toString(arr1));

        // Insertion Sort
        int[] arr2 = { 12, 11, 13, 5, 6, 7, 15, 8, 2, 1, 4, 9, 10, 14, 3 };
        insertionSort(arr2);
        System.out.println("insertionSort: " + Arrays.toString(arr2));

        // Bubble Sort
        int[] arr3 = { 12, 11, 13, 5, 6, 7, 15, 8, 2, 1, 4, 9, 10, 14, 3 };
        bubbleSort(arr3);
        System.out.println("bubbleSort: " + Arrays.toString(arr3));

        // Tree Sort
        int[] arr4 = { 12, 11, 13, 5, 6, 7, 15, 8, 2, 1, 4, 9, 10, 14, 3 };
        System.out.print("treeSort: ");
        treeSort(arr4);

        // Quick Sort
        int[] arr5 = { 12, 11, 13, 5, 6, 7, 15, 8, 2, 1, 4, 9, 10, 14, 3 };
        quickSort(arr5, 0, arr5.length-1);
        System.out.println("quickSort: " + Arrays.toString(arr5));

        // Merge Sort
        int[] arr6 = { 12, 11, 13, 5, 6, 7, 15, 8, 2, 1, 4, 9, 10, 14, 3 };
        mergeSort(arr6, 0, arr6.length-1);
        System.out.println("mergeSort: " + Arrays.toString(arr6));

        // Counting Sort
        int[] arr7 = { 12, 11, 13, 5, 6, 7, 15, 8, 2, 1, 4, 9, 10, 14, 3 };
        countingSort(arr7);
        System.out.println("countingSort: " + Arrays.toString(arr7));

        // Radix Sort
        int[] arr8 = { 170, 45, 75, 90, 802, 24, 2, 66, 569, 78, 231, 452, 333, 11 };
        radixSort(arr8);
        System.out.println("radixSort: " + Arrays.toString(arr8));

        // Bucket Sort
        float[] arr9 = { 0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f, 0.432f, 0.876f, 0.131f };
        bucketSort(arr9);
        System.out.println("bucketSort: " + Arrays.toString(arr9));
    }
}
