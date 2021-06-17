import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {

    public HelloImpl() throws RemoteException {
        super( );
    }

    public double add(double n1, double n2) throws RemoteException {
        return n1+n2;
    }
}
