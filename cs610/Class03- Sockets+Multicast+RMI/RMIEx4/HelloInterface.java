import java.io.File;
import java.rmi.*;

public interface HelloInterface extends Remote {

    public File read() throws RemoteException;
}
