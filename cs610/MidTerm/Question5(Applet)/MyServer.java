import java.net.*;
import java.io.*;
import java.util.*;

public class MyServer {
    public static void main(String args[]) throws Exception {

        Scanner keyboard = new Scanner(System.in);
        ServerSocket sersock = new ServerSocket(7000);
        System.out.println("Server is ready");
    
        System.out.print("Enter blue or green for a color:");
        String c = keyboard.nextLine();
    
        System.out.print("Enter a message: ");
        String s = keyboard.nextLine();
    
        Socket sock = sersock.accept( );

        DataOutputStream ostream = new DataOutputStream(sock.getOutputStream());
        ostream.writeUTF(c);
        ostream.writeUTF(s);

        sersock.close();
	    sock.close();
	    keyboard.close();
    }
}




