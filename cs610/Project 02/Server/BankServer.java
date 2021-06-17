import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class BankServer {
    public static void main(String args[]) throws RemoteException {

        try {
            int port = 16790;
            String host = "localhost";
            BankAccount exportedObj = new BankAccount();
            LocateRegistry.createRegistry(port);
            String registryURL = "rmi://" + host + ":" + port + "/bank";
            Naming.rebind(registryURL, exportedObj);
            System.out.println("Bank Server ready.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


