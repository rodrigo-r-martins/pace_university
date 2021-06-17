import java.net.*;

public class Receiver{
    public static void main(String[] args){
        try{
            InetAddress group = InetAddress.getByName("239.1.2.3");
            MulticastSocket s = new MulticastSocket(3456);
            System.out.println("Joined group at 239.1.2.3 port 3456");
            s.joinGroup(group);
            byte[] buf = new byte[100];
            DatagramPacket recv = new DatagramPacket(buf, buf.length);
            s.receive(recv);
            System.out.println(new String(buf));
            s.close();
        }
        catch (Exception ex){
            ex.printStackTrace( );
        }
    }
}
