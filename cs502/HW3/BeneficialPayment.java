
public class BeneficialPayment {

/* Program determine the number of worked hours required before the $0.10/hr doubled each hour (second method) becomes more beneficial than the straight $10/hr (first method) */ 

   public static void main (String[] args) {

      int hour = 1;
      int straightWage;
      double currentWage;
      double finalWage;

      do {
         straightWage = 10;
         currentWage = 0.10;
         finalWage = 0;

	 /* Method 1 */
         straightWage *= hour;
	
         /* Method 2 */
         for (int i=1; i<=hour; i++) {
	    finalWage += currentWage;
	    currentWage *= 2;
   	 }

	 /* Evaluating more beneficial method according worked hours */
         System.out.printf("Hour %d => 1st method: %.2f | 2nd method: %.2f\n", hour, (double)straightWage, finalWage);
         hour++;
      } while (straightWage > finalWage);			
   }
}