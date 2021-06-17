public class Grades {
	private int[] values;

	Grades() {}

	Grades(int[] myArray) {
		values = myArray;	// referencing myArray

		/*	***If I want to make a copy of array***
		values = new int[myArray.length];
		for (int i=0; i<myArray.length; i++) {
			values[i] = myArray[i];
		}
		*/
	}

	public void setValues (int[] myArray) {
		values = myArray;	// referencing myArray

		/*	***If I want to make a copy of array***
		values = new int[myArray.length];
		for (int i=0; i<myArray.length; i++) {
			values[i] = myArray[i];
		}
		*/
	}

	public int[] getValues () {
		return values;
	}

	public int highest() {
		int high = values[0];
		for (int i=0; i<values.length; i++) {
			if (values[i] > high) {
				high = values[i];
			}
		}
		return high;
	}

	public int lowest() {
		int low = values[0];
		for (int i=0; i<values.length; i++) {
			if (values[i] < low) {
				low = values[i];
			}
		}
		return low;
	}

	public int numOfGrades() {
		int counter = 0;
		for (int i=0; i<values.length; i++) {
			counter++;
		}
		return counter;
	}

	public double average() {
		double avg = 0;
		int sum = 0;
		for (int i=0; i<values.length; i++) {
			sum += values[i];
		}
		avg = sum / (double)values.length;
		return avg;
	}

	public int numOfFailingGrades (int gradeValue) {
		int counter = 0;
		for (int i=0; i<values.length; i++) {
			if (values[i] < gradeValue) { 
				counter++;
			}
		}
		return counter;
	}

	public void histogram() {
		String star = "*";
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int f = 0;
		for (int i=0; i<values.length; i++) {	
			if (values[i] >= 90 && values[i] <= 100) {
				a++;
			} else if (values[i] >= 80) {
				b++;
			} else if (values[i] >= 70) {
				c++;
			} else if (values[i] >= 60) {
				d++;
			} else {
				f++;
			}
		}
		System.out.println("90 - 100 | " + star.repeat(a));
		System.out.println("80 - 89  | " + star.repeat(b));
		System.out.println("70 - 79  | " + star.repeat(c));
		System.out.println("60 - 69  | " + star.repeat(d));
		System.out.println("< 60     | " + star.repeat(f));
	}
}
