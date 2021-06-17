import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CollectionExMap {
    public static void main(String[] args) {

        // CHECKING HashMap
        Map<String, String> hmGrade = new HashMap<>();

        hmGrade.put("Bill", "A");
        hmGrade.put("Jill", "B");
        hmGrade.put("Bob", "B");
        hmGrade.put("Sue", "A");
        hmGrade.put("Bill", "C");     // It can't duplicate, but value it overwritten

        // It's printed randomly because it's a HashMap
        System.out.println("HashMap of grades:");
        Iterator it = hmGrade.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry)it.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println("key=" + key + " value=" + value);
        }


        // CHECKING TreeMap
        Map<String, String> tmGrade = new TreeMap<>();

        tmGrade.put("Bill", "A");
        tmGrade.put("Jill", "B");
        tmGrade.put("Bob", "B");
        tmGrade.put("Sue", "A");
        tmGrade.put("Bill", "C");     // It can't duplicate, but value it overwritten

        // It's printed in order because it's a TreeMap
        System.out.println("\nTreeMap of grades:");
        Iterator it1 = tmGrade.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry)it1.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println("key=" + key + " value=" + value);
        }


        System.out.println("\nChecking value of Bill key:");
        if (tmGrade.containsKey("Bill")) {
            String s = tmGrade.get("Bill");       // Getting value of key
            System.out.println("Bill value=" + s);
        }
    }
}
