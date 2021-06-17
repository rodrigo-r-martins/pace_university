import java.io.File;
import java.util.*;

public class StudentData {
    public static void main(String[] args) throws Exception {

        File file = new File("student.txt");
        Scanner scan = new Scanner(file);

        Map<String, TreeSet<String>> mp = new TreeMap<>();
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] splitStr = str.split("\t");

            String key = splitStr[0];
            String value = splitStr[1];

            TreeSet<String> ts;

            if (mp.containsKey(key)) {
                // key in Map
                ts = mp.get(key);
                ts.add(value);
            } else {
                // key not in Map
                ts = new TreeSet<>();
                ts.add(value);
            }
            mp.put(key, ts);
        }

            // Two ways of iterating: loop and Iterator
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TreeSet<String>> pair = (Map.Entry)it.next();
            String k = pair.getKey();
            TreeSet<String> t = pair.getValue();

            System.out.println("key=" + k);
            // System.out.println("   value=" + t);     // Printing with toString overridden method

            for (String s : t) {
                System.out.println("   value=" + s);
            }
        }
    }
}
