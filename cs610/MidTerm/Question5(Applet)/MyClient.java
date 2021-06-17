import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;

public class MyClient extends Applet {
    //Complete this class
	String c ="";
	String s ="";

	public void init() {
	    setSize(400, 400);
	  
        try {
            Socket sock = new Socket("localhost", 7000);

            DataInputStream instream = new DataInputStream(sock.getInputStream());

            c = instream.readUTF();
            s = instream.readUTF();

            sock.close();
        //  repaint();

        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }

        if (c.equalsIgnoreCase("green")) {
            setBackground(Color.GREEN);
        }
        if (c.equalsIgnoreCase("blue")) {
            setBackground(Color.BLUE);
        }
    }

    public void paint(Graphics g) {
	    int x, y;

	    Dimension d = getSize();
	    FontMetrics fm = g.getFontMetrics();
	    y = d.height/2 - fm.getHeight();
	    g.drawString(s, 20, y);
	}
}

 







