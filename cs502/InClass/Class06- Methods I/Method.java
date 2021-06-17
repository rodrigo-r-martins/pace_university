public class Method {

	static void printHello() {
		System.out.println("Hello World in method printHello()");	
	}

	static int absolute(int num) {
		int returnValue;
		if (num < 0) 
			returnValue = num * -1;
		else
			returnValue = num;
		return returnValue;
	}

	static int highestValue(int num1, int num2) {
		int highest;
		if (num1 > num2) 
			highest = num1;
		else
			highest = num2;
		return highest;
	}

	static boolean isEven (int num) {
		if (num % 2 == 0)
			return true;
		else
			return false;
	}

	public static void main (String[] args) {
		printHello();
		printHello();
		
		int value;
		value = absolute(-30);				// Math.abs(value);
		System.out.println("absolute=" + value);
		System.out.println("absolute=" + absolute(-20));

		int highest;
		highest = highestValue(5, 2);			// Math.max(5, 2);
		System.out.println("highestNumber=" + highest);
		System.out.println("highestNumber=" + highestValue(3, 4));

		System.out.println(isEven(3));
		System.out.println(isEven(2));
	}
}