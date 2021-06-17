import java.io.*;
import java.net.*;
import java.util.*;

public class MyServer {
    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        try {
            int port = 4321;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String message = "";
            do{
                System.out.print("Enter a line or end to quit: ");
                message = keyboard.nextLine();
                out.println(message);
            }while(!message.equalsIgnoreCase("end"));
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
