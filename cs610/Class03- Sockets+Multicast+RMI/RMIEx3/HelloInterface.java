import java.rmi.*;

public interface HelloInterface extends Remote {

    public int[] addArr(int[] arr1, int[] arr2) throws RemoteException;
}
