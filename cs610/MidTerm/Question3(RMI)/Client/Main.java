import java.util.*;
import java.net.MalformedURLException;
import java.rmi.*;

public class Main {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		String registryURL = "rmi://localhost:1234/names";
		NamesInterface run = (NamesInterface)Naming.lookup(registryURL);
		Scanner keyboard = new Scanner(System.in);
		int code;
		String firstName;
		String lastName;

		while (true) {
			//Complete this while-loop
			
			System.out.print("1) Add a name"
					+ "\n2) Remove a name"
					+ "\n3) List names"
					+ "\n4) Terminate"
					+ "\n===> Option: ");
			code = keyboard.nextInt();
			
			switch (code) {
				case 1:
					System.out.print("Enter your first name: ");
					firstName = keyboard.next();
					System.out.print("Enter your last name: ");
					lastName = keyboard.next();
					System.out.println(run.addName(firstName, lastName));
					break;
				case 2:
					System.out.print("Enter your first name: ");
					firstName = keyboard.next();
					System.out.print("Enter your last name: ");
					lastName = keyboard.next();
					System.out.println(run.removeName(firstName, lastName));
					break;
				case 3:
					System.out.print("Enter your last name: ");
					lastName = keyboard.next();
					System.out.println(run.listNames(lastName));
					break;
				case 4:
					System.out.println("Terminating program.");
                    break;
				/*
				 * === Just used for testing ===
				case 5:
					String[] listOfNames = run.getListNames();
					for (int x=0; x<listOfNames.length; x++) {
			            System.out.println(listOfNames[x]);
			        }
					break;
				*/
				default:
					System.out.println("Wrong number. Try again.");
                    break;
			}
			
			if (code == 4) {
				break;
			}
		}
	}
}
