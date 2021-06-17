// Implementing Message interface and overriding its method

public class FirstMessage implements Message {

    @Override
    public String getMessage() {
        String message = "First message";
        return message;
    }
}
