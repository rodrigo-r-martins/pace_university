import java.util.Arrays;

public class DynamicProgramming {

    /*
    Dynamic Programming algorithms used in class.
     */

    public static int fibonacciAt(int index) {
        if (index < 2) {
            return 1;
        }
        return fibonacciAt(index-1) + fibonacciAt(index-2);
    }

    public static int rodCutting(int[] prices, int rodLength) {
        if (rodLength <= 0) {
            return 0;
        }
        int revenue = Integer.MIN_VALUE;
        for (int i = 0; i < rodLength; i++) {
            revenue = Math.max(revenue, prices[i] + rodCutting(prices, rodLength-i-1));
        }
        return revenue;
    }

    public static int memoizedRodCutting(int[] prices, int rodLength) {
        int[] revenueList = new int[rodLength+1];
        Arrays.fill(revenueList, Integer.MIN_VALUE);
        return MRCAux(prices, rodLength, revenueList);
    }

    private static int MRCAux(int[] prices, int rodLength, int[] revenueList) {
        if (revenueList[rodLength] >= 0) {
            return revenueList[rodLength];
        }
        int revenue = Integer.MIN_VALUE;
        if (rodLength == 0) {
            revenue = 0;
        } else {
            for (int i = 0; i < rodLength; i++) {
                revenue = Math.max(revenue, prices[i] + MRCAux(prices, rodLength-i-1, revenueList));
            }
        }
        revenueList[rodLength] = revenue;
        return revenue;
    }

    public static int rodCuttingBottomUp(int[] prices, int rodLength) {
        int[] revenueList = new int[rodLength+1];
        revenueList[0] = 0;
        for (int i = 1; i <= rodLength; i++) {
            int revenue = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                revenue = Math.max(revenue, prices[j] + revenueList[i-j-1]);
            }
            revenueList[i] = revenue;
        }
        return revenueList[rodLength];
    }

    public static int makingChange(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        int min = amount;
        for (int coin : coins) {
            if (coin <= amount) {
                int temp = 1 + makingChange(amount - coin, coins);
                if (temp < min) {
                    min = temp;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {

        // Fibonacci
        System.out.println(fibonacciAt(5));

        // Rod Cutting
        int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = prices.length;
        System.out.println(rodCutting(prices, rodLength));

        // Memoized Rod Cutting
        int[] newPrices = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int newRodLength = prices.length;
        System.out.println(memoizedRodCutting(newPrices, newRodLength));

        // Rod Cutting Bottom Up
        int[] otherPrices = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int otherRodLength = prices.length;
        System.out.println(rodCuttingBottomUp(otherPrices, otherRodLength));

        // Making Change
        int amount = 45;
        int[] coins = { 1, 5, 10, 25 };
        System.out.println(makingChange(amount, coins));
    }
}
