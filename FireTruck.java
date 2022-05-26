package clock;

package clock;

import Clock.SubStreet;

public class FireTruck extends FireStationTruck {


	private double extinguishingDuration; // Extinguishing duration of the fire

	
	
// Constructor takes information from the incident
	public FireTruck(Incident incident, Route route) {		
		//based on it make arrival time
			setArrivalTime(route, incident);
		//here we pass fire type, look into Incident class to see the types, based on it decide the duration, pass it to get the mission end time
			setMissionEndTime(getArrivalTime(), getExtinguishingDuration(incident.getFireType()));
		
	}
	

	
	
// set the arrivalTime to the incident location.
	public void setArrivalTime(Route route, Incident incident) {
		
		/* from route.getLength(), you get the distance to incident location, calculate the duration, change from minute To hours and minute
		then add it to departureTime.*/
		
		departureTime= new Clock(incident.getTimeOfFire.getHour(), incident.getTimeOfFire.getMinute()); //convert to (hh:mm)
		departureTime.addTime(0, 2); //add 2 minutes
		int velocity= 80/60; // convert the truck speed from hours -> minutes.
		double timeToIncident= route.getLength() / velocity;
		
		int hours = (int) (timeToIncident / 60); 
		int minutes = (int) (timeToIncident % 60);  
	
	//change the departure time to (hh:mm) then add it to timeToIncident.	
		arrivalTime= new Clock(departureTime.getHour(), departureTime.getMinute());
		arrivalTime.addTime(hours, minutes);		
	}
	
	

// calculate Extinguishing time.
	public double getExtinguishingDuration(String truckType) {
		
		// generate random numbers in each case.
		if(truckType.contains("Flammable Gasses"))
			return this.extinguishingDuration= Math.random() * (120 - 15 + 1) + 15;
		
		else if(truckType.contains("Flammable liquids"))
			return this.extinguishingDuration= Math.random() * (90 - 11 + 1) + 11;
		
		else if(truckType.contains("Electric equipment"))
			return this.extinguishingDuration= Math.random() * (101 - 25 + 1) + 25;
		
		else if(truckType.contains("Ordinary Combustibles"))
			return this.extinguishingDuration= Math.random() * (77 - 10 + 1) + 10;
			
	}
	



// compute the arrivalTime + extinguishingDuration
	public void setMissionEndTime(Clock arrivalTime, double extinguishingDuration) {
	
	//**the  extinguishingDuration is in minute, turn it to hours and minutes and use the method bellow
	//**for example 65 minutes is 1 hour and 5 minutes
		
		int hours = (int) (this.extinguishingDuration / 60); 
		int minutes = (int) (this.extinguishingDuration % 60);  
		
	//change the arrival time to (hh:mm) then add it to extinguish time.
		 missionEndTime = new Clock(arrivalTime.getHour(), arrivalTime.getMinute());
		 missionEndTime.addTime(hours, minutes);		 
		
	}
	
	

	// get the total time of the mission.
		public Clock getMissionEndTime() {
			return missionEndTime;
	}
	
	
	// get the arrivalTime to the incident location.
		public Clock getArrivalTime() { 
			return arrivalTime;
		}
	
	
	

	
	//---------------------------------------Ignore bellow--------------------------------------------------------------//
	@Override
	public void setArrivalTime(Incident incident) {
		// TODO Auto-generated method stub

	}

	@Override
	public Clock getMissionEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubStreet getCurrentSubStreet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route getRoute() {
		// TODO Auto-generated method stub
		return null;
	}

}

