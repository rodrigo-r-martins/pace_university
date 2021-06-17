import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {

        try {
            int port = 4321;
            String host = "localhost";
            Socket clientSocket = new Socket(host, port);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String s = in.readLine();
            while (s != null) {
                System.out.println(s);
                s = in.readLine();
            }
            in.close();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
    }
}