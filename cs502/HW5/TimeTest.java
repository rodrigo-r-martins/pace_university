public class TimeTest {

	public static void main(String[] args) {
		
		/* 
		Clock0
		Testing tick method and bonds of seconds
		*/
		
		Time clock0 = new Time();
		for (int i=0; i<60; i++) {
			clock0.tick();
		}
		System.out.println("Clock0= ");
		clock0.printTime();		

		/* 
		Clock1
		Using tick method to check bonds of seconds
		*/

		Time clock1 = new Time();
		clock1.setTime(20, 12, 59);
		System.out.println("\nClock1= ");
		clock1.printTime();
		for (int j=0; j<60; j++) {
			clock1.tick();
		}
		clock1.printTime();

		/* 
		Clock2
		Using tick method to check bonds of seconds and minutes
		*/

		Time clock2 = new Time(5, 59, 59);
		System.out.println("\nClock2= ");
		clock2.printTime();
		clock2.tick();
		clock2.printTime();
		for (int c=0; c<60; c++) {
			clock2.tick();
		}
		clock2.printTime();

		/* 
		Clock3
		Using tick method to check bonds of seconds, minutes and hours
		*/

		Time clock3 = new Time();
		clock3.setTime(23, 59, 59);
		System.out.println("\nClock3= ");
		clock3.printTime();
		clock3.tick();
		clock3.printTime();
		for (int x=0; x<60; x++) {
			clock3.tick();
		}
		clock3.printTime();

		/* 
		Clock4
		Checking the time after every change made of tick method
		*/

		Time clock4 = new Time();
		clock4.setTime(4, 58, 32);
		System.out.println("\nClock4= ");
		clock4.printTime();
		for (int y=0; y<100; y++) {
			clock4.tick();
			clock4.printTime();
		}

		/* 
		Clock5
		Evaluating numbers used to set the time in the method
		*/

		Time clock5 = new Time();
		clock5.setTime(21, 67, 90);
		System.out.println("\nClock5= ");
		clock5.printTime();

		/* 
		Clock6
		Evaluating numbers used to set the time in the constructor
		*/

		Time clock6 = new Time(26, 48, 78);
		System.out.println("\nClock6= ");
		clock6.printTime();

		/* 
		Clock7
		Evaluating numbers used to set the time and checking bonds
		*/

		Time clock7 = new Time(22, 90, 98);
		System.out.println("\nClock7= ");
		clock7.printTime();	
	}
}

		