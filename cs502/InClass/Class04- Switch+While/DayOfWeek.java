public class DayOfWeek {

	public static void main(String[] args) {

/* Program shows how to use switch statement in the case of validating the day of week */

		char day = 'r';
		
		switch (day) {
			case 'm':
			case 'M':
				System.out.println("Monday");
				break;
			case 't':
			case 'T':
				System.out.println("Tuesday");
				break;
			case 'w':
			case 'W':
				System.out.println("Wednesday");
				break;
			case 'r':
			case 'R':
				System.out.println("Thursday");
				break;
			case 'f':
			case 'F':
				System.out.println("Friday");
				break;
			case 's':
			case 'S':
				System.out.println("Saturday");
				break;
			case 'u':
			case 'U':
				System.out.println("Sunday");
				break;
			default:
				System.out.println("Invalid day of week");
		}

		/* 

		if (day =='m') {
			System.out.println("Monday");
		} else if (day == 't') {
			System.out.println("Tuesday");
		} else if (day == 'w') {
			System.out.println("Wednesday");
		} else if (day == 'r') {
			System.out.println("Thursday");
		} else if (day == 'f') {
			System.out.println("Friday");
		} else if (day == 's') {
			System.out.println("Saturday");
		} else if (day == 'u') {
			System.out.println("Sunday");
		}
		*/

	}

}
