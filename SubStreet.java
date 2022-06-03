package FireFighter;

import java.util.ArrayList;
/**
 * This class Generate a substreet and adds all connecting sub streets to it
 * @author Feras Alzahrani
 *
 */
public class SubStreet {
	// Main street name
	private String mainS;
	// Sub Street name
	private String name;
	// all adjacent sub streets
	private ArrayList<SubStreet> adjacentSubStreets = new ArrayList<>();
	// length of sub street
	private int length;

/**
 * A constructor to initialize a sub street information
 * @param mainS Main street name
 * @param Subname Sub Street name
 * @param length length of sub street
 */

public SubStreet(String mainS, String Subname, int length) {
		this.name = Subname;
		this.length = length;
		this.mainS = mainS;
	}

/**
 * A method to add all adjacent sub streets 
 * @param sub The sub street to be added
 */
public void addSubStreet(SubStreet sub) {
		adjacentSubStreets.add(sub);
	}
/**
 * 
 * @return sub street name
 */
	public String getName() {
		return name;
	}
/**
 * 
 * @return the Main street of the sub street
 */
	public String getMainName() {
		return mainS;
	}
/**
 * 
 * @return traffic percent on the sub street
 */
	public double getTrafficPercent() {
		return 1 + Math.random() * 0.5;
	}
/**
 * 
 * @return ArrayList of all sub streets that connects to this sub street 
 */
	public ArrayList<SubStreet> getAdjSub() {
		return adjacentSubStreets;
	}
	
	/**
	 * 
	 * @return length of this sub street
	 */
	public int getLength() {return length;}
}
