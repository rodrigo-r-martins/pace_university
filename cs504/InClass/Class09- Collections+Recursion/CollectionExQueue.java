import java.util.ArrayDeque;

public class CollectionExQueue {
    public static void main(String[] args) {

        ArrayDeque<String> q = new ArrayDeque<>();
        q.add("one");
        q.add("two");
        q.add("three");

        while (!q.isEmpty()) {
            String str = q.poll();
            System.out.println(str);
        }


    }
}
