public class BankAccount {

	private Account[] acct;

	BankAccount() {
		acct = new Account[5];
	}

	BankAccount(int len) {
		acct = new Account[len];		
	}

	public void setAccts (Account[] a) {
		acct = a;
	}

	public void deposit(int acctId, double amt) {
		for (int i=0; i<acct.length && acct[i] != null; i++) {
			if (acct[i].getId() == acctId) {
				acct[i].deposit(amt);
			}
		}
	}

	public Account getAccount(int acctId) {
		Account a = null;
		boolean found = false;
		for (int i=0; i<acct.length && !found; i++) {
			if (acct[i].getId() == acctId) {
				a = acct[i];
				found = true;
			}
		}
		return a;
	}

	public void addAccount(Account a) {
		boolean added = false;
		for (int i=0; i<acct.length && added == false; i++) {
			if (acct[i] == null) {
				acct[i] = a;
				added = true;
			}
		}
	}
}