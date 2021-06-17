public class LinkDataListTest {
    public static void main(String[] args) {

        LinkDataList numList = new LinkDataList();
        numList.add(new LinkData("Bob"));
        numList.add(new LinkData("Paul"));
        numList.add(new LinkData("John"));
        numList.add(new LinkData("Bill"));
        System.out.println("LinkList:");
        numList.printList();

        System.out.println("\nAfter addAt:");
        numList.addAt(1, new LinkData("Sue"));
        numList.printList();

        System.out.println("\nList length = " + numList.length());

        System.out.println("\nAfter removeFirst:");
        numList.removeFirst();
        numList.printList();



    }
}
