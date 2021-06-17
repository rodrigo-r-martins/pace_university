import java.util.*;

public class CollectionExList {
    public static void main(String[] args) {

        // CHECKING ARRAYLIST
        List<String> alNames = new ArrayList<>();
        alNames.add("Bill");
        alNames.add("Sue");
        alNames.add("Jill");
        alNames.add("Larry");

        System.out.println("ArrayList names:");
        for (String listNames : alNames) {        // Enhanced for loop
            System.out.println("name=" + listNames);
        }

        Collections.sort(alNames);
        System.out.println("\nAfter sort:");
        for (String listNames : alNames) {
            System.out.println("name=" + listNames);
        }

        Collections.shuffle(alNames);
        System.out.println("\nAfter shuffle:");
        for (String listNames : alNames) {
            System.out.println("name=" + listNames);
        }

        Collections.reverse(alNames);
        System.out.println("\nAfter reverse:");
        for (String listNames : alNames) {
            System.out.println("name=" + listNames);
        }

        // ITERATOR to get values. It's another way to iterate over a collection
        System.out.println("\nUsing iterator to print:");
        Iterator it = alNames.iterator();
        while (it.hasNext()) {
            System.out.println("iterator name=" + it.next());
        }


        // CHECKING LINKEDLIST
        List<String> llNames = new LinkedList<>();
        llNames.add("Rod");
        llNames.add("Dan");
        llNames.add("Carol");
        llNames.add("Phill");

        System.out.println("\nLinkedList names:");
        for (String listNames : llNames) {        // Enhanced for loop
            System.out.println("name=" + listNames);
        }

        Collections.sort(llNames);
        System.out.println("\nAfter sort:");
        for (String listNames : llNames) {
            System.out.println("name=" + listNames);
        }

        Collections.shuffle(llNames);
        System.out.println("\nAfter shuffle:");
        for (String listNames : llNames) {
            System.out.println("name=" + listNames);
        }

        Collections.reverse(llNames);
        System.out.println("\nAfter reverse:");
        for (String listNames : llNames) {
            System.out.println("name=" + listNames);
        }
    }
}
