import java.rmi.*;

public class HelloClient {
    public static void main(String args[]) {
        int a[] = {3, 4, 2, 1, 5, 7, 4, 8, 10};
        try {
            int port = 16790;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/hello";
            HelloInterface h = (HelloInterface) Naming.lookup(registryURL);
            System.out.println("Lookup completed ");
            int[] message = h.bubbleSort(a);
            for (int i = 0; i < a.length; i++)
                System.out.print(message[i] + ", ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
