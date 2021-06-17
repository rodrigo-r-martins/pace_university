public class MyLinkedList {

    private Node head;

    MyLinkedList() {
        head = null;
    }

    public void addNode(Node n) {
        // add a Node to end of the LinkedList
        Node current = head;

        if (head == null) {
            head = n;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }

    public void printList() {
        // print each element in the LinkedList
        Node current = head;

        while (current != null) {
            System.out.println("name=" + current.name);
            current = current.next;
        }
    }

    public void insertBefore(int index, Node n) {
        // adds Node n before index value
        Node current = head;
        int pos = 0;

        if (index == 0) {
            n.next = head;
            head = n;
        } else {
            while (pos < index-1) {
                current = current.next;
                pos++;
            }
            n.next = current.next;
            current.next = n;
        }
    }

    public void insertAfter(int index, Node n) {
        // adds Node n after index value
        Node current = head;
        int pos = 0;

        while (pos < index) {
            current = current.next;
            pos++;
        }
        n.next = current.next;
        current.next = n;
    }

    public int indexOf(String str) {
        // returns index of where String str is at.
        // returns -1 if String str is not in LinkedList
        Node current = head;
        int pos = 0;

        while (current != null) {
            if (current.name.equals(str)) {
                return pos;
            }
            current = current.next;
            pos++;
        }
        return -1;
    }

    public void removeNodeAt(int index) {
        // removes Node at index value
        Node current = head;
        Node temp = head;
        int posCurrent = 0;
        int posTemp = 0;

        if (index == 0) {
            head = current.next;
            current.next = null;
        } else {
            while (posCurrent < index) {
                current = current.next;
                posCurrent++;
            }

            while (posTemp < index-1) {
                temp = temp.next;
                posTemp++;
            }

            temp.next = current.next;
            current.next = null;
        }
    }
}
