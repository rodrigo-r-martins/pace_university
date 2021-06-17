import java.util.Hashtable;
import java.util.Scanner;

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
 *  Assignment: #3
 *  Problem: HashTable and AVL Tree
 *  Description: In this problem we have to measure and compare the running time of a HashTable and an AvlTree by adding consecutive keys from 1 to n and by searching for a key that is not in the HashTable and AvlTree.
 *
 *  Input: n -> The number of nodes in the tree
 *  Output:
 *      - running time of adding n number of entries in each a Hashtable or AvlTree
 *      - running time of searching a key that is not in a Hashtable and AvlTree
 *
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Scanner scan;                           -> Used to get input size from user
 *  int n;                                  -> Variable used to store the input size
 *  Hashtable<Integer, Integer> hashtable;  -> HashTable
 *  AvlTree<Integer> avlTree;               -> AvlTree
 *
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *   1) We conject that the asymptotic running time of adding n entries with consecutive keys in a separate-chaining hash table will be O(n). Inserting each individual entry has a run time of O(1) but as n increases, the run time should also increase because there are more data points to be inserted. We know that running time to query a hash table (or time it takes to find the correct bucket key is in) is O(1), but because we have separate chaining, it is possible that in the worst-case scenario, every key may be in the same bucket and if the key we are searching for is not present, we need to search through each spot of the list, which means running time for searching for a key that is not in the table is O(n).
 *
 *
 *   2) We conject that the asymptotic running time of inserting n entries into an AVL tree should be O(n log n). We know from the information given that the worst-case running time per insertion is O(log n) per insertion, therefore if we have n insertions, the running time to insert all values of n would be O(n log n). Also, we know that the running time of querying an AVL table is O(log n) because the tree is balanced already. Because an AVL tree balances itself through rotations, the search time should always be O (log n) for any given n value.
 *
 *
 *   3)
 *      Running times of construction time:
 *
 *                      n=10^2      n=10^3      n=10^4      n=10^5      n=10^6
 *   ----------------------------------------------------------------------------------------
 *   HashTable:         164000      1253101     3982800     14133500    59692599
 *   Avl Tree:          743999      1856701     7288401     19028900    168350800
 *
 *
 *      Running times of searching time:
 *
 *                      n=10^2     n=10^3     n=10^4     n=10^5      n=10^6
 *  ----------------------------------------------------------------------------------------
 *  HashTable:          107799     148100     946401     5426600     16528100
 *  Avl Tree:           26599      32500      42799      44399       53700
 *
 *   4)
 *   HASH TABLES:
 *   Based on the running times from this experiment, we can confirm our conjecture that the running time of inserting n values into a hash table with separate chaining is O(n). As seen in the chart, as n increases by a factor of 10, the running time also increases by a factor of 10. For example, when n is 10^4, run time is 3982800 (7 digits), and when n is 10^5, run time is 14133500 (8 digits). Also based on the information above, we can confirm our conjecture that the running time to search for a key that is not present is also O(n). This is shown in the same way, that when n increases by a factor of 10, so does running time. For example, when n is 10^4, running time of search is 946401 (6 digits), and when n is increased to 10^5, running time increases to 5426600 (7 digits).
 *
 *   AVL TREES:
 *   Based on the running times from this experiment, we can also confirm our conjecture that the running time of inserting n values into an AVL tree is O(n log n). This can be proven by the chart above, where we see that as n increases by a factor of 10, the running time also increases by a factor of 10. For example when n is 10^4, running time is 7288401 (7 digits), whereas when n is increased to 10^5, running time is 19028900 (8 digits). Also, based on the experiment we can confirm our theory that the running time of searching an AVL tree is O(log n). As seen above, regardless of how large n gets, the run time is always very similar and very small compared to the insertion time. For example, when n is 10^2, run time is 26599, and when n is increased all the way to n^6, run time is still only 53700.
 *
 *   5)
 *
 *************************************************************************/


public class Assignment_3 {
    public static void main(String[] args) {
        // Getting input number
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = scan.nextInt();


        // HASHTABLE
        System.out.println("\n===== HASHTABLE =====");
        Hashtable<Integer, Integer> hashtable = new Hashtable<>(1000, (float)0.75);
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashtable.put(i, 1);
        }
        // Getting running time of inserting keys in a hashtable
        System.out.println("Inserting time = " + (System.nanoTime() - startTime) + " nanosecs");

        // Getting running time of searching for a key in a HashTable
        startTime = System.nanoTime();
        System.out.println((n+1) + " in hashtable? " + hashtable.contains(n+1));
        System.out.println("Searching time = " + (System.nanoTime() - startTime) + " nanosecs\n");


        // AVL TREE
        System.out.println("===== AVL TREE =====");
        AvlTree<Integer> avlTree = new AvlTree<>();
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            avlTree.insert(i);
        }
        // Getting running time of inserting keys in a AvlTree
        System.out.println("Inserting time = " + (System.nanoTime() - startTime) + " nanosecs");

        // Getting running time of searching for a key in a AvlTree
        startTime = System.nanoTime();
        System.out.println((n+1) + " in avlTree? " + avlTree.contains(n+1));
        System.out.println("Searching time = " + (System.nanoTime() - startTime) + " nanosecs");
    }
}
