class Time {
	private int hour;
	private int minute;
	private int second;
	private int remainder;
		
	public Time() {
		hour = 0;
		minute = 0;
		second = 0;
	}

	public Time(int hr, int min, int sec) {
		hour = hr;
		minute = min;
		second = sec;

		if (hour >= 24) {
			remainder = hour - 24;
			hour = remainder;
		}
				
		if (minute >= 60) {
			remainder = minute - 60;
			minute = remainder;
			hour++;
		}

		if (second >= 60) {
			remainder = second - 60;
			second = remainder;
			minute++;
		}
	}

	public void setTime(int hr, int min, int sec) {
		hour = hr;
		minute = min;
		second = sec;

		if (hour >= 24) {
			remainder = hour - 24;
			hour = remainder;
		}
		
		if (minute >= 60) {
			remainder = minute - 60;
			minute = remainder;
			hour++;
		}

		if (second >= 60) {
			remainder = second - 60;
			second = remainder;
			minute++;
		}
	}

	public void printTime() {  
		System.out.println(hour + ":" + minute + ":" + second);	
	}

	public void tick() {
		second++;
		if (second >= 60) {
			second = 0;
			minute++;
		} 
		
		if (minute >= 60) {
			minute = 0;
			hour++;
		} 
		
		if (hour >= 24) {
			hour = 0;
		}
	}	
}
