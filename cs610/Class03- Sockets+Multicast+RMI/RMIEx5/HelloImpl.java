import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {

    public HelloImpl() throws RemoteException {
        super( );
    }

    public int[] bubbleSort(int[] a) throws RemoteException {
        for(int i = 0; i < a.length; i++) {
            int smallestIndex = i;
            for(int j = i + 1; j < a.length; j++)
                if(a[smallestIndex]> a[j])
                    smallestIndex = j;
            int temp = a[i];
            a[i] = a[smallestIndex];
            a[smallestIndex] = temp;
        }
        return a;
    }
}

