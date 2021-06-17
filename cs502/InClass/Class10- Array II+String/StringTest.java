public class StringTest {

	public static void main (String[] args) {
		
		// EXAMPLE 1 (Compare two Strings with API String)
		System.out.println("EXAMPLE 1:");

		String joe = "joe";
		String jill = "jill";
		if (joe.equals(jill))
			System.out.println("joe = jill");
		else
			System.out.println("joe != jill");

		
		// EXAMPLE 2 (Converting String "25" to Integer 25)
		System.out.println("\nEXAMPLE 2:");

		int n1 = Integer.parseInt("25");
		int n2 = Integer.parseInt("30");
		int plus = n1+n2;
		System.out.println(plus);

	
		// EXAMPLE 3 (Checking if there's number in the String)
		System.out.println("\nEXAMPLE 3:");

		String course = "CS502";
		if (course.charAt(2) >= '0' && course.charAt(2) <= '9')
			System.out.println("It's a number");

	
		// EXAMPLE 4 (Print name before @ symbol from a char array)
		System.out.println("\nEXAMPLE 4:");

		char[] email = {'j', 'c', 'h', 'i', 'n', '@', 'p', 'a', 'c', 'e', '.', 'e', 'd', 'u'};
		String str = String.valueOf(email);
		int pos = str.indexOf('@');
		String name = str.substring(0, pos);
		System.out.println(name);
				
	}	
}

