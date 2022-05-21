

abstract class FireStationTruck {
	
	//Data Field
	private Route route;
	private SubStreet location;
	private SubStreet Incidentlocation;
	private Clock departureTime; 
	private Clock arrivalTime; 
	private Clock missionEndTime;
	private SubStreet currentSubStreet;

	
	//Constructor
	public FireStationTruck() {
		
	}
	
	
	//Methods
	
	//sets the value for the time the fire truck arrive at the location of incident
	public void setArrivalTime(Clock arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	//return the value of the time the mission end as an integer array
	public Clock getMissionEndTime() {
		return missionEndTime;
	}
	
	//return the value of the time the fire truck arrive at the location of incident as an integer array
	public Clock getArrivalTime() {
		return arrivalTime;
	}

	//return the sub street location
	public SubStreet getCurrentSubStreet() {
		return currentSubStreet;
	}
	
	//return the route as an array list
	public Route getRoute(){
		return route;
		
	}
}
