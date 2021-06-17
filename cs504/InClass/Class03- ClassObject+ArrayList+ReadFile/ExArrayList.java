import java.util.ArrayList;

public class ExArrayList {
    public static void main(String[] args) {

        // ArrayList OBJECT
        ArrayList<String> names = new ArrayList<>();
        names.add("bob");
        names.add("don");
        names.add("bill");
        names.add("sue");
        System.out.println(names.size());   // 4

        names.add(1, "cal");

        for (int i=0; i<names.size(); i++) {
            System.out.println("name in " + i + " is " + names.get(i));
        }
    }
}
