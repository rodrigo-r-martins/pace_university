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
 *      1) https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
 *      2) https://java2blog.com/depth-first-search-in-java/
 *
 *
 *  Assignment: #4
 *  Problem: Depth First Search - DFS
 *  Description: In this problem we have to implement DFS algorithm, compute the DFS, and measure and compare the running time at using different edges.
 *
 *  Input:  V -> The number of nodes (vertices) in the graph
 *          E -> The number of edges in the graph
 *  Output:
 *      - running time of searching graph using DFS
 *
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  public static int time;     -> Global variable used to measure the time of each Vertex inside DFS function
 *  public static String[] colors;  -> Global variable used to store the colors of each Vertex inside DFS function
 *  public static int[] discoveryTime;  -> Global variable used to measure the discovery time of each Vertex inside DFS function
 *  public static int[] finishTime; -> Global variable used to measure the finish time of each Vertex inside DFS function
 *  int V;              -> Variable used to store the number of nodes (vertices)
 *  int E;              -> Variable used to store the number of edges
 *  LinkedList<LinkedList<Integer>> adj;     -> Variable used to store the graph
 *
 *
 *  Visible methods:
 *
 *  public static int getRandomNumber(int min, int max);
 *  public static void addEdge(LinkedList<LinkedList<Integer>> adj, int U, int V);
 *  public static void printEdges(LinkedList<LinkedList<Integer>> adj);
 *  public static void DFS(LinkedList<LinkedList<Integer>> adj,
 *                            String[] colors,
 *                            int[] discoveryTime,
 *                            int[] finishTime);
 *  private static void DFS_Visit(LinkedList<LinkedList<Integer>> adj,
 *                                  int U,
 *                                  int[] discoveryTime,
 *                                  int[] finishTime,
 *                                  String[] colors);
 *  public static void printTimes(int[] discoveryTime, int[] finishTime);
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *   1)
 *      a)  Scanner scan = new Scanner(System.in);
 *          System.out.print("Enter the number of nodes (vertices): ");
 *          int V = scan.nextInt();
 *          System.out.print("\nEnter the number of edges: ");
 *          int E = scan.nextInt();
 *
 *      b)  LinkedList<LinkedList<Integer>> adj = new LinkedList<LinkedList<Integer>>(V);
 *          for (int i=0; i<V; i++) {
 *             adj.add(new LinkedList<>());
 *          }
 *          for (int i=0; i<E; i++) {
 *             int randomU = getRandomNumber(0, V-1);
 *             int randomV = getRandomNumber(0, V-1);
 *             addEdge(adj, randomU, randomV);
 *          }
 *
 *      c)  public static void DFS(LinkedList<LinkedList<Integer>> adj,
 *                            String[] colors,
 *                            int[] discoveryTime,
 *                            int[] finishTime);
 *          public static void DFS_Visit(LinkedList<LinkedList<Integer>> adj,
 *                            int U,
 *                            int[] discoveryTime,
 *                            int[] finishTime,
 *                            String[] colors);
 *          public static void printTimes(int[] discoveryTime, int[] finishTime);
 *
 *          Just a simple example:
 * Enter the number of nodes (vertices): 4
 * Enter the number of edges: 7
 * ======== GRAPH ========
 * Vertex 0: 2, 3
 * Vertex 1: 0, 2
 * Vertex 2: 3, 1
 * Vertex 3: 3
 * =======================
 * DFS: 3 1 2 0
 * Vertex 0: (1, 8)
 * Vertex 1: (5, 6)
 * Vertex 2: (2, 7)
 * Vertex 3: (3, 4)
 *
 *      d)  Running time of the above simple example:
 *          DFS Running time = 11778000 nanosecs
 *
 *          The running times of the question 2 is bellow.
 *
 *   2)
 *      Running times:
 *
 *                      E=V-1           E=(V-1)^3/2         E=(V-1)^2
 *   ----------------------------------------------------------------------
 *   V = 10:            12797500        12704500            14969000
 *   V = 100:           12727700        12941000            14431400
 *   V = 1000:          23286200        23338800            88026400
 *
 *
 *   3) The running time of the DFS was the same as expected ( O(V+E) ) as we can see in the running times of the table above. We can see that even if the number of vertices and edges becomes bigger, the running time doesn't grow a digit. When using 10 or 100 vertices (rows 1 and 2) the running time is approximately 12-14 million. However when using 1000 vertices (row 3) the running time is approximately 23 million for the number of edges on columns 1 and 2, and 88 million for the number of edges in column 3, yet the running time still the same number of digits. Because of that, the running time for the all inputs turns to be O(V+E).
 *
 *
 *
 *
 *************************************************************************/

public class Assignment_6 {

    public static int time;
    public static String[] colors;
    public static int[] discoveryTime;
    public static int[] finishTime;

    public static int getRandomNumber(int min, int max) {
        // Function used to generate random numbers from min to max
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void addEdge(LinkedList<LinkedList<Integer>> adj, int U, int V) {
        if (adj.get(U).size() == 0) {
            adj.get(U).add(V);
        } else {
            boolean flag = true;
            while (flag) {
                U = (int) (Math.random() * (adj.size() - 1 + 1));
                V = (int) (Math.random() * (adj.size() - 1 + 1));
                if (!adj.get(U).contains(V)) {
                    adj.get(U).add(V);
                    flag = false;
                }
            }
        }
    }

    public static void printEdges(LinkedList<LinkedList<Integer>> adj) {
        for (int i=0; i<adj.size(); i++) {
            System.out.print("\nVertex " + i + ": ");
            for (int j=0; j<adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + ", ");
            }
            System.out.print("\b\b");
        }
        System.out.println();
    }

    public static void DFS(LinkedList<LinkedList<Integer>> adj,
                           String[] colors,
                           int[] discoveryTime,
                           int[] finishTime)
    {
        for (int U=0; U<adj.size(); U++) {
            colors[U] = "white";
        }
        time = 0;
        for (int U=0; U<adj.size(); U++) {
            if (colors[U].equals("white")) {
                DFS_Visit(adj, U, discoveryTime, finishTime, colors);
            }
        }
    }

    private static void DFS_Visit(LinkedList<LinkedList<Integer>> adj,
                                 int U,
                                 int[] discoveryTime,
                                 int[] finishTime,
                                 String[] colors)
    {
        time++;
        discoveryTime[U] = time;
        colors[U] = "gray";
        for (int V : adj.get(U)) {
            if (colors[V].equals("white")) {
                DFS_Visit(adj, V, discoveryTime, finishTime, colors);
            }
        }
        colors[U] = "black";
        time++;
        finishTime[U] += time;
        System.out.print(U + " ");
    }

    public static void printTimes(int[] discoveryTime, int[] finishTime) {
        for (int i=0; i<discoveryTime.length; i++) {
            System.out.print("Vertex " + i + ": (" + discoveryTime[i] + ", " + finishTime[i] + ")");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Getting input number
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of nodes (vertices): ");
        int V = scan.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = scan.nextInt();

        // Creating a graph with V vertices
        LinkedList<LinkedList<Integer>> adj = new LinkedList<>();

        for (int i=0; i<V; i++) {
            adj.add(i, new LinkedList<>());
        }

        for (int i=0; i<E; i++) {
            int randomU = getRandomNumber(0, V-1);
            int randomV = getRandomNumber(0, V-1);
            addEdge(adj, randomU, randomV);
        }

        discoveryTime = new int[V];
        finishTime = new int[V];
        colors = new String[V];
        Arrays.fill(discoveryTime, 0);
        Arrays.fill(finishTime, 0);

        System.out.print("======== GRAPH ========");
        printEdges(adj);
        System.out.println("=======================");
        System.out.print("DFS: ");
        long startTime = System.nanoTime();
        DFS(adj, colors, discoveryTime, finishTime);
        System.out.println("\n=======================");
        System.out.println("=> DFS - Vertex Computed Time (Discovery, Finish):");
        printTimes(discoveryTime, finishTime);
        System.out.println("=======================");
        System.out.println("DFS Running time = " + (System.nanoTime() - startTime) + " nanosecs");
    }
}

