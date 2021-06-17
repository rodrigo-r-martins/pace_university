public class BankTest {
	public static void main(String[] args) {
		Account joe = new Account (100);
		Bank myBank = new Bank (1, joe);
		
		Account auditor = myBank.getAccount();
		double bankBal = auditor.getBalance();
		
		/*
		Last two lines could be written in just one line:
		double bankBal = myBank.getAccount().getBalance();
		*/
		
		System.out.println(auditor);
		System.out.println(bankBal);


	}
}