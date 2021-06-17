import java.rmi.*;

public class HelloClient {
    public static void main(String args[]) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {11, 12, 13, 14, 15, 16, 17, 18, 19};

        try {
            int port = 16790;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/hello";
            HelloInterface h = (HelloInterface)Naming.lookup(registryURL);
            System.out.println("Lookup completed " );
            int[] message = h.addArr(arr1, arr2);
            for (int i=0; i<message.length; i++) {
                System.out.print(message[i] + ", ");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

