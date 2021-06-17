import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        URL x = new URL("http://vulcan.seidenberg.pace.edu/~mbadii/a.php");

        //URL x = new URL("http://vulcan.seidenberg.pace.edu/index.php?title=Main_page&action=raw");
        System.out.println("Protocol: " + x.getProtocol());
        System.out.println("Authority: " + x.getAuthority());
        System.out.println("Host name: " + x.getHost());
        System.out.println("Port number: " + x.getPort());
        System.out.println("Path: " + x.getPath());
        System.out.println("Query: " + x.getQuery());
        System.out.println("File: " + x.getFile());
    }
}
