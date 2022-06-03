package FireFighter;

import java.util.ArrayList;

/**
 * This class generates a random incident, with a random time and a random
 * location
 * 
 * @author Khaled Salem Baharithah
 *
 */
public class Incident implements FireReport {
	//number of incident
	private int incidentNum;
//location of incident
	private SubStreet location;
	//Time of fire
	private Clock timeOfFire;
	//Type of fire
	private String fireType;
	//if there is trapped people or not
	private boolean hasTrapped;
	//number of trapped people
	private int trappedVictims;

	/**
	 * The constructor generates a random information about the time of fire, the
	 * location, number of trapped people, and type of fire
	 * 
	 * @param subs this is an arrayList that contains all sub streets
	 * @param num  this is the number of the incident
	 */
	public Incident(ArrayList<SubStreet> subs, int num) {
		incidentNum = num;
		// **generate a random time by making a new Clock object like time of fire = new
		// Clock(random hour(0-23), random minute(0-60))
		// <-----
		int hours = (int) (Math.random() * 24);
		int minutes = (int) (Math.random() * 60);
		timeOfFire = new Clock(hours, minutes);

		// pick random index between 0 and ArrayList length
		location = subs.get((int) (Math.random() * subs.size()));

		double rand = 0;
		// ** pick random number either 1 or 0 to decide if hasTrapped is true or false,
		if (Math.random() < 0.75) {
			hasTrapped = false;

		} else
			hasTrapped = true;
		// **if there were trapped people, generate their number from 1 to 10 people
		if (hasTrapped == true) {
			rand = Math.random();
			trappedVictims = (int) (Math.random() * 5);
		}
		if (rand < 0.75) {
			if (trappedVictims == 0) {
				trappedVictims = 1;
			}

		} else
			trappedVictims = 4 + (trappedVictims);
		if (trappedVictims == 0) {
			trappedVictims = 1;
		}
		setFireType();
	}

	/**
	 * A maethod that returns the location
	 * 
	 * @return location
	 */
	public SubStreet getLocation() {
		return location;
	}

	/**
	 * A method that returns the type of fire that happened in an incident
	 * 
	 * @return fireType
	 */
	public String getFireType() {

		return fireType;
	}

	/**
	 * Generate random fire type to incident
	 */
	public void setFireType() {
		String[] types = { "Flammable Gases", "Flammable liquids", "Electric equipment", "Ordinary Combustibles" };
		fireType = types[(int) (Math.random() * (types.length))];

	}

	/**
	 * A method that returns the number of trapped people
	 * 
	 * @return trappedVictims
	 */
	public int getTrappedNum() {
		return trappedVictims;
	}

	/**
	 * A method that returns the time of fire
	 * 
	 * @return timeOfFire
	 */
	public Clock getTimeOfFire() {
		return timeOfFire;
	}

	/**
	 * A method that returns if the incident has trapped pepole
	 * 
	 * @return true or false
	 */
	public boolean getHasTrapped() {
		if (hasTrapped)
			return true;
		else
			return false;

	}

	/**
	 * A method that returns the number the incident
	 * 
	 * @return incidentNum
	 */
	public int getNum() {
		return incidentNum;
	}

	@Override
	/**
	 * A method that returns a String representing the report of the incident
	 */

	public String getAFullReport() {
		if (!hasTrapped) {
			trappedVictims = 0;
		}
		return String.format("%8s%23s%20s%27s%24s%10s%15s",incidentNum ,timeOfFire.getCurrentTime(), location.getMainName(),
				location.getName(), fireType, hasTrapped, trappedVictims);
	}
}