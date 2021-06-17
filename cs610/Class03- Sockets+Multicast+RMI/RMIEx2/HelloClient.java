import java.rmi.*;

public class HelloClient {
    public static void main(String args[]) {

        try {
            int port = 16790;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/hello";
            HelloInterface h = (HelloInterface)Naming.lookup(registryURL);
            System.out.println("Lookup completed " );
            double message = h.add(2.5, 3.3);
            System.out.println("Addition is: " + message);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

