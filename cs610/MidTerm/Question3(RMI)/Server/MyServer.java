import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.net.*;

public class MyServer {
	//This class is complete. Do not change it.
	public static void main(String args[]) throws RemoteException, MalformedURLException{
		
		try {
			NamesImpl exportedObj = new NamesImpl();
			LocateRegistry.createRegistry(1234);
			String registryURL = "rmi://localhost:1234/names";
			Naming.rebind(registryURL, exportedObj);
			System.out.println("Names Server ready.");			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
