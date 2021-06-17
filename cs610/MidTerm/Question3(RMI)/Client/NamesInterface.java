import java.rmi.Remote;
import java.rmi.RemoteException;
//This interface is complete. Do not change it.
public interface NamesInterface extends Remote {
	
	public String addName(String firstName, String lastName) throws RemoteException;
	/* Method: addName
	 * To add a first name and last name to the list of names.
	 * If the name is not in the list add it and inform the client:
	 * I included the name.
	 * If the name is in the list inform the client:
	 * Your name is already in the list.
	 */
  
	public String removeName(String firstName, String lastName) throws RemoteException;
	/* Method: removeName
	 * To remove a first name and last name from the list of names.
	 * If the name is not in the list add it and inform the client:
	 * No such name in the list.
	 * If the name is in the list remove it and inform the client:
	 * Your name is removed from the list.
	 */

	public String listNames(String lastName) throws RemoteException;
	/* Method: listNames
	 * To list all the names that their last names are the same.
	 * If the name is not in the list inform the client:
	 * There no one with this last name in the list.
	 * If the name is in the list send the client: the list of all the
	 * names (first name and last name) of people with this name
	 */
	
	// public String[] getListNames() throws RemoteException;
}
