import java.util.Stack;

public class CollectionExStack {
    public static void main(String[] args) {

        Stack<String> st = new Stack<>();
        st.push("one");
        st.push("two");
        st.push("three");

        while (!st.empty()) {       // while is not empty
            String str = st.pop();
            System.out.println(str);
        }
    }
}
