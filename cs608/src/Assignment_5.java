import java.util.*;

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
 *      - https://www.geeksforgeeks.org/quicksort-using-random-pivoting/
 *      - https://knpcode.com/java-programs/bucket-sort-java-program/
 *
 *
 *  Assignment: #5
 *  Problem: Quick Sort and Bucket Sort
 *  Description: In this problem we have to measure and compare the running time of Quick Sort and Bucket Sort methods using the input of n points in the unit circle.
 *
 *  Input: n -> The number of points in the array
 *  Output:
 *      - running time of the Quick Sort algorithm
 *      - running time of the Bucket Sort algorithm
 *
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  int n;              -> Variable used to store the input size
 *  Point[] points;     -> Store the array of double created of size n
 *  long startTime      -> Variable used to measure the running time
 *
 *
 *  Visible methods:
 *
 *  Assignment_5.java class:
 *  public static void printArrayOfPoints(Point[] points)
 *  private static void swap(Point[] arr, int i, int j)
 *  public static Point getRandomPoint()
 *  public static Point[] getPointsArray(int n)
 *  private static void getRandomPivot(Point[] arr, int low, int high)
 *  public static void quickSort_randomPivot(Point[] arr, int low, int high)
 *  private static int partitionRandomPivot(Point[] arr, int low, int high)
 *  public static void bucketSort_unitCirclePoints(Point[] arr, int x)
 *
 *  Point.java class:
 *  public double getDistance()
 *  public int compareTo(Point p)
 *  public String toString()
 *
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *   1) public static void quickSort_randomPivot(double[] arr, int low, int high);
 *
 *   2) public static void bucketSort_unitCirclePoints(Point[] arr, int x)
 *
 *   3)
 *      Running times:
 *
 *                      n=10^3      n=10^4      n=10^5      n=10^6
 *   ----------------------------------------------------------------------
 *   Quick Sort:	   5817000	   5381800	   23476600	   295168800
 *   Bucket Sort:	   10541600	   23381300	   61670300	   893756700
 *
 *
 *   4) Based on the running times from question 3, we can conclude that our Quick Sort method is
 *   running at O(n log n) growth. This can be seen by noting that the run times are very similar
 *   for n=10^3 and n=10^4, but when n increases to higher values such as n=10^5 and n=10^6, the
 *   run times increase drastically. This matches the expected run time of O(n log n).
 *
 *   Also, based on the run times from from question 3, we can confirm that our Bucket Sort method
 *   runs at O(n) growth. Each time that n increase by a factor of 10, the run time also increases
 *   by approximately the same amount each time. This confirms linear growth, or O(n), which is
 *   what should be expected.
 *
 *
 *
 *
 *************************************************************************/

public class Assignment_5 {

    public static void printArrayOfPoints(Point[] points) {
        System.out.print("[");
        for (Point p : points) {
            System.out.print(p.toString() + ", ");
        }
        System.out.print("\b\b]\n");
    }

    private static void swap(Point[] arr, int i, int j) {
        Point temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static Point getRandomPoint() {
        double t = 2 * Math.PI * Math.random();
        double u = Math.random() + Math.random();
        double r = 0;
        if (u > 1) {
            r = 2-u;
        } else {
            r = u;
        }
        double x = r * Math.cos(t);
        double y = r * Math.sin(t);
        return new Point(x, y);
    }

    public static Point[] getPointsArray(int n) {
        // Function used to generate an array of n distance points (not sorted)
        Point[] pointsArr = new Point[n];
        for (int i=0; i<n; i++) {
            Point points = getRandomPoint();
            pointsArr[i] = points;
        }
        return pointsArr;
    }

    private static void getRandomPivot(Point[] arr, int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high-low)+low;
        swap(arr, pivot, high);
    }

    public static void quickSort_randomPivot(Point[] arr, int low, int high) {
        if (low < high) {
            int pivot_pos = partitionRandomPivot(arr, low, high);
            quickSort_randomPivot(arr, low, pivot_pos - 1);
            quickSort_randomPivot(arr, pivot_pos + 1, high);
        }
    }

    private static int partitionRandomPivot(Point[] arr, int low, int high) {
        getRandomPivot(arr, low, high);
        Point pivot = arr[high];
        int pivotIndex = low-1;
        for (int i=low; i<high; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        swap(arr, high, pivotIndex+1);
        return pivotIndex+1;
    }

    public static void bucketSort_unitCirclePoints(Point[] arr, int x) {
        LinkedList<Point>[] buckets = new LinkedList[x];
        int length = arr.length;

        for (int i=0; i<length; i++) {
            buckets[i] = new LinkedList<Point>();
        }

        for (int i=0; i<length; i++) {
            double distance = arr[i].getDistance();
            if (distance < 1) {
                int index = (int)(Math.floor(Math.pow(distance, 2) * x));
                buckets[index].add(arr[i]);
            } else if (distance == 1) {
                buckets[x-1].add(arr[i]);
            }
        }
        //System.out.println(Arrays.toString(buckets));

        for (int i=0; i<length; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (List<Point> bucket : buckets) {
            for (Point points : bucket) {
                arr[index++] = points;
            }
        }
    }

    public static void main(String[] args) {
        // Getting input number
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int n = scan.nextInt();

        // Declaring the array of points to be instantiated below
        Point[] points;
        long startTime;


        // QUICKSORT
        points = getPointsArray(n);
        startTime = System.nanoTime();
        quickSort_randomPivot(points, 0, points.length-1);
        System.out.println("QuickSort = " + (System.nanoTime() - startTime) + " nanosecs");


        // BUCKETSORT
        points = getPointsArray(n);
       /* prints sorted points and distances after sort
        printArrayOfPoints(points);
        for (int i = 0; i < points.length; i++) {
        	System.out.println(points[i].getDistance());
        } */
        startTime = System.nanoTime();
        bucketSort_unitCirclePoints(points, n);
       /* prints sorted points and distances after sort
        printArrayOfPoints(points);
        for (int j = 0; j < points.length; j++) {
        	System.out.println(points[j].getDistance());
        } */
        System.out.println("BucketSort = " + (System.nanoTime() - startTime) + " nanosecs");
    }
}