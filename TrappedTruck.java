
public class TrappedTruck extends FireStationTruck {
	
	private int freeTrappedDuration; // time to release people.
	
	
	public TrappedTruck( Incident incident, Route route) {
		//based on it make arrival time
				setArrivalTime(route, incident);
		// here we pass number of trapped, look into Incident class to see the number, based on it decide the duration, pass it to get the mission end time		
				setMissionEndTime(getArrivalTime(), getFreeTrappedDuration(incident.getTrappedNum()));
				
	}
	
	
	
//set the arrivalTime to the incident location.
	public void setArrivalTime(Route route, Incident incident) {

		/* from route.getLength(), you get the distance to incident location, calculate the duration, change from minute To hours and minute
		then add it to departureTime.*/
		
		departureTime= new Clock(incident.getTimeOfFire.getHour(), incident.getTimeOfFire.getMinute()); //convert to (hh:mm)
		departureTime.addTime(0, 2); //add 2 minutes
		int velocity= 120/60; // convert the truck speed from hours -> minutes.
		double timeToIncident= route.getLength() / velocity;
		
		int hours = (int) (timeToIncident / 60); 
		int minutes = (int) (timeToIncident % 60);  
	
	//change the departure time to (hh:mm) then add it to timeToIncident.	
		arrivalTime= new Clock(departureTime.getHour(), departureTime.getMinute());
		arrivalTime.addTime(hours, minutes);	
	}
	
	
	
// get the duration of releasing people from fire location
	public int getFreeTrappedDuration(int trappedNum) {
	//generate random numbers for each case.
		if(trappedNum <=8)
			return freeTrappedDuration= (int) (Math.random()*(30-15+1)+15);
		else if(trappedNum <= 20)
			return freeTrappedDuration= (int) (Math.random()*(60-20+1)+20);
		else
			return freeTrappedDuration= (int) (Math.random()*(112-50+1)+50);
		
	}
	
	
	
//compute the arrivalTime + FreeTrappedDuration   
	public void setMissionEndTime(Clock arrivalTime, int FreeTrappedDuration) {
		
		int hours = (int) (this.freeTrappedDuration / 60); //since both are ints, you get an int
		int minutes = (int) (this.freeTrappedDuration % 60);  
		
	//change the arrival time to (hh:mm) then add it to freeTrapped time.
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
		
		

}




	
	













