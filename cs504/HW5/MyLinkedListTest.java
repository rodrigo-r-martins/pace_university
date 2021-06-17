public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList myList = new MyLinkedList();

        // Adding new Nodes
        myList.addNode(new Node("Bill"));
        myList.addNode(new Node("John"));
        myList.addNode(new Node("Sue"));

        // Printing list
        System.out.println("Printing list:");
        myList.printList();

        // Inserting Node after given index position
        System.out.println("\nAfter insertAfter method:");
        myList.insertAfter(0, new Node("Larry"));
        myList.insertAfter(2, new Node("Bob"));
        myList.printList();

        // Inserting Node before given index position
        System.out.println("\nAfter insertBefore method:");
        myList.insertBefore(0, new Node("Joe"));
        myList.insertBefore(5, new Node("Paul"));
        myList.printList();

        // Removing Node at given index position
        System.out.println("\nAfter removeNodeAt method:");
        myList.removeNodeAt(5);
        myList.removeNodeAt(0);
        myList.printList();

        // Getting position in the list of given value
        // It returns -1 if String str is not in LinkedList
        System.out.println("\nPrinting index positions of given values:");
        System.out.println(myList.indexOf("Bill"));
        System.out.println(myList.indexOf("Larry"));
        System.out.println(myList.indexOf("Joe"));
        System.out.println(myList.indexOf("Bob"));
    }
}
