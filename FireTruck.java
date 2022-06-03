package FireFighter;


/**
 * This class generates fire trucks and their trip information
 * 
 * @author Abdulqader Assaggaf
 *
 */
public class FireTruck extends FireStationTruck {

	private int extinguishingDuration; // Extinguishing duration of the fire
	private String fireType; // type of fire cause
	final private String truckType = "Fire Truck"; // type of this class truck

	/**
	 * generates the current time of incident, the route, and gives a number to the
	 * trip to the incident location
	 * 
	 * @param inc   Incident object to get the information needed for the fire truck
	 *              to dispatch
	 * @param route the route to the incident
	 * @param num   the number of the trip so it can be easier to analyze the fire
	 *              truck trip
	 */
	public FireTruck(Incident inc, Route route, int num) {
		tripNum = num;// Number of this trip
		// based on it make arrival time
		currentTime = new Clock(inc.getTimeOfFire().getHour(), inc.getTimeOfFire().getMinute());
		incident = inc;
		this.route = route;
		setArrivalTime(route, incident);
		fireType = incident.getFireType();
		setExtinguishingDuration(fireType); // extinguishing depends on type of fire
		int time = 0;
		// get time needed to cross each sub street
		for (SubStreet sub : route.getRoute()) {
			time = time + (int) (sub.getLength() / (double) (80 / 60));
			timePerRoute.add(time);

		}
		/*
		 * here we pass fire type, based on it decide the duration, pass it to get the
		 * mission end time
		 *
		 */
		setMissionEndTime(getArrivalTime(), getExtinguishingDuration());
	}

	@Override

	public void setArrivalTime(Route route, Incident incident) {

		/*
		 * from route.getLength(), you get the distance to incident location, calculate
		 * the duration, change from minute To hours and minute then add it to
		 * departureTime.
		 */

		departureTime = new Clock(incident.getTimeOfFire().getHour(), incident.getTimeOfFire().getMinute()); // convert
																												// to
																												// (hh:mm)
		departureTime.addTime(0, 2); // add 2 minutes
		double velocity = 80 / 60; // convert the truck speed from hours -> minutes.
		timeToIncident = route.getLength() / velocity;

		int hours = (int) (timeToIncident / 60);
		int minutes = (int) (timeToIncident % 60);

		// change the departure time to (hh:mm) then add it to timeToIncident.
		arrivalTime = new Clock(departureTime.getHour(), departureTime.getMinute());
		arrivalTime.addTime(hours, minutes);
	}

	/**
	 * Based on fire type, decide needed time to put down fire
	 * 
	 * @param fireType The type of fire from incident
	 */
	public void setExtinguishingDuration(String fireType) {

		// generate random numbers in each case.
		if (fireType.contains("Flammable Gasses"))
			extinguishingDuration = (int) (Math.random() * (120 - 15 + 1) + 15);

		else if (fireType.contains("Flammable liquids"))
			extinguishingDuration = (int) (Math.random() * (90 - 11 + 1) + 11);

		else if (fireType.contains("Electric equipment"))
			extinguishingDuration = (int) (Math.random() * (101 - 25 + 1) + 25);

		else
			fireType.contains("Ordinary Combustibles");
		extinguishingDuration = (int) (Math.random() * (77 - 10 + 1) + 10);

	}

	/**
	 * 
	 * @return extinguishing Duration
	 */
	public double getExtinguishingDuration() {
		return extinguishingDuration;
	}

	/**
	 * Decide when the mission ends based on when the truck arrived and how long it
	 * took to put down fire
	 * 
	 * @param arrivalTime           time of arrival to incident scene
	 * @param extinguishingDuration time it takes to put down fire
	 */
	public void setMissionEndTime(Clock arrivalTime, double extinguishingDuration) {

		// **the extinguishingDuration is in minute, turn it to hours and minutes and
		// use the method bellow
		// **for example 65 minutes is 1 hour and 5 minutes

		int hours = (int) (extinguishingDuration / 60);
		int minutes = (int) (extinguishingDuration % 60);

		// change the arrival time to (hh:mm) then add it to extinguish time.
		missionEndTime = new Clock(arrivalTime.getHour(), arrivalTime.getMinute());
		missionEndTime.addTime(hours, minutes);

	}
public void currentReport(int step) {
//what the truck is doing now
		String currentAct = "";
		// until the the mission is finished, keep printing the report
		if (!finished) {
			// if less than 2 minutes after fire time, truck crew still preparing
			if (step < 2) {
				currentAct = "Preparing";
			}
			// if more than 2 minutes after fire time, and less than the trip time, truck is
			// still on the way

			if (step > 2 && step < timeToIncident) {
				currentAct = "On the way";
			}
			// if step is bigger than trip duration but smaller than mission end duration,
			// they are still putting down fire
			if (step > timeToIncident && step < (extinguishingDuration + timeToIncident)) {
				currentAct = "Putting down fire";
			} // if step is bigger than mission duration, mission accomplished
			if (step > timeToIncident && step > (extinguishingDuration + timeToIncident)) {
				currentAct = "Fire put down";
				finished = true;
			}
//counter to determine current sub street
			if (step < timePerRoute.get(timePerRoute.size() - 1)) {
				counter = 0;
				while (counter < timePerRoute.size()) {
					if (step < timePerRoute.get(counter)) {
						break;
					}
					counter++;

				}

			}
			String missionDuration = "";
			// if mission finished display duration

			if (finished) {

				missionDuration = Integer.toString((int) (extinguishingDuration + timeToIncident)) + " minutes";
			}
			// display report

			System.out.printf("%10s%10s%28s%30s%14s%20s%21s%26s%22s", truckType, tripNum,
					route.getRoute().get(counter).getMainName(), route.getRoute().get(counter).getName(),
					currentTime.getCurrentTime(), currentAct, finished, fireType, missionDuration);
			System.out.println();
		}
		// add step time to current time
		currentTime.addTime(0, 4);

	}

	@Override

	public Clock getMissionEndTime() {
		return missionEndTime;
	}

	@Override
	public Clock getArrivalTime() {
		return arrivalTime;
	}
	
	public boolean statues() {
		return finished;
	}

	@Override
	public Route getRoute() {
		return route;
	}

	public int getMissionDur() {
		return (int) (extinguishingDuration + timeToIncident);
	}

}


