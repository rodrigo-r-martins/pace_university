import java.io.*;
import java.net.*;

public class MyServer {
  public static void main(String[] args){
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(16790);
      Socket clientSocket = null;
      clientSocket = serverSocket.accept();
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      String s = in.readLine();
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      out.println("Thank you for telling me: " + s);
      in.close();
      out.close();
      clientSocket.close();
      serverSocket.close();
    } catch (IOException e) {
        System.out.println("Error: " + e);
        System.exit(0);
    }
  }
}

