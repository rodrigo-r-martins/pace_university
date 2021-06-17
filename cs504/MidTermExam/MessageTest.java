// Testing interface and classes that implement it, and also their overriding methods

public class MessageTest {
    public static void main(String[] args) {
        Message firstMessage = new FirstMessage();
        Message secondMessage = new SecondMessage();

        System.out.println(firstMessage.getMessage());
        System.out.println(secondMessage.getMessage());
    }
}
