public class BinarySearch {

    static boolean binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;

        while (high >= low) {
            int middle = (low+high) / 2;
            if (arr[middle] == key) {
                return true;
            }
            if (arr[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = {10, 18, 20, 25, 30, 41, 52, 61};
        // data.length = 8;

        System.out.println(binarySearch(data, 18));
    }
}
