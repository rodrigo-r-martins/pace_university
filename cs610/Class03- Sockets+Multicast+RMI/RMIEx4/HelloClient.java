import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.*;

public class HelloClient {
    public static void main(String args[]) {

        try {
            int port = 16790;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/hello";
            HelloInterface h = (HelloInterface)Naming.lookup(registryURL);
            System.out.println("Lookup completed " );
            File file = h.read();
            BufferedReader br = new BufferedReader((new FileReader(file)));
            String str;
            while ((str = br.readLine()) != null) {
                str = br.readLine();
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

