import java.util.*;

public class GraphTheory {
    public static int time;

    private static class Vertex implements Comparable<Vertex> {
        private final String name;
        private String color;
        private int discoveryTime;
        private int finishTime;
        private boolean wasVisited;

        Vertex(String value) {
            this.name = value;
            this.color = "white";
            this.discoveryTime = 0;
            this.finishTime = 0;
            this.wasVisited = false;
        }

        public String getName() {
            return name;
        }

        public int getDiscoveryTime() {
            return discoveryTime;
        }

        public int getFinishTime() {
            return finishTime;
        }

        public String getColor() {
            return color;
        }

        public boolean getWasVisited() {
            return wasVisited;
        }

        @Override
        public int compareTo(Vertex V) {
            return this.name.compareTo(V.name);
        }
    }

    public static class Graph {
        private Map<Vertex, List<Vertex>> adj;
        private final int numberOfVertices;

        Graph(int n) {
            numberOfVertices = n;
            adj = new LinkedHashMap<>(numberOfVertices);
        }

        public void addVertex(String vertex) {
            adj.putIfAbsent(new Vertex(vertex), new ArrayList<>(numberOfVertices));
        }

        public void addEdge(String U, String V) {
            for (Vertex W : adj.keySet()) {
                if (W.name.equals(U)) {
                    adj.get(W).add(new Vertex(V));
                }
                /*  // Only if the graph is undirected
                if (W.name.equals(V)) {
                    adj.get(W).add(new Vertex(U));
                }
                 */
            }
        }

        public String getEdgesOf(Vertex U) {
            return adj.get(U).toString();
        }

        public void printGraph() {
            for (Vertex V : adj.keySet()) {
                System.out.print(V.name + " -> ");
                for (Vertex U : adj.get(V)) {
                    System.out.print(U.name + ", ");
                }
                System.out.println("\b\b");
            }
        }

        public void DFS() {
            for (Vertex U : adj.keySet()) {
                U.color = "white";
            }
            time = 0;
            for (Vertex U : adj.keySet()) {
                if (U.color.equals("white")) {
                    DFS_Visit(U);
                }
            }
        }

        private void DFS_Visit(Vertex U) {
            time++;
            U.discoveryTime = time;
            U.color = "gray";
            for (Vertex V : adj.get(U)) {
                if (V.color.equals("white")) {
                    DFS_Visit(V);
                }
            }
            U.color = "black";
            time++;
            U.finishTime += time;
            System.out.print(U.name + " (" + U.discoveryTime + ", " + U.finishTime + ")  ");
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(5);
        G.addVertex("A");
        G.addVertex("B");
        G.addVertex("C");
        G.addVertex("D");
        G.addVertex("E");
        G.addVertex("F");
        G.addVertex("G");
        G.addVertex("H");

        G.addEdge("A","B");
        G.addEdge("A","C");
        G.addEdge("B","D");
        G.addEdge("B","E");
        G.addEdge("C","D");
        G.addEdge("C","G");
        G.addEdge("D","E");
        G.addEdge("E","D");
        G.addEdge("E","G");
        G.addEdge("F","B");
        G.addEdge("F","E");
        G.addEdge("F","H");
        G.addEdge("G","H");
        G.addEdge("H","B");

        G.printGraph();
        G.DFS();
    }
}
