import java.net.*;
public class Sender {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("239.1.2.3");
            MulticastSocket s = new MulticastSocket(3456);
            s.setTimeToLive(32);
            String msg = "Hello All.";
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 3456);
            s.send(packet);
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}