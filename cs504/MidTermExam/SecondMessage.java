// Implementing Message interface and overriding its method

public class SecondMessage implements Message {

    @Override
    public String getMessage() {
        String message = "Second message";
        return message;
    }
}
