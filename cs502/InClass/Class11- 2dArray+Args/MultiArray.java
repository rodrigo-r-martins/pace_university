public class MultiArray {
	public static void main (String[] args) {
		int[][] table = 
			{ {28, 84, 47, 72},
	  		  {69, 26},
	  		  {91, 40, 28}
			};

		for (int row=0; row<table.length; row++) {
			for (int col=0; col<table[row].length;col++) {
				System.out.print(table[row][col] + " ");	
			}
			System.out.println("");
		}
	}
}