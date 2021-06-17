public class BubbleSort {
    public static void main(String[] args) {

        // Printing array before bubble sort
        int[] data = {5, 1, 13, -5, 16, 2, 12, 8, -2, 14};
        System.out.print("Before bubble sort: {");
        for (int i=0; i<data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.print("\b\b}\n");


        // Bubble sort algorithm
        int temp;
        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data.length-1; j++) {
                if (data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }


        // Printing array after bubble sort
        System.out.print("After bubble sort: {");
        for (int i=0; i<data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.print("\b\b}\n");
    }
}
