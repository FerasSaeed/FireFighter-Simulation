package FireFighter;



/**
 * This class generates Trapped trucks and their trip information
 * 
 * @author Abdulqader Assaggaf
 *
 */
public class TrappedTruck extends FireStationTruck {

	private int freeTrappedDuration; // time to release people.
	final private String truckType = "Trapped Truck";

	/**
	 * generates the current time of incident, the route, and gives a number to the
	 * trip to the incident location
	 * 
	 * @param inc   Incident object to get the information needed for the trapped
	 *              truck to dispatch
	 * @param route the route to the incident
	 * @param num   the number of the trip so it can be easier to analyze the
	 *              trapped truck trip
	 */
	public TrappedTruck(Incident inc, Route route, int num) {
		tripNum = num;
		// based on it make arrival time
		currentTime = new Clock(inc.getTimeOfFire().getHour(), inc.getTimeOfFire().getMinute());
		incident = inc;
		this.route = route;
		setArrivalTime(route, incident);
		setFreeTrappedDuration(incident.getTrappedNum());
		// here we pass number of trapped, look into Incident class to see the number,
		// based on it decide the duration, pass it to get the mission end time
		setMissionEndTime(getArrivalTime(), freeTrappedDuration);
		int time = 0;
		for (SubStreet sub : route.getRoute()) {
			time = time + (int) (sub.getLength() / (double) (80 / 60));
			timePerRoute.add(time);
		}
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
		int velocity = 120 / 60; // convert the truck speed from hours -> minutes.
		double timeToIncident = route.getLength() / velocity;

		int hours = (int) (timeToIncident / 60);
		int minutes = (int) (timeToIncident % 60);

		// change the departure time to (hh:mm) then add it to timeToIncident.
		arrivalTime = new Clock(departureTime.getHour(), departureTime.getMinute());
		arrivalTime.addTime(hours, minutes);
	}

	/**
	 * Time to free trapped people based on their numbers
	 * 
	 * @param trappedNum number of people who are trapped
	 */
	public void setFreeTrappedDuration(int trappedNum) {
		// generate random numbers for each case.
		if (trappedNum <= 8)
			freeTrappedDuration = (int) (Math.random() * (30 - 15 + 1) + 15);
		else if (trappedNum <= 20)
			freeTrappedDuration = (int) (Math.random() * (60 - 20 + 1) + 20);
		else
			freeTrappedDuration = (int) (Math.random() * (112 - 50 + 1) + 50);

	}

	/**
	 * Decide when the mission ends based on when the truck arrived and how long it
	 * took to put down fire
	 * 
	 * @param arrivalTime         time of arrival to incident scene
	 * @param FreeTrappedDuration time it takes to put down fire
	 */
	public void setMissionEndTime(Clock arrivalTime, int FreeTrappedDuration) {

		int hours = (int) (this.freeTrappedDuration / 60); // since both are ints, you get an int
		int minutes = (int) (this.freeTrappedDuration % 60);

		// change the arrival time to (hh:mm) then add it to freeTrapped time.
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

	@Override

	public Route getRoute() {
		// TODO Auto-generated method stub
		return route;
	}
	
	
	@Override
	public int getMissionDur() {
		return (int) (freeTrappedDuration + timeToIncident);
	}

	public boolean statues() {
		return finished;
	}

}
