import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args) throws IOException, InterruptedException {
    
		Socket clientSocket = null;
		BufferedReader in = null;
		System.out.println("Welcome to the daytime client");

		boolean connect = false;
		
		while (!connect) {
			try {
				clientSocket = new Socket("localhost", 1234);
				
				if (clientSocket.isConnected()) {
					connect = true;
					in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					String string = in.readLine();
					System.out.println("Here is the timestamp received from the server: " + string);
				}
				

			} catch (Exception e) {
					System.out.println("Waiting for server");
				try {
					Thread.sleep(5000);
				} catch (Exception e1) {
					e1.getMessage();
				}

			}
		}
		in.close();
		clientSocket.close();      
		System.out.println("The program terminated with no error and no exception");
	}
}

