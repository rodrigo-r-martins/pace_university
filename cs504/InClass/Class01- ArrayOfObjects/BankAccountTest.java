public class BankAccountTest {
	public static void main (String[] args) {
		
		BankAccount myBank = new BankAccount();
		Account joe = new Account(0, 200.0);
		
		myBank.addAccount(joe);
		myBank.addAccount(new Account(1, 300.0));
		myBank.addAccount(new Account(2, 5000.0));
		myBank.deposit(2, 500.0);
		
		double bal = myBank.getAccount(2).getBalance();
		System.out.println("Account #2 balance = " + bal);
		
	}
}