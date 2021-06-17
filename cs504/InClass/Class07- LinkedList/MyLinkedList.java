public class MyLinkedList {
    private Node head;

    MyLinkedList() {
        head = null;
    }

    public void add(Node n) {
        Node trav = head;

        if (head == null) {
            head = n;
        } else {
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = n;
        }
    }

    public void add(int index, Node n) {
        Node trav = head;
        int count = 0;

        if (index == 0) {
            n.next = head;
            head = n;
        } else {
            while (count < index - 1) {
                trav = trav.next;
                count++;
            }
            n.next = trav.next;
            trav.next = n;
        }
    }

    public void printList() {
        Node trav = head;

        while (trav != null) {
            System.out.println("name=" + trav.name);
            trav = trav.next;
        }
    }


}
