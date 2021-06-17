public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList myList = new MyLinkedList();
        myList.add(new Node("Bill"));
        myList.add(new Node("John"));
        myList.add(new Node("Sue"));
        myList.add(0, new Node("Larry"));
        myList.printList();
    }
}
