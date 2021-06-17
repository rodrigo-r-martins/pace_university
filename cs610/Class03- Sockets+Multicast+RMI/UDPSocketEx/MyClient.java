import java.io.*;
import java.net.*;
//Receiver
public class MyClient {
    public static void main(String[] args) {

        try {
            final int MAX_LEN = 100;
            byte[] buffer = new byte[MAX_LEN];
            int port = 16790;
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
            DatagramSocket clientSocket = new DatagramSocket(port);
            System.out.println("Before receive");
            clientSocket.receive(datagram);
            System.out.println("After receive");
            String message = new String(buffer);
            System.out.println(message);
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
    }
}
