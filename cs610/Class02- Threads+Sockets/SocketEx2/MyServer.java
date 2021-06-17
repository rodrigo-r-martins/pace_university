import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(16790);
            Socket clientSocket = null;
            clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("I am the server");
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
    }
}