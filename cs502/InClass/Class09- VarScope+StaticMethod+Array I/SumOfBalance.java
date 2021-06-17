public class SumOfBalance {
	public static void main(String[] args) {
		Account[] bank = new Account[5];
		bank[0] = new Account(100);
		bank[1] = new Account(200);
		bank[2] = new Account(300);
		bank[3] = new Account(400);
		bank[4] = new Account(500);

		int sum = 0;
		for (int i=0; i<bank.length; i++) {
			sum += bank[i].getBalance(); 
		}
		System.out.println(sum);
	}
}

