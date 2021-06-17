public class Node {

    public String name;
    public Node next;

    Node() {
        name = null;
        next = null;
    }

    Node(String name) {
        this.name = name;
        next = null;
    }

    @Override
    public String toString() {
        return name;
    }
}
