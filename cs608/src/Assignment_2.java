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
 *
 *
 *  Assignment: #2
 *  Problem: Binary Search Tree (BST)
 *  Description: In this problem we have to measure and compare the running time of a skewed BST and a balanced BST by adding values from 1 to x (skewed) and random numbers without repetition (balanced).
 *
 *  Input: x -> The number of nodes in the tree
 *  Output:
 *      - boolean value: true, if tree contains the number searched, false otherwise
 *      - running time of searching a number in each type of tree
 *
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Scanner scan;                       -> Class scanner used to get input size from user
 *  int x;                              -> Variable used to store the input size
 *  BinarySearchTree<Integer> BST_S;    -> Skewed BST
 *  BinarySearchTree<Integer> BST_R;    -> Balanced BST
 *  TreeMap<Integer, Integer> TREE_MAP; -> TreeMap
 *  int randomNumberToBeSearched;       -> Random number to be searched in the Balanced BST and TreeMap
 *
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
 *
 *  public static int getRandomNumber(int min, int max);
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *   1) If the number searched is the root, it will run in constant time, O(1). The same answer if the tree is empty, and in that case we could also use the operation isEmpty().
 *      However, if the number is not the root, the worst case of a BST is O(h) where h is the height if the tree. So, the Skewed Tree it should run in linear time, O(n) where n is the number of the height of the tree, because since the numbers are always greater than the root, all numbers will be added to the right side of the root. So, in order to find a number in this type of tree, we would have to use the method contain(number) which would go through all the numbers in the tree to find the number unless the number is smaller than the leaf.
 *      On the other hand, if the tree is balanced (it has, for each node, about the same number of nodes in its left subtree as in its right subtree), it will run in the worst case in log n times, O(log n) (where n is the number of height of the tree), since it will compare the number to the root and if the number is smaller it will cut the tree in half and look only in the left side, or if the number is higher it will look only the right side, and it will repeat this operation recursively until it finds (or does not) the number.
 *
 *   2) Running times measured:
 *
 *                      n=10        n=10^2      n=500       n=10^3      n=5000      n=10^4
 *   ----------------------------------------------------------------------------------------
 *   Skewed BST:        8340000     8413400     8545600     8554300     8684800     8893800
 *   Balanced BST:      365800      285200      283000      308500      365000      398300
 *
 *   3) For the Skewed BST, we observe from columns 1 through 6 that when the input size grows by 1 digit, the running time is always approximately 8 million, so they don't grow a single digit for all input sizes. This supports our conjecture that the Skewed BST run time should grow in approximately a function O(n) because there is very small increase in  nanoseconds coinciding with increase in input size, but the number of digits matches for all input sizes.
 *   For the Balanced BST, we see also in columns 1 through 6 that the rate of growth is very small coinciding with the increase in input size and, moreover, the running time matches for all input sizes in number of digits, however we note that the run time for all input sizes is much faster for a balanced BST than the skewed BST. This is evidence that supports our belief that a Balanced BST runs in O(log n).
 *
 *
 *   4) Running time measured for TreeMap:
 *
 *                  n=10        n=10^2      n=500       n=10^3      n=5000      n=10^4
 *   -----------------------------------------------------------------------------------
 *   TreeMap:       170000      154500      158700      163100      166100      167300
 *
 *   For the TreeMap, the running time is similar to a Balanced BST, even when the input size grows by a digit, the running time still with the same number of digits, and surprisingly when we use n=10 (column 1) the amount of time is greater than the others input sizes, and this is the same behavior to Balanced BST as we can see in the row 2 column 1 of question 2. Moreover, in the TreeMap columns 2 to 6, the amount of time growth is insignificant even when we use input size with 3 more digits. So, we can say that the running time of TreeMap matches with the running time of Balanced Tree since both of them has the same number of digits in the running time to all input sizes.
 *   However, when comparing to Skewed Tree, the amount of time is one digit less for all n sizes, as we can see the columns 1 to 6 of TreeMap and in row 1 of question 2 that is related to Skewed BST.
 *   To conclude, we can see a huge difference in the result running time when comparing Tree Map to Skewed BST since it has one more digit than TreeMap. However, when comparing it to a Balanced Tree, we can see that the number of digits in running time matches for all n sizes, yet TreeMap amount of time is still a little bit faster for all n sizes.
 *
 *************************************************************************/

import java.util.Scanner;
import java.util.TreeMap;

public class Assignment_2 {

    public static int getRandomNumber(int min, int max) {
        // Function used to generate random numbers from min to max
        return (int)(Math.random() * (max-min+1) + min);
    }

    public static void main(String[] args) {
        // Getting input number
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int x = scan.nextInt();

        // Creating skewed BST
        BinarySearchTree<Integer> BST_S = new BinarySearchTree<>();
        for (int i=1; i<=x; i++) {
            BST_S.insert(i);
        }

        // Creating balanced BST and TreeMap with non-repeating random numbers
        BinarySearchTree<Integer> BST_R = new BinarySearchTree<>();
        TreeMap<Integer, Integer> TREE_MAP = new TreeMap<>();
        for (int i=0; i<x; i++) {
            int number = getRandomNumber(1, x);
            boolean containBST = BST_R.contains(number);
            boolean containTM = TREE_MAP.containsKey(number);
            if (!containBST && !containTM) {
                BST_R.insert(number);
                TREE_MAP.put(number, 1);
            } else {
                // If tree contains random number, generate another number that multiplies the previous number by another random number in a range(143,1267) and add the new number to another random number in a range(13,2312268)
                // This way it's almost impossible that we get repeated numbers
                BST_R.insert(number * getRandomNumber(143, 1267) + getRandomNumber(13, 2312268));
                TREE_MAP.put(number * getRandomNumber(143, 1267) + getRandomNumber(13, 2312268), 1);
                // Numbers of the range were chosen randomly without any reference
            }
        }

        // Getting running time of each algorithm
        long startTime = System.nanoTime();
        System.out.println("===========================");
        System.out.println((x+1) + " in BST_S? " + BST_S.contains(x+1));
        System.out.println("Time = " + (System.nanoTime() - startTime) + " nanosecs");

        int randomNumberToBeSearched = getRandomNumber(1, x);
        startTime = System.nanoTime();
        System.out.println("===========================");
        System.out.println(randomNumberToBeSearched + " in BST_R? " + BST_R.contains(randomNumberToBeSearched));
        System.out.println("Time = " + (System.nanoTime() - startTime) + " nanosecs");

        startTime = System.nanoTime();
        System.out.println("===========================");
        System.out.println(randomNumberToBeSearched + " in TREE_MAP? " + TREE_MAP.containsKey(randomNumberToBeSearched));
        System.out.println("Time = " + (System.nanoTime() - startTime) + " nanosecs");
    }
}
