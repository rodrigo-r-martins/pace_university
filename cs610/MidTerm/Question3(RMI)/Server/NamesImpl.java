import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class NamesImpl extends UnicastRemoteObject implements NamesInterface {
	
	private ArrayList<Names> listNames = new ArrayList<Names>();
	int index = 0;

	public NamesImpl() throws RemoteException {
		super( );
	}  
  
	public String addName(String firstName, String lastName) {
		String message = "";
		boolean found = false;

		if (listNames.size() == 0) {
			listNames.add(new Names());
			listNames.get(index).setFirstName(firstName);
			listNames.get(index).setLastName(lastName);
			index++;
			message = "I included your name in the list";
		} else {
			for (int i = 0; i < listNames.size() && !found; i++) {
				for (int j = 0; j < listNames.size(); j++) {
					// Loop through all names in the list
					if (listNames.get(j).getFirstName().equalsIgnoreCase(firstName) && listNames.get(j).getLastName().equalsIgnoreCase(lastName)) {
						// If it is already in the list, do not add name to the list
						message = "Your name is already in the list";
						found = true;
						break;
					}
				}

				if (!found) {
					// If the name is not in the list then set the name
					listNames.add(new Names());
					listNames.get(index).setFirstName(firstName);
					listNames.get(index).setLastName(lastName);
					index++;
					message = "I included your name in the list";
					break;
				}
			}
		}
		return message;
	}
  
	public String removeName(String firstName, String lastName) {
		String message = "";
		
		for (int i=0; i<listNames.size(); i++) {
			if ((listNames.get(i).getFirstName().equalsIgnoreCase(firstName)) && (listNames.get(i).getLastName().equalsIgnoreCase(lastName))) {
				// If the name is in the list then remove it
				listNames.remove(i);
				message = "Your name was removed from the list";
				index--;
				break;
			} else {
				// If the name is not in the list return a message
				message = "No such name in the list";			
			}
		}
		return message;
	}
  
	public String listNames(String lastName) {
		String message = "";
		ArrayList<String> names = new ArrayList<String>();
		
		for (int i=0; i<listNames.size(); i++) {
			if (listNames.get(i).getLastName().equalsIgnoreCase(lastName)) {
				// If the last name is in the list then check
				names.add(listNames.get(i).getFirstName() + " " + listNames.get(i).getLastName());
			} 
		}
		
		if (names.size() == 0) {
			// If the last name is not in the list return a message
			message = "There is no one with this name in the list";
		} else {
			for (int i=0; i<names.size(); i++) {
				message += names.get(i) + "\n";
			}
		}
		return message;
	}
	
	/*
    // === Method used for testing! ===

    public String[] getListNames() {
        String[] listOfNames = new String[listNames.size()];
        for (int x=0; x<listNames.size(); x++) {
            listOfNames[x] = listNames.get(x).getFirstName() + " " + listNames.get(x).getLastName();
        }
        return listOfNames;
    }
    */
}
