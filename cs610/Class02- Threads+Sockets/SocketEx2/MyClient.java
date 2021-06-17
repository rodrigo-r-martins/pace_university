import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) {
        Socket clientSocket = null;
        BufferedReader in = null;
        int ip;

        try {
            ip = 16790;
            String host = "localhost"; //("vulcan.seidenberg.pace.edu");
            clientSocket = new Socket(host, ip);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String s = in.readLine();
            while(s == null)	//As long as there is nothing in the stream keep reading
                s = in.readLine();
            System.out.println(s);
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
    }
}

