import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient extends Applet {
  private String s;
	
  public void init(){
    setSize(400, 100);
    try{
      Scanner keyboard = new Scanner(System.in);
      InetAddress host = InetAddress.getByName("localhost");
      Socket clientSocket = clientSocket = new Socket(host, 16790);
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      System.out.print("Enter a message to be sent to the server: ");
      String a = keyboard.nextLine();
      out.println(a);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      s = in.readLine();
    }catch(Exception e){
      System.out.println("Error: " + e);
    }
  }

  public void paint(Graphics page){
    page.drawString(s, 20, 20);
  }
}
