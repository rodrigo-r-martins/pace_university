import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;

public class MyServer {

    // Define a method named: makeTheString that returns a string
    private static String makeTheString() {

        // In this method generate a number for: n and generate n integers
        Random random = new Random();
        int size = random.nextInt(20);
        ArrayList<Integer> al = new ArrayList<>(size);
        String s = "";                              // Make a string of these numbers

        for (int i=0; i<size; i++) {
            al.add(random.nextInt(50));
            s = s + al.get(i) + " ";                // Every two integers must be separated by a space
        }
        return s;
    }

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket1 = new ServerSocket(16790);
            ServerSocket serverSocket2 = new ServerSocket(16791);
            Socket clientSocket1 = serverSocket1.accept();
            Socket clientSocket2 = serverSocket2.accept();
            PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
            PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);

            // Call the method makeTheString to get the string of integers and send it to the client
            out1.println(makeTheString());
            out2.println(makeTheString());

            // Close all sockets
            out1.close();
            out2.close();
            clientSocket1.close();
            clientSocket2.close();
            serverSocket1.close();
            serverSocket2.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
    }
}
