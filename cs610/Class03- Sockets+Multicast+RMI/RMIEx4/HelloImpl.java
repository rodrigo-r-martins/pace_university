import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {

    public HelloImpl() throws RemoteException {
        super( );
    }

    public File read() throws RemoteException {
        File file = new File("test.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String str, s="";
            while ((str = br.readLine()) != null) {
                s += str + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}

