package clock;

public class Clock {

private int hour;
private int minute;

public Clock(int h, int m) {
	
	hour = h;
	minute = m;
	
	
}	

public void setHour(int h) {
	hour = h;
	
}

public void setMinute(int m) {
	minute = m;
	
}


public int getHour() {
	return hour;
	
}


public int getMinute() {
	return minute;
}


public void addTime(int h, int m) {
	
	hour = hour + h;
	//**after that make sure if hour is bigger than 23 then day + 1, and hour gets reset to the 24 hours formula
    if (hour > 23) {
    	hour = hour - hour;
    }
	
	
	minute = minute + m;
	//** after that make sure if minute is bigger than 59 then hour + 1, and minutes gets reset to the 60 minutes formula
	if (minute > 59) {
		hour = hour + 1;
		minute = minute - minute;
	}
}


public void substractTime(int h, int m) {
	hour = hour - h;
	if (hour < 0) {
		hour = hour + 24;
	}
	
	minute = minute - m;
	if(minute < 0) {
		hour = hour - 1;
		minute = minute + 60;
	}
	
}



public String getCurrentTime() {

	// **needs an if or switch statement to add am or pm bellow as well as transform time to 12 hours formula
	if (hour == 0) {
		hour = hour + 12;
		
		if (minute < 10){
			return hour + ":" + "0" + minute +" "+ "AM";
		}
		
		else
		return hour + ":" + minute +" "+ "AM";
	}
	
	
	
	else if (hour >= 1 & hour <= 11) {
		
		if (hour < 10 & minute < 10){
			return "0" + hour + ":" + "0" + minute +" "+ "AM";
		}
		
		if (hour < 10 & !(minute < 10)){
			return "0" + hour + ":" + minute +" "+ "AM";
		}
		
		if (!(hour < 10) & minute < 10){
			return hour + ":" + "0" + minute +" "+ "AM";
		}
		
		return hour + ":" + minute +" "+ "AM";
	}
	
	
	
	else if (hour == 12) {
		
		if (minute < 10){
			return hour + ":" + "0" + minute +" "+ "PM";
		}
		
		else
		return hour + ":" + minute +" "+ "PM";
	}
	
	
	
	else if (hour >= 13 & hour <= 23) {
		hour = hour - 12;
		
		if (hour < 10 & minute < 10){
			return "0" + hour + ":" + "0" + minute +" "+ "PM";
		}
		
		if (hour < 10 & !(minute < 10)){
			return "0" + hour + ":" + minute +" "+ "PM";
		}
		
		if (!(hour < 10) & minute < 10){
			return hour + ":" + "0" + minute +" "+ "PM";
		}
		
		return hour + ":" + minute +" "+ "PM";
	}
	
	 
			
	return hour + ":" + minute;
}

}
}
