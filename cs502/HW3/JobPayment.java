import java.util.Scanner;

public class JobPayment {

/* Program calculate what is the better choice to get paid: straight wage per hour, or small wage for the first hour, but it doubles each hour */ 

   static void showMenu() {
      System.out.println("\n*********************************************************");
      System.out.println("\t\t\tMenu");
      System.out.println("*********************************************************");
      System.out.println("1)\tCalculate earnings at $10.00/hr");
      System.out.println("2)\tCalculate earnings at $.10 doubled each hour");
      System.out.println("3)\tExit");
      System.out.println("*********************************************************\n");
   }

   public static void main (String[] args) {

      Scanner scan = new Scanner (System.in);
      int userOption = 0;
      int inputHour = 0;

      showMenu();

      while (userOption != 3) {
         int straightWage = 10;
         double currentWage = 0.10;
         double finalWage = 0;

         /* Asking an option for user */
         System.out.print("Choose an option: ");
         userOption = scan.nextInt();
	 
	 /* Evaluating userOption */
         if (userOption < 1 || userOption > 3)
	    System.out.println("Invalid option. Please try again");
         
         /* Asking worked hours for user */
         if (userOption == 1 || userOption == 2) {
            System.out.print("How many hours? ");
            inputHour = scan.nextInt();
         }

	 /* Evaluating option 1 */
  	 if (userOption == 1) {
	    straightWage *= inputHour;
   	    System.out.printf("You will earn $%.2f\n", (double)straightWage);	
	 }
	
  	 /* Evaluating option 2 */	
  	 if (userOption == 2) {
	    for (int i=1; i<=inputHour; i++) {
	       finalWage += currentWage;
	       currentWage *= 2;
   	    }
 	    System.out.printf("You will earn $%.2f\n", finalWage);
         }
      }			
   }
}