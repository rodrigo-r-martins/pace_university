import java.rmi.*;
public interface HelloInterface extends Remote {
    public int[] bubbleSort(int[] a) throws RemoteException;
}
