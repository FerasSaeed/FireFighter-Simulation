package FireFighter;
/**
 *  This is a class to deal with time data
 * @author Mohammed Khalid Zuayr
 *
 */
public class Clock {

	/**
	 * Time in hours
	 */
	private int hour;
	
	/**
	 * Time in minutes
	 */
	private int minute;
/**
 * Initialize time
 * @param h time in hours
 * @param m time in minutes
 */
	public Clock(int h, int m) {

		hour = h;
		minute = m;

	}
/**
 * to change hours
 * @param h time in hours
 */
	public void setHour(int h) {
		hour = h;

	}
/**
 * to change minutes
 * @param m time in minutes
 */
	public void setMinute(int m) {
		minute = m;

	}
/**
 * 
 * @return time in hours
 */
	public int getHour() {
		return hour;

	}
/**
 * 
 * @return time in minutes
 */
	public int getMinute() {
		return minute;
	}
/**
 * add time to current time
 * @param h time in hours
 * @param m time in minutes
 */
	public void addTime(int h, int m) {

	

		minute = minute + m;
		// Add minutes after that make sure if minute is bigger than 59 then hour + 1, and
		// minutes gets reset to the 60 minutes formula
		if (minute > 59) {
			hour = hour + 1;
			minute = minute - 60;
		}
		// Add hours, after that make sure if hour is bigger than 23 then reset to 0 and hour
		// gets reset to the 24 hours formula
		hour = hour + h;

		if (hour > 23) {
			hour = hour - 24;
		}

	}
/**
 * to substract time
 * @param h time in hours
 * @param m time in minutes
 */
	public void substractTime(int h, int m) {
		hour = hour - h;
		if (hour < 0) {
			hour = hour + 24;
		}

		minute = minute - m;
		if (minute < 0) {
			hour = hour - 1;
			minute = minute + 60;
		}

	}
/**
 * 
 * @return String representation of time 
 */
	public String getCurrentTime() {

		// turn time from 24 hours format to 12 hours format
		if (hour == 0) {
			hour = hour + 12;

			if (minute < 10) {
				return hour + ":" + "0" + minute + " " + "AM";
			}

			else
				return hour + ":" + minute + " " + "AM";
		}

		else if (hour >= 1 & hour <= 11) {
//check if hours or minutes are less than 10 thus adding a 0 to the left 
			if (hour < 10 & minute < 10) {
				return "0" + hour + ":" + "0" + minute + " " + "AM";
			}
			//check if hours or minutes are less than 10 thus adding a 0 to the left 

			if (hour < 10 & !(minute < 10)) {
				return "0" + hour + ":" + minute + " " + "AM";
			}
			//check if hours or minutes are less than 10 thus adding a 0 to the left 

			if (!(hour < 10) & minute < 10) {
				return hour + ":" + "0" + minute + " " + "AM";
			}
//if the time was from 0 to 11 change to am
			return hour + ":" + minute + " " + "AM";
		}

		else if (hour == 12) {
			//check if hours or minutes are less than 10 thus adding a 0 to the left 

			if (minute < 10) {
				return hour + ":" + "0" + minute + " " + "PM";
			}

			else
				return hour + ":" + minute + " " + "PM";
		}

		else if (hour >= 13 & hour <= 23) {
			hour = hour - 12;
			//check if hours or minutes are less than 10 thus adding a 0 to the left 

			if (hour < 10 & minute < 10) {
				return "0" + hour + ":" + "0" + minute + " " + "PM";
			}
			//check if hours or minutes are less than 10 thus adding a 0 to the left 

			if (hour < 10 & !(minute < 10)) {
				return "0" + hour + ":" + minute + " " + "PM";
			}
			//check if hours or minutes are less than 10 thus adding a 0 to the left 

			if (!(hour < 10) & minute < 10) {
				return hour + ":" + "0" + minute + " " + "PM";
			}
//if time was from 12 to 23 subtract 12 and change to pm
			return hour + ":" + minute + " " + "PM";
		}

		return hour + ":" + minute;
	}

}
