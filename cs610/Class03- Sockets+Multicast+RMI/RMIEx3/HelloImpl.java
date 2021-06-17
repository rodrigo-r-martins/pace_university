import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {

    public HelloImpl() throws RemoteException {
        super( );
    }

    public int[] addArr(int[] arr1, int[] arr2) throws RemoteException {
        for (int i=0; i<arr1.length; i++) {
            arr1[i] += arr2[i];
        }
        return arr1;
    }
}
