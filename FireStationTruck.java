package FireFighter;

import java.util.ArrayList;

/**
 * Abstract class that gives attributes to sub classes FireTruck and TrappeTruck
 * 
 * @author Mohammed Khalid Zuayr
 *
 */
public abstract class FireStationTruck {

	// Data Field
//Route from fire station to incident location

	protected Route route;

	// Fire Station Location location

	protected SubStreet location;
//Incident location
	protected SubStreet Incidentlocation;
	//Time of departure if a truck
	protected Clock departureTime;
	//Time of arrival to the incident location
	protected Clock arrivalTime;
	//Time of mission end
	protected Clock missionEndTime;
	//Incident object to get incident information needed
	protected Incident incident;
	//Trip to incident location duration
	protected double timeToIncident;
	//check if mission finished
	protected boolean finished = false;
	//time needed to cross each sub street
	protected ArrayList<Integer> timePerRoute = new ArrayList<>();
	//Current time based on steps
	protected Clock currentTime;
	//counter used for various loops
	protected int counter;
	//trip unique number, one number for each mission
	int tripNum;

	/**
	 * Default constructor
	 */
	// Constructor
	public FireStationTruck() {

	}

	// Methods

	// sets the value for the time the fire truck arrive at the location of incident
	/**
	 * Decide the arrival time based on route length and traffic, and speed of truck
	 * 
	 * @param incident Incident object to get the information needed for the truck
	 *                 to dispatch
	 * @param route    the route to the incident
	 */
	public abstract void setArrivalTime(Route route, Incident incident);

	/**
	 * A method that gives a report based on time passed in steps of 4 minutes
	 * 
	 * @param step to show progress of mission
	 */
	public abstract void currentReport(int step);

	/**
	 * 
	 * @return Time that the mission ended at
	 */
	public abstract Clock getMissionEndTime();

	/**
	 * @return boolean if the mission was finished or not
	 */
	public abstract boolean statues();

	/**
	 * 
	 * @return Arrival time
	 */
	public abstract Clock getArrivalTime();

	/**
	 * 
	 * @return Route to incident
	 */
	public abstract Route getRoute();

	/**
	 * 
	 * @return Mission Duration
	 */
	public abstract int getMissionDur();
}
