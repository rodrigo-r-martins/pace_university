import java.util.*;

public class CollectionExSet {
    public static void main(String[] args) {

        // CHECKING HashSet
        Set<String> hsCourse = new HashSet<>();
        hsCourse.add("cs502");
        hsCourse.add("cs506");
        hsCourse.add("cs504");
        hsCourse.add("cs610");
        hsCourse.add("cs623");
        // hsCourse.add("cs623");     // Duplicated values aren't printed
        // hsCourse.add("cs504");     // Set doesn't allow duplicated values

        // It's gonna print randomly because it's a HashSet
        System.out.println("HashSet list of courses:");
        for (String setNames : hsCourse) {
            System.out.println(setNames);
        }


        // CHECKING LinkedHashSet
        Set<String> lhsCourse = new LinkedHashSet<>();
        lhsCourse.add("cs502");
        lhsCourse.add("cs506");
        lhsCourse.add("cs504");
        lhsCourse.add("cs610");
        lhsCourse.add("cs623");

        System.out.println("\nLinkedHashSet list of courses:");
        // It's gonna print maintaining the natural order because it's a LinkedHashSet
        for (String setNames : lhsCourse) {
            System.out.println(setNames);
        }


        // CHECKING TreeSet
        Set<String> tsCourse = new TreeSet<>();
        tsCourse.add("cs502");
        tsCourse.add("cs506");
        tsCourse.add("cs504");
        tsCourse.add("cs610");
        tsCourse.add("cs623");

        // It's gonna print in order because it's a TreeSet
        // I'm using another way of iterates of values of a Collection in this TreeSet
        System.out.println("\nTreeSet list of courses:");
        Iterator it = tsCourse.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
