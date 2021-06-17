import java.util.Arrays;

public class ArrayTest {
	
	// METHODS

	static double calcAvg (int[] myValue) {
		int sum = 0;
		for (int i=0; i<myValue.length; i++) {
			sum += myValue[i];
		}
		double avg = sum / myValue.length;
		return avg;
	}

	static int lowestValue (int[] myValue) {
		int low = myValue[0];
		for (int i=0; i<myValue.length; i++) {
			if (low > myValue[i]) {
				low = myValue[i];
			}
		}
		return low;
	}


	public static void main (String[] args) {
		
		// EXAMPLE 1 (Check grades inside array)
		System.out.println("EXAMPLE 1:");

		int[] grade = {90, 80, 70, 60, 50};
		if (grade[2] >= 70) 
			System.out.println("pass");
		

		// EXAMPLE 2 (Print balance of accounts referenced to Obj Account)
		System.out.println("\nEXAMPLE 2:");

		Account[] bank = new Account[3];
		bank[0] = new Account(100);		
		bank[1] = new Account(200);
		bank[2] = new Account(300);

		for (int i=0; i<bank.length; i++) {
			System.out.println(bank[i].getBalance());
		}

		
		// EXAMPLE 3 (Print average of values in the array)
		System.out.println("\nEXAMPLE 3:");

		int[] value = {90, 70, 60, 50, 30};
		int sum = 0;
	
		for (int i=0; i<value.length; i++) {
			sum += value[i];
		}
		System.out.println("sum of values=" + sum);
		
		double avg = sum / value.length;
		System.out.println("out of method, avg=" + avg);


		// EXAMPLE 4 (Using method calcAvg)
		System.out.println("\nEXAMPLE 4:");

		double myAvg = calcAvg(value);
		System.out.println("in method, avg=" + myAvg);


		// EXAMPLE 5 (Using method lowestValue)
		System.out.println("\nEXAMPLE 5:");

		int[] newValue = {70, 60, 50, 5, 90, 10};
		int lowestValue = lowestValue(newValue);
		System.out.println("lowestValue=" + lowestValue);

		
		// EXAMPLE 6 (Copying an array)
		System.out.println("\nEXAMPLE 6:");

		int[] valueCopy = new int[value.length];
		for (int i=0; i<value.length; i++) {
			valueCopy[i] = value[i];
			System.out.println("valueCopy[" + i + "]=" + valueCopy[i]);
		}

		
		// EXAMPLE 7 (Copying an Array with API Arrays)
		System.out.println("\nEXAMPLE 7:");

		valueCopy = Arrays.copyOf(value, value.length);
		for (int i=0; i<valueCopy.length; i++) {
			System.out.println("valueCopy[" + i + "]=" + valueCopy[i]);
		}
	}
}
