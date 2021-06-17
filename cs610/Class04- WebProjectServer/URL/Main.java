import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a URL: ");

        try {
            String name = keyboard.nextLine();
            URL u = new URL(name);
            System.out.println("The protocol is " + u.getProtocol());
            System.out.println("The host is " + u.getHost());
            System.out.println("The port is " + u.getPort());
            System.out.println("The file is " + u.getFile());

        } catch (MalformedURLException e) {
            System.out.println("Error: " + e);
        }
    }
}
