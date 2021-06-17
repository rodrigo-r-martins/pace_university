import java.io.*;
import java.net.*;
//Sender

public class MyServer {
    public static void main(String[] args) {

        try {
            String message = "I am the server";
            byte[] buffer = message.getBytes();
            int port = 16790;
            InetAddress host = InetAddress.getByName("localhost");
            DatagramSocket serverSocket = new DatagramSocket();
            DatagramPacket datagram= new DatagramPacket(buffer, buffer.length, host, port);
            serverSocket.send(datagram);
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
        System.out.println("Program is terminated");
    }

}
