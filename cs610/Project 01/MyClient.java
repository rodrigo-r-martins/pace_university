import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;

public class MyClient {
    public static void main(String[] args) {
        Socket clientSocket1 = null;
        Socket clientSocket2 = null;
        BufferedReader in1 = null;
        BufferedReader in2 = null;

        // Create two threads t1 and t2
        Thread t1 = new Thread();
        Thread t2 = new Thread();

        // Pass two different port numbers (like 16790 and 16791)
        int port1 = 16790;
        int port2 = 16791;

        // Start t1 and t2
        t1.start();
        t2.start();

        try {

            t1.join();
            t2.join();
            String host = "localhost";
            clientSocket1 = new Socket(host, port1);
            clientSocket2 = new Socket(host, port2);
            in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
            in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));

            // Once the execution of the threads t1 and t2 over, call method getString for t1 and t2 to get the strings coming from the server program
            String stringT1 = in1.readLine();
            String stringT2 = in2.readLine();

            while (stringT1 == null && stringT2 == null) {
                stringT1 = in1.readLine();
                stringT2 = in2.readLine();
            }

            // Connect the two strings separated by a space to make a new string (like: s)
            String str = stringT1 + " " + stringT2;

            // Create an object of the type java class StringTokenizer and pass the new string to its constructor
            StringTokenizer tok = new StringTokenizer(str);

            // Define an ArrayList (with no size). I named it: list.
            ArrayList<Integer> list = new ArrayList<>();

            // Using methods hasMoreTokens and nextToken of the class StringTokenizer to extract each integer
            while (tok.hasMoreTokens()) {
                String s = tok.nextToken();
                int num = Integer.parseInt(s);  // Use Integer.parsInt to convert string to a number
                list.add(num);                  // Add these numbers to the ArrayList
            }

            // Use the class Collectors to sort the list
            Collections.sort(list);

            // Display all the numbers
            for (int i : list) {
                System.out.println(i + " ");
            }

            // Close all sockets
            in1.close();
            in2.close();
            clientSocket1.close();
            clientSocket2.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
    }
}