public class Bank {
	private int id;
	private Account myAccount;

	Bank () {
	}

	Bank (int myId, Account a) {
		id = myId;
		myAccount = a;
	}
	
	public void setId (int myId) {
		id = myId;
	}
	
	public int getId() {
		return id;
	}

	public void setAccount (Account a) {
		myAccount = a;
	}

	public Account getAccount() {
		return myAccount;
	}
}