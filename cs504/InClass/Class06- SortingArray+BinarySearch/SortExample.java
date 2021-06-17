class SortExample {
    public static void main(String[] args) {

        // insertion sort
        int[] input = {5,2,4,6,1,3};
        Sort arrA = new Sort();
        System.out.println("Before insertion sort");
        arrA.printArray(input);
        arrA.insertionSort(input);
        System.out.println("After insertion sort");
        arrA.printArray(input);

        // selection sort
        int[] input1 = {5,1,12,-5,16,2,12,14};
        Sort arrB = new Sort();
        System.out.println("Before selection sort");
        arrB.printArray(input1);
        arrB.selectionSort(input1);
        System.out.println("After selection sort");
        arrB.printArray(input1);
    }
}