
public class TrappedTruck extends FireStationTruck {
	
	private int freeTrappedDuration; // time to release people.
	
	
	public TrappedTruck( Incident incident, SubStreet location, Route route) {
		//here generate route between incident and fire truck location
				route.makeRoute(location, incident.getLocation());
		//based on it make arrival time
				setArrivalTime(route, incident);
		// here we pass number of trapped, look into Incident class to see the number, based on it decide the duration, pass it to get the mission end time		
				getMissionEndTime(getArrivalTime(), setFreeTrappedDuration(incident.getTrappedNum()));
				
	}
	
	
	
//set the arrivalTime to the incident location.
	public void setArrivalTime(Route route, Incident incident) {
		arrivalTime= route.getLength(); 
		arrivalTime= new Clock(arrivalTime.getHour(),arrivalTime.getMinute());
		departureTime = incident.getTimeOfFire();
		departureTime= new Clock(TimeOfFire.getHour(), TimeOfFire.getMinute());
		departureTime.addTime(0, 2);
	}
	
	
	
	public int setFreeTrappedDuration(int trappedNum) {
	//generate random numbers for each case.
		if(trappedNum <=8)
			return freeTrappedDuration= (int) (Math.random()*(30-15+1)+15);
		else if(trappedNum <= 20)
			return freeTrappedDuration= (int) (Math.random()*(60-20+1)+20);
		else
			return freeTrappedDuration= (int) (Math.random()*(112-50+1)+50);
		
	}
	
	
	
//compute the arrivalTime + FreeTrappedDuration   
	public Clock getMissionEndTime(Clock arrivalTime, int FreeTrappedDuration) {
		
		int hours = (int) (this.freeTrappedDuration / 60); //since both are ints, you get an int
		int minutes = (int) (this.freeTrappedDuration % 60);  
		
	//change the arrival time to (hh:mm) then add it to freeTrapped time.
		 missionEndTime = new Clock(arrivalTime.getHour(), arrivalTime.getMinute());
		 missionEndTime.addTime(hours, minutes);		 
		
		 return missionEndTime;
	}
		
}

	
	







