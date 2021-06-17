/*************************************************************************
 *
 *  Pace University
 *  Fall 2020
 *  Algorithms and Computing Theory
 *
 *  Course: CS 608
 *  Team members: Rodrigo Martins, Adam Caragine
 *  Other collaborators: None
 *  References: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/,
 *  https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
 *
 *
 *  Assignment: #1
 *  Problem: Maximum Subarray
 *  Description: In this problem we have to find the subarray within the given array that contains the maximum sum
 *
 *  Input: n -> The size of the array
 *  Output: maximum sum of a subarray
 *
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
 *  public static int maxSubArr_bruteForce(int[] nums);
 *  public static int maxCrossingSubArr(int[] arr, int low, int mid, int high);
 *  public static int maxSubArr_divAndConq(int[] arr, int low, int high);
 *  public static int maxSubArr_kadane(int[] arr);
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *   1) Implemented in the methods:
 *          public static int maxSubArr_bruteForce(int[] nums);
 *          public static int maxCrossingSubArr(int[] arr, int low, int mid, int high);
 *          public static int maxSubArr_divAndConq(int[] arr, int low, int high);
 *
 *   2) Running times measured:
 *
 *                  n=10^2      n=10^3      n=10^4      n=10^5      n=10^6
 *   ---------------------------------------------------------------------------
 *   Brute force:   3717300     6446300     43621400    3218741800  340068710200
 *   Div Conquer:   296300      875500      2759800     6999000     25746100
 *   Kadane:        116400      124300      535800      2698100     5158800
 *
 *   3) Based on the running times observed above, we can conclude that the experiment results successfully match what is expected.
 *   For the brute force algorithm, running time increases approximately as a function of n as O(n^2) or quadratically. This is supported by the fact that as n increased by a factor of 10, the run time increased by a factor of 100 (as n grows by one digit, run time grows by two digits). when n increases from 10000 to 100000, the run time increases from ~43 million to ~ 3.2 billion nanoseconds. It doesn't match in number of digits to any column of other algorithms.
 *   The divide and conquer algorithm is much more efficient, as run time increases approximately as a function of n as O(n log n). This is supported by the data where each time n increases by a factor of 10, run time also increases; and as n gets larger, the amount of growth in time increases but it is not exponential growth such as in brute force, having one digit less of time in each column, except in column 4 and 5 where the running time is much slower than the brute force, where it has 3 and 4 digits less in the running time than brute force. In number of digits it matches with the Kadane algorithm in columns 1, 2 and 4, however we can see that it is slower.
 *   The most efficient algorithm, however, is the Kadane algorithm; where we see running time grow approximately in a linear function of n, O(n). When observing the run times of n=10^4 through n=10^6, we notice that the growth is rather steady, approximately 2 million nanoseconds each time. More support of this being linear growth is the fact that the run time for larger inputs such as n=10^6 are still drastically smaller than that of the brute force and divide and conquer methods.
 *
 *   4) Implemented in the method: public static int maxSubArr_kadane(int[] arr);
 *
 *************************************************************************/

import java.util.Scanner;

public class Assignment_1 {

    public static int maxSubArr_bruteForce(int[] nums) {
        // Use two loops to compare the sum of each subarray in the array
        // Running time = O(n^2)
        int sumMax = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            // loop through all numbers
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                // loop through number i to the end of array
                sum += nums[j];
                if (sum > sumMax) {
                    // record the sum of subarray that is bigger
                    sumMax = sum;
                }
            }
        }
        return sumMax;
    }

    public static int maxCrossingSubArr(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=mid; i>=low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j=mid+1; j<=high; j++) {
            sum += arr[j];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum+rightSum;
    }

    public static int maxSubArr_divAndConq(int[] arr, int low, int high) {
        // Use the method divide and conquer to find the maximum sum in a subarray
        // Running time = O(n log n)
        if (high == low) {
            return arr[low];
        } else {
            int mid = (low+high)/2;
            // After finding the mid value, it uses recursion to find lefts and rights sum
            int leftSum = maxSubArr_divAndConq(arr, low, mid);
            int rightSum = maxSubArr_divAndConq(arr, mid+1, high);
            int crossSum = maxCrossingSubArr(arr, low, mid, high);
            return Math.max(Math.max(leftSum, rightSum), crossSum);
        }
    }

    public static int maxSubArr_kadane(int[] arr) {
        // This method runs in linear time since it loop through all numbers in the array only once
        // Running time = O(n)
        int maxSoFar = Integer.MIN_VALUE;
        int maxEnding = 0;
        for (int i=0; i<arr.length; i++) {
            // It will loop through the numbers comparing the maximum sum value in a subarray among all positive segments (maxEnding).
            // Every time we have a positive sum we compare to maxSoFar and update it if it is greater.
            maxEnding += arr[i];
            if (maxEnding < 0) {
                maxEnding = 0;
            } else if (maxSoFar < maxEnding) {
                maxSoFar = maxEnding;
            }
        }
        return maxSoFar;
    }


    public static void main(String[] args) {
        // Getting the size of array from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arraySize = scan.nextInt();
        // Creating an array of size n (entered by user)
        int[] numbers = new int[arraySize];

        // Generating array of n numbers with random numbers
        int min = -5;
        int max = 5;
        for (int i=0; i<numbers.length; i++) {
            // Adding random numbers to the array
            double randomNumber = Math.random() * (max - min + 1) + min;
            numbers[i] = (int)randomNumber;
            //System.out.println(numbers[i]);   // Used for testing
        }

        // Printing array
        System.out.print("[");
        for (int n : numbers) {
            System.out.print(n + ", ");
        }
        System.out.print("\b\b]\n");

        // Getting running time of each algorithm
        long startTime = System.nanoTime();
        System.out.println("MaxSubArrSum = " + maxSubArr_bruteForce(numbers));
        System.out.println("bruteForce time = " + (System.nanoTime() - startTime) + " nanosecs");

        startTime = System.nanoTime();
        System.out.println("MaxSubArrSum = " + maxSubArr_divAndConq(numbers, 0, numbers.length-1));
        System.out.println("divAndConq time = " + (System.nanoTime() - startTime) + " nanosecs");

        startTime = System.nanoTime();
        System.out.println("MaxSubArrSum = " + maxSubArr_kadane(numbers));
        System.out.println("kadane time = " + (System.nanoTime() - startTime) + " nanosecs");
    }
}
